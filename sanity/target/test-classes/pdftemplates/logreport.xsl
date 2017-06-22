<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">
	<xsl:template name="logreport">
	
	<fo:block margin-top="15pt"></fo:block>
	
		<fo:block margin-top="15pt" border="0.01pt solid lightgray"
			font-size="12px" font-family="sans-serif" text-align="left"
			font-weight="bold" padding-left="3pt" padding-top="2pt"
			padding-bottom="2pt" background-color="darkgray">Log Report</fo:block>
		<xsl:for-each select="./logs">
			<xsl:choose>
				<xsl:when test="position() mod 2 = 1">
					<fo:block background-color="#DEDEDE" font-size="10" font-family="Courier New"
				hyphenate="true">
				<xsl:value-of select="log" />
			</fo:block>
				</xsl:when>
				<xsl:otherwise>
				<fo:block font-size="10" font-family="Courier New" background-color="#BFBFBF" hyphenate="true">
				<xsl:value-of select="log" />
			</fo:block>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>