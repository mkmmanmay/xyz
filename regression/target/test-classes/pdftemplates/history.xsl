<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">

		<xsl:template name="history" >		

		<fo:block font-size="8px" margin-top="5pt">
			<fo:table table-layout="fixed" width="100%" margin="0pt" border-collapse="collapse"  >
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="65px" />
				<fo:table-column column-width="65px" />
				<fo:table-column column-width="65px" />
				<fo:table-column column-width="65px" />
				<fo:table-column column-width="65px" />
				<fo:table-column column-width="80px" />

				<fo:table-header>
					<fo:table-row font-weight="bold"  border-bottom-style="none">
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center" padding-top="3pt" border-left="0.8pt solid black" background-color="lightgray" >
							<fo:block>DATE</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center" padding-top="3pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>RESULT</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center" padding-top="3pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>DURATION</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center"  padding-top="3pt" color="green" padding-bottom="1pt" background-color="lightgray">
							<fo:block>PASS</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center" padding-top="3pt" color="red" padding-bottom="1pt" background-color="lightgray">
							<fo:block>FAIL</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center" padding-top="3pt" color="gray" padding-bottom="1pt" background-color="lightgray">
							<fo:block>SKIP</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" border-right="0.8pt solid black" text-align="center" padding-top="3pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>Failed Test Step</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-header>

				<fo:table-body>
				<xsl:for-each select="./history">
					<fo:table-row>
						<fo:table-cell border="0.1pt solid gray" border-left="0.8pt solid black" padding-left="5pt" padding-top="1pt" padding-bottom="1pt">
							<fo:block><xsl:value-of select="@runtimedate" /></fo:block>
						</fo:table-cell>
						
						<fo:table-cell border="0.1pt solid gray" text-align="center" padding-top="1pt" padding-bottom="1pt">
						<fo:block>
										<xsl:choose>
											<xsl:when test="@historystatus = 'PASS'">
												<fo:block color="green">PASS</fo:block>
											</xsl:when>
											<xsl:when test="@historystatus = 'N/A'">
												<fo:block color="gray">N/A</fo:block>
											</xsl:when>
											<xsl:when test="@historystatus = 'FAIL'">
												<fo:block color="red">FAIL</fo:block>
											</xsl:when>
										</xsl:choose>
						</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" text-align="center" padding-top="1pt" padding-bottom="1pt">
							<fo:block><xsl:value-of select="@duration" /> sec</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" color="green" text-align="center"  padding-top="1pt" padding-bottom="1pt">
							<fo:block><xsl:value-of select="@pass" /></fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" color="red" text-align="center" padding-top="1pt" padding-bottom="1pt">
							<fo:block><xsl:value-of select="@fail" /></fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" color="gray" text-align="center" padding-top="1pt" padding-bottom="1pt">
							<fo:block><xsl:value-of select="@skip" /></fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-right="0.8pt solid black" text-align="center" padding-top="1pt" padding-bottom="1pt">
							<fo:block><xsl:value-of select="@failedtestname" /></fo:block>
						</fo:table-cell>
					</fo:table-row>
				</xsl:for-each>
					
				</fo:table-body>
			</fo:table>
		</fo:block>
		
	</xsl:template>	

</xsl:stylesheet>