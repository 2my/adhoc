package parsing;

import java.io.Reader;
import java.io.StringReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * @author tommy

    <dependency>
      <groupId>org.apache.commons</groupId>
      <artifactId>commons-csv</artifactId>
      <version>1.3</version>
    </dependency>
*/
public class CsvParser {

	public static void main( String[] args ) throws Exception {
		Reader in = new StringReader(
				"Fødselsnummer;Personnummer;Alvorlighetsgrad;Linjenummer;Feilkode;Feiltekst;Opptjeningskontrolltype;Kilde;Flyt;Kommentar" +
				"\n19180510;12352;FEIL;2;642;Mangler tilgangsmelding for første start i statlig stilling.;STILLINGSHISTORIKK;OPPTJENINGSKONTROLL;Lagt på fiktive data og utført opptjeningskontroll på disse;"
			);
		CSVFormat format	= CSVFormat.EXCEL.withDelimiter(';').withHeader();	// CSVFormat.RFC4180
		Iterable<CSVRecord> records = format.parse(in);
		for (CSVRecord record : records) {
		    String fnr = record.get("Fødselsnummer");
		    // record.toMap();
		    String personnummer = record.get("Alvorlighetsgrad");
		    System.out.println( fnr + " har " + personnummer );
		}
	}

}
