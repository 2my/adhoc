:: see http://xalan.apache.org/xalan-j/commandline.html
:: mvn compile will put libraries in place

:: Run: xslt example.xsl example.xml

set CP=xalan.jar;serializer.jar;xml-apis.jar;xercesImpl.jar

java -cp %CP% org.apache.xalan.xslt.Process -IN %2 -XSL %1 -OUT result.xml

