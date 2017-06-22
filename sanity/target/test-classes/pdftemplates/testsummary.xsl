<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">

	<xsl:import href="./summary.xsl" />

	<xsl:template name="testsummary">

		<fo:block margin-top="15pt">
			<fo:block border="0.01pt solid lightgray" font-size="10px"
				font-family="sans-serif" text-align="left" font-weight="bold"
				padding-left="3pt" padding-top="2pt" padding-bottom="2pt"
				background-color="lightgray">
				<xsl:value-of select="@name" />
			</fo:block>
		</fo:block>
		
		<!-- <fo:block margin-top="10pt" font-size="10px" font-family="sans-serif" text-align="center" font-weight="bold">Test Summary</fo:block>

		<xsl:call-template name="summary" / -->>

	</xsl:template>

</xsl:stylesheet>