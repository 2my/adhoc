<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="xml" omit-xml-declaration="yes" indent="yes"/>

<xsl:variable name='newline'><xsl:text>
</xsl:text></xsl:variable>

<xsl:variable name='interval'><xsl:value-of select="/TOP/PublicationTimeInterval/@v"/></xsl:variable>

<xsl:template match="/">
<NtcToEntso>
	<xsl:value-of select="$newline"/>
  <xsl:text>START-END=</xsl:text><xsl:value-of select="$interval"/>
	<xsl:value-of select="$newline"/>
  <xsl:for-each select="TOP/PublicationTimeSeries">
    <xsl:sort select="TimeSeriesIdentification/@v" />
    <ts>
    	<xsl:value-of select="OutArea/@v"/><xsl:text> </xsl:text><xsl:value-of select="InArea/@v"/>
      <xsl:value-of select="$newline"/>
      <xsl:apply-templates select="Period/TimeInterval"/>
      <xsl:value-of select="$newline"/>
      <xsl:apply-templates select="Period/Interval"/>
    </ts>
		<xsl:value-of select="$newline"/>
  </xsl:for-each>
</NtcToEntso>
</xsl:template>

<xsl:template match="TimeInterval[@v=$interval]">interval=START-END</xsl:template>
<xsl:template match="TimeInterval">interval=<xsl:value-of select="@v"/></xsl:template>

<xsl:template match="Interval">
	<xsl:value-of select="1 + count( preceding-sibling::Interval )"/>: <xsl:value-of select="Qty/@v"/>
  <xsl:value-of select="$newline"/>
</xsl:template>
 
</xsl:stylesheet>