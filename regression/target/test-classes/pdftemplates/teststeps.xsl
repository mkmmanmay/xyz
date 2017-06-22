<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">
	
	<xsl:template name="teststeps">
	
		<fo:block margin-top="10pt" font-size="10px" font-family="sans-serif" text-align="center" font-weight="bold">Test Steps</fo:block>

		<fo:block font-size="8px" margin-top="5pt">
			<fo:table table-layout="fixed" width="100%" border-bottom="0.8pt solid black" border-collapse="collapse">
				<fo:table-column column-width="20px" />
				<fo:table-column column-width="proportional-column-width(1)" />				
				<fo:table-column column-width="70px" />
				<fo:table-column column-width="40px" />
				<fo:table-column column-width="200px" />

				<fo:table-header>
					<fo:table-row font-weight="bold" border-bottom-style="none">
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" border-left="0.8pt solid black" text-align="center" padding-top="2pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>#</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="left" padding-left="5pt" padding-top="2pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>Test Step</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center" padding-top="2pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>Duration (sec)</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center" padding-top="2pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>Status</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" border-right="0.8pt solid black" text-align="left" padding-left="5pt" padding-top="2pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>Message</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-header>
				<fo:table-body >
					<xsl:for-each select="./test-method">
						<xsl:variable name="duration"  select="@duration-ms div 1000" />
						<fo:table-row >
							<fo:table-cell border="0.1pt solid gray" border-left="0.8pt solid black" padding-left="5pt" padding-top="1pt" padding-bottom="1pt">
								<fo:block><xsl:value-of select="@sequence" /></fo:block>
							</fo:table-cell>
							<fo:table-cell border="0.1pt solid gray" text-align="left" padding-left="5pt" padding-top="1pt" padding-bottom="1pt">
								<fo:block><xsl:value-of select="@name" /></fo:block>
							</fo:table-cell>
							<fo:table-cell border="0.1pt solid gray" text-align="right" padding-right="10pt" padding-top="1pt" padding-bottom="1pt">
								<fo:block><xsl:value-of select="format-number($duration, '###,###.0')" /></fo:block>
							</fo:table-cell>
							<fo:table-cell border="0.1pt solid gray" text-align="left" padding-left="10pt" padding-top="1pt" padding-bottom="1pt" >
								<fo:block>
									<xsl:choose>
										<xsl:when test="@status = 'PASS'">
											<fo:block color="green">PASS</fo:block>
										</xsl:when>
										<xsl:when test="@status = 'SKIP'">
											<fo:block color="gray">SKIP</fo:block>
										</xsl:when>
										<xsl:when test="@status = 'FAIL'">
											<fo:block color="red">FAIL</fo:block>
										</xsl:when>
									</xsl:choose>
								</fo:block>
							</fo:table-cell>
							<fo:table-cell border="0.1pt solid gray" border-right="0.8pt solid black" text-align="left" padding-left="5pt" padding-top="1pt" padding-bottom="1pt">
								<fo:block><xsl:value-of select="./exception/message" /></fo:block>
							</fo:table-cell>
						</fo:table-row>
					</xsl:for-each>
				</fo:table-body>
			</fo:table>
		</fo:block>

	</xsl:template>

</xsl:stylesheet>