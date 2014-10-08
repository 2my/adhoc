object HelloWorld {
	// in repl use :paste mode
	val borders = Map(
		"DE" -> List("DK1", "DK2", "SE4"),
		"DK1" -> List("DE", "DK2", "NO2", "SE3"),
		"DK2" -> List("DE", "DK1", "SE4"),
		"EE" -> List("FI", "LV"),
		"FI" -> List("EE", "SE1", "SE3"),
		"LT" -> List("LV"),
		"LV" -> List("EE", "LT"),
		"NL" -> List("NO2"),
		"NO1" -> List("NO2", "NO3", "NO5", "SE3"),
		"NO2" -> List("DK1", "NL", "NO1", "NO5"),
		"NO3" -> List("NO1", "NO4", "SE2"),
		"NO4" -> List("NO3", "SE1", "SE2"),
		"NO5" -> List("NO1", "NO2"),
		"PL" -> List("SE4"),
		"SE1" -> List("FI", "NO4", "SE2"),
		"SE2" -> List("NO3", "NO4", "SE1", "SE3"),
		"SE3" -> List("DK1", "FI", "NO1", "SE2", "SE4"),
		"SE4" -> List("DE", "DK2", "PL", "SE3")
	);
	val template = """<Row> <Element Name="Entity1" Value="Area:From=FROM"/> <Element Name="Entity2" Value="Area:To=TO"/> </Row>""";

	def fromTo( from: String, to: String )	= template.replace( "FROM", from ).replace( "TO", to );

  def main(args: Array[String]) {
    println("Hello, world!")

		val sorted = borders.keys.toList.sorted.asInstanceOf[List[String]]
  	sorted.foreach( key => borders( key ).foreach( value => println( fromTo( key, value ) + fromTo( value, key) )  ) )
  }
}
