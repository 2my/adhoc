
import java.io.*;
import java.util.*;

import org.jdom2.*;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.util.IteratorIterable;
import org.xml.sax.InputSource;

/** @author Tommy Skodje
		<dependency>
			<groupId>org.jdom</groupId>
			<artifactId>jdom2</artifactId>
			<version>2.0.6</version>
			<scope>test</scope>
		</dependency>
*/
public class Jdom2 {

	public void jdomDemo( String xml ) throws Exception {
		Document scheduleMsg	= parseXml(xml);
		for (Element ts: scheduleMsg.getDescendants( Filters.element( "ScheduleTimeSeries" ) )) {
			String tsId	= ts.getChild( "SendersTimeSeriesIdentification" ).getAttribute( "v" ).getValue();
			List<Long> values	= getValues( ts.getDescendants( Filters.element( "Qty" ) ));
			System.out.println(tsId + values);
		}
		// ScheduleMessage scheduleMsg	= ScheduleMessageDocument.Factory.parse( dataSent ).getScheduleMessage();
		// assertThat( strArg.getValue(), containsString( "whatever" ) );
	}

	private List<Long> getValues( IteratorIterable<Element> valueList ) {
		List<Long> values	= new ArrayList<Long>();
		for ( Element valueEl: valueList )
			values.add( Math.round( Double.parseDouble( valueEl.getAttribute( "v" ).getValue() ) ) );
		return values;
	}

	private Document parseXml( String xml ) {
    SAXBuilder jdomBuilder = new SAXBuilder();
		try {
			return jdomBuilder.build( new InputSource( new StringReader( xml ) ) );
		} catch ( Exception e ) {
			throw new RuntimeException( e );
		}
	}

}
