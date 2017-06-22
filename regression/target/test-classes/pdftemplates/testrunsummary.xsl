<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">

		<xsl:import href="./summary.xsl"/>  

		<xsl:template name="testrunsummary" >			
		
			<fo:block margin-top="5pt">
				<fo:block border="0.01pt solid lightgray" font-size="12px"
					font-family="sans-serif" text-align="left" font-weight="bold"
					padding-left="3pt" padding-top="2pt" padding-bottom="2pt"
					background-color="darkgray">Run Summary</fo:block>
			</fo:block>
			
			<xsl:call-template name="summary"/>
		
		</xsl:template>

</xsl:stylesheet>