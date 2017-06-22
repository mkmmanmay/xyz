<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">

		<xsl:template name="suitedetails" >		

		<xsl:variable name="passedCount"  select="@passed" />
		<xsl:variable name="failedCount"  select="@failed" />
		<xsl:variable name="skippedCount" select="@skipped" />
		<xsl:variable name="testCount"    select="@total" />

		<xsl:variable name="passedDuration"  select="@passed-duration-ms div 1000" />
		<xsl:variable name="failedDuration"  select="@failed-duration-ms div 1000" />
		<xsl:variable name="skippedDuration" select="@skipped-duration-ms div 1000" />
		<xsl:variable name="testDuration"    select="@duration-ms div 1000" />


		<xsl:variable name="passedRate"  select="$passedCount div $testCount" />
		<xsl:variable name="failedRate"  select="$failedCount div $testCount" />
		<xsl:variable name="skippedRate" select="$skippedCount div $testCount" />

		<xsl:variable name="passedDurationRate" 	select="$passedDuration div $testDuration" />
		<xsl:variable name="failedDurationRate"  select="$failedDuration div $testDuration" />
		<xsl:variable name="skippedDurationRate" select="$skippedDuration div $testDuration" /> 	
		
		<fo:block font-size="8px" margin-top="5pt">
			<fo:table table-layout="fixed" width="100%" margin="0pt" border-collapse="collapse"  >
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="80px" />
				<fo:table-column column-width="80px" />
				<fo:table-column column-width="80px" />
				<fo:table-column column-width="80px" />

				<fo:table-header>
					<fo:table-row font-weight="bold"  border-bottom-style="none">
						<fo:table-cell  border="0.1pt solid gray" border-top="0.8pt solid black" border-left="0.8pt solid black" background-color="lightgray" >
							<fo:block></fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center" padding-top="3pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>TOTAL</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center"  padding-top="3pt" padding-bottom="1pt" color="green" background-color="lightgray">
							<fo:block>PASS</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center" padding-top="3pt" padding-bottom="1pt" color="red" background-color="lightgray">
							<fo:block>FAIL</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" border-right="0.8pt solid black" text-align="center" padding-top="3pt" padding-bottom="1pt" color="gray" background-color="lightgray">
							<fo:block>SKIP</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-header>

				<fo:table-body>
					<fo:table-row>
						<fo:table-cell border="0.1pt solid gray" border-left="0.8pt solid black" padding-left="5pt" padding-top="1pt" padding-bottom="1pt">
							<fo:block>Test Step Count</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" text-align="center" padding-top="1pt" padding-bottom="1pt">
							<fo:block><xsl:value-of select="format-number($testCount, '###,###')" /></fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" text-align="center" color="green" padding-top="1pt" padding-bottom="1pt">
							<fo:block><xsl:value-of select="format-number($passedCount, '###,###')" />&#160;(<xsl:value-of select="format-number($passedRate,'0%')" />)</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" text-align="center" color="red" padding-top="1pt" padding-bottom="1pt">
							<fo:block><xsl:value-of select="format-number($failedCount, '###,###')" />&#160;(<xsl:value-of select="format-number($failedRate,'0%')" />)</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-right="0.8pt solid black" text-align="center" color="gray" padding-top="1pt" padding-bottom="1pt">
							<fo:block><xsl:value-of select="format-number($skippedCount, '###,###')" />&#160;(<xsl:value-of select="format-number($skippedRate,'0%')" />)</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell border="0.1pt solid gray" border-left="0.8pt solid black" padding-left="5pt" padding-top="1pt" padding-bottom="1pt">
							<fo:block>Duration</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" text-align="center" padding-top="1pt" padding-bottom="1pt">
							<fo:block><xsl:value-of select="format-number($testDuration, '###,###.0')" /> sec</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" text-align="center" color="green" padding-top="1pt" padding-bottom="1pt">
							<fo:block><xsl:value-of select="format-number($passedDuration, '###,###.0')" /> sec   (<xsl:value-of select="format-number($passedDurationRate,'0%')" />)</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" text-align="center" color="red" padding-top="1pt" padding-bottom="1pt">
							<fo:block><xsl:value-of select="format-number($failedDuration, '###,###.0')" /> sec   (<xsl:value-of select="format-number($failedDurationRate,'0%')" />)</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-right="0.8pt solid black" text-align="center" color="gray" padding-top="1pt" padding-bottom="1pt">
							<fo:block><xsl:value-of select="format-number($skippedDuration, '###,###.0')" /> sec   (<xsl:value-of select="format-number($skippedDurationRate,'0%')" />)</fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell border="0.1pt solid gray" border-left="0.8pt solid black" padding-left="5pt" padding-top="1pt" padding-bottom="1pt">
							<fo:block>Started at </fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-right="0.8pt solid black" text-align="left" padding-left="5pt" padding-top="1pt" padding-bottom="1pt" number-columns-spanned="4">
							<fo:block><xsl:value-of select="@started-at" /></fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell border="0.1pt solid gray" border-left="0.8pt solid black" padding-left="5pt" padding-top="1pt" padding-bottom="1pt">
							<fo:block>Finished at </fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" text-align="left" border-right="0.8pt solid black" padding-left="5pt" padding-top="1pt" padding-bottom="1pt" number-columns-spanned="4">
							<fo:block><xsl:value-of select="@finished-at" /></fo:block>
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell border="0.1pt solid gray" border-left="0.8pt solid black" padding-left="5pt" padding-top="1pt" padding-bottom="1pt">
							<fo:block>Status</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-right="0.8pt solid black" text-align="left"	padding-left="5pt" padding-top="1pt" padding-bottom="1pt"	number-columns-spanned="4">
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
						</fo:table-cell>
					</fo:table-row>
					<fo:table-row>
						<!-- <fo:table-cell border="0.1pt solid gray" border-left="0.8pt solid black" border-bottom="0.8pt solid black" padding-left="5pt" padding-top="1pt" padding-bottom="1pt">
							<fo:block>Description</fo:block>
						</fo:table-cell> -->
						<fo:table-cell border="0.1pt solid gray" border-right="0.8pt solid black" border-bottom="0.8pt solid black" text-align="left"	padding-left="5pt" padding-top="1pt" padding-bottom="1pt"	number-columns-spanned="4">
							<fo:block color="gray"><xsl:value-of select="@testDescription" /></fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
		</fo:block>
		
	</xsl:template>	

</xsl:stylesheet>