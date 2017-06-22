<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">

	<xsl:template name="teststepdetails">
		<xsl:param name="testStatus" />
		<xsl:param name="reportDetailLevel" />
		<fo:block margin-top="10pt" font-size="10px" font-family="sans-serif" text-align="center" font-weight="bold">Test Details</fo:block>
		<fo:block font-size="8px" margin-top="5pt">
			<xsl:variable name="verbosityType1">
				<xsl:value-of select="../../@verbosity" />
			</xsl:variable>
			<fo:table table-layout="fixed" width="100%" border-bottom="0.8pt solid black" border-collapse="collapse">
							
				<fo:table-column column-width="20px" />
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="120px" />
				<fo:table-column column-width="60px" />
				<fo:table-column column-width="60px" />
				<fo:table-column column-width="70px" />
				<fo:table-column column-width="40px" />


				<fo:table-header>
					<fo:table-row font-weight="bold" border-bottom-style="none">
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" border-left="0.8pt solid black" text-align="center" padding-top="2pt" padding-bottom="1pt"
							background-color="lightgray">
							<fo:block>#</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center" padding-left="5pt" padding-top="2pt" padding-bottom="1pt"
							background-color="lightgray">
							<fo:block>Test Step</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center" padding-left="5pt" padding-top="2pt" padding-bottom="1pt"
							background-color="lightgray">
							<fo:block>Test Class</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center" padding-top="2pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>Started</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center" padding-top="2pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>Finished</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center" padding-top="2pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>Duration (sec)</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" border-right="0.8pt solid black" text-align="center" padding-top="2pt" padding-bottom="1pt"
							background-color="lightgray">
							<fo:block>Status</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-header>

				<fo:table-body>

					<xsl:for-each select="./test-method">
						<xsl:variable name="startDate" select="@started-at" />
						<xsl:variable name="verbosityType">
							<xsl:value-of select="../../@verbosity" />
						</xsl:variable>

						<xsl:if test="contains($verbosityType,'-8-')">
							<fo:table-row keep-with-previous="always">
								<fo:table-cell border="0.1pt solid gray" border-top="0.4pt solid black" border-left="0.8pt solid black" padding-left="5pt" padding-top="1pt" padding-bottom="1pt">
									<fo:block>
										<xsl:value-of select="@sequence" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell border="0.1pt solid gray" border-top="0.4pt solid black" text-align="left" padding-left="5pt" padding-top="1pt" padding-bottom="1pt">
									<fo:block font-weight="bold">
										<xsl:call-template name="zero_width_space_1">
											<xsl:with-param name="data" select="@name" />
										</xsl:call-template>
										<!-- 
										<xsl:value-of select="@name" />
										-->
									</fo:block>
								</fo:table-cell>
								<fo:table-cell border="0.1pt solid gray" border-top="0.4pt solid black" text-align="left" padding-left="2pt" padding-top="1pt" padding-bottom="1pt">
									<fo:block>
										<xsl:call-template name="zero_width_space_1">
											<xsl:with-param name="data" select="@class" />
										</xsl:call-template>
										<!-- 
										<xsl:text></xsl:text>										
										<xsl:value-of select="substring(@class,string-length(@class) - 40)" />
										-->
									</fo:block>
								</fo:table-cell>
								<fo:table-cell border="0.1pt solid gray" border-top="0.4pt solid black" text-align="left" padding-left="1pt" padding-top="1pt" padding-bottom="1pt">
									<fo:block>
										<xsl:value-of select="@started-at" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell border="0.1pt solid gray" border-top="0.4pt solid black" text-align="left" padding-left="1pt" padding-top="1pt" padding-bottom="1pt">
									<fo:block>
										<xsl:value-of select="@finished-at" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell border="0.1pt solid gray" border-top="0.4pt solid black" text-align="right" padding-right="5pt" padding-top="1pt" padding-bottom="1pt">
									<fo:block>
										<xsl:value-of select="format-number(@duration-ms div 1000, '###,###.0')" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell border="0.1pt solid gray" border-top="0.4pt solid black" border-right="0.8pt solid black" text-align="left" padding-left="5pt" padding-top="1pt"
									padding-bottom="1pt">
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
							</fo:table-row>
							<!-- ALM Documentation -->
							<xsl:if test="./@step">
								<fo:table-row keep-with-previous="always">
									<fo:table-cell number-columns-spanned="2" border="0.1pt solid gray" border-left="0.8pt solid black" text-align="right" padding-left="2pt" padding-right="5pt"
										padding-top="1pt" padding-bottom="1pt">
										<fo:block font-style="italic">
											Description
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border="0.1pt solid gray"  padding-left="2pt" padding-top="1pt" padding-bottom="1pt">
										<fo:block color="gray">
											Step :  <xsl:value-of select="./@step" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="4"  border="0.1pt solid gray" border-right="0.8pt solid black" padding-left="2pt" padding-top="1pt" padding-bottom="1pt">
										<fo:block color="gray">
											Expected:  <xsl:value-of select="./@expected" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</xsl:if>
							<!-- Parameters (if any) -->
							<xsl:if test="./parameters">
								<fo:table-row keep-with-previous="always">
									<fo:table-cell number-columns-spanned="2" border="0.1pt solid gray" border-left="0.8pt solid black" text-align="right" padding-left="2pt" padding-right="5pt"
										padding-top="1pt" padding-bottom="1pt">
										<fo:block font-style="italic">Parameters</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="5" border="0.1pt solid gray" border-right="0.8pt solid black" padding-left="2pt" padding-top="1pt" padding-bottom="1pt">
										<fo:block>
											<xsl:for-each select="./parameters">
												<xsl:for-each select="./parameter">
													<xsl:value-of select="./value" />
													<xsl:text>  </xsl:text>
												</xsl:for-each>
											</xsl:for-each>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</xsl:if>

							<!-- Reporter output (if any) -->
							<xsl:if test="./reporter-output">
								<fo:table-row keep-with-previous="always">
									<fo:table-cell number-columns-spanned="2" border="0.1pt solid gray" border-left="0.8pt solid black" text-align="right" padding-left="2pt" padding-right="5pt"
										padding-top="1pt" padding-bottom="1pt">
										<fo:block font-style="italic">Output</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="5" border="0.1pt solid gray" border-right="0.8pt solid black" padding-left="2pt" padding-top="1pt" padding-bottom="1pt">
										<fo:block font-size="8px">
											<fo:table table-layout="fixed" width="100%" margin="0pt">
												<fo:table-column column-width="proportional-column-width(1)" />
												<fo:table-body>
													<xsl:for-each select="./reporter-output/line">
														<fo:table-row keep-with-previous="always">
															<fo:table-cell border="none" padding-left="2pt" padding-top="1pt">
																<fo:block>
																	<xsl:value-of select="." />
																</fo:block>
															</fo:table-cell>
														</fo:table-row>
													</xsl:for-each>
												</fo:table-body>
											</fo:table>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</xsl:if>

							<!-- Exceptions (if any) -->
							<xsl:if test="./exception">
								<xsl:for-each select="./exception">
									<fo:table-row keep-with-previous="always">
										<fo:table-cell number-columns-spanned="2" border="0.1pt solid gray" border-left="0.8pt solid black" text-align="right" padding-left="2pt" padding-right="5pt"
											padding-top="1pt" padding-bottom="1pt">
											<fo:block font-style="italic">Message</fo:block>
										</fo:table-cell>
										<fo:table-cell number-columns-spanned="5" border="0.1pt solid gray" border-right="0.8pt solid black" padding-left="2pt" padding-top="1pt" padding-bottom="1pt">
											<fo:block>
												<xsl:value-of select="./message" />
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
									<fo:table-row keep-with-previous="always">
										<fo:table-cell number-columns-spanned="2" border="0.1pt solid gray" border-left="0.8pt solid black" text-align="right" padding-left="2pt" padding-right="5pt"
											padding-top="1pt" padding-bottom="1pt">
											<fo:block font-style="italic">Stack Trace</fo:block>
										</fo:table-cell>
										<fo:table-cell number-columns-spanned="5" border="0.1pt solid gray" border-right="0.8pt solid black" padding-left="2pt" padding-top="1pt" padding-bottom="1pt">
											<fo:block linefeed-treatment="preserve">
												<xsl:value-of select="./full-stacktrace" />
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
								</xsl:for-each>
							</xsl:if>
						</xsl:if>
						<!-- Screenshots (if any) -->


						<xsl:if test="contains($verbosityType,'-32-') or contains($verbosityType,'-64-')">
							<xsl:choose>
								<xsl:when test="@screenshot">
									<xsl:variable name="screenshot-path" select="@screenshot" />
									<fo:table-row keep-with-previous="always">
										<fo:table-cell number-columns-spanned="2" border="0.1pt solid gray" border-left="0.8pt solid black" text-align="right" padding-left="2pt" padding-right="5pt"
											padding-top="1pt" padding-bottom="1pt">
											<fo:block font-style="italic">Screenshot</fo:block>
										</fo:table-cell>
										<fo:table-cell number-columns-spanned="5" border="0.1pt solid gray" border-right="0.8pt solid black" padding="5pt">
											<fo:block>
												<fo:external-graphic display-align="center" src="url('{$screenshot-path}')" content-width="338px" content-height="290px"></fo:external-graphic>
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
								</xsl:when>
								<xsl:otherwise>
									<fo:table-row keep-with-previous="always">
										<fo:table-cell number-columns-spanned="2">
											<fo:block> <!-- <xsl:value-of select="$testStatus" /> -->
											</fo:block>
										</fo:table-cell>
										<fo:table-cell number-columns-spanned="5">
											<fo:block></fo:block>
										</fo:table-cell>
									</fo:table-row>
								</xsl:otherwise>
							</xsl:choose>

						</xsl:if>

					</xsl:for-each>

				</fo:table-body>
			</fo:table>
			<!-- <fo:block><xsl:message>************<xsl:value-of select="$testStatus"/>!<xsl:value-of select="$reportDetailLevel"/>!**************</xsl:message></fo:block> -->
			<xsl:if test="contains($testStatus,'PASS') and not(contains($reportDetailLevel,'-8-')) and not(contains($reportDetailLevel,'-64-'))">
				<fo:table>
					<fo:table-column column-width="75mm" />
					<fo:table-header>
						<fo:table-cell>
							<fo:block font-weight="bold">Screen Detail Not Available
							</fo:block>
						</fo:table-cell>
					</fo:table-header>

					<fo:table-body>
						<fo:table-row>
							<fo:table-cell>
								<fo:block></fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>

				</fo:table>
			</xsl:if>
		</fo:block>

	</xsl:template>

	<xsl:template name="zero_width_space_1">
		<xsl:param name="data" />
		<xsl:param name="counter" select="0" />
		<xsl:choose>
			<xsl:when test="$counter &lt;= string-length($data)">
				<xsl:value-of select='concat(substring($data,$counter,1),"&#8203;")' />
				<xsl:call-template name="zero_width_space_2">
					<xsl:with-param name="data" select="$data" />
					<xsl:with-param name="counter" select="$counter+1" />
				</xsl:call-template>
			</xsl:when>
			<xsl:otherwise>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<xsl:template name="zero_width_space_2">
		<xsl:param name="data" />
		<xsl:param name="counter" />
		<xsl:value-of select='concat(substring($data,$counter,1),"&#8203;")' />
		<xsl:call-template name="zero_width_space_1">
			<xsl:with-param name="data" select="$data" />
			<xsl:with-param name="counter" select="$counter+1" />
		</xsl:call-template>
	</xsl:template>

</xsl:stylesheet>