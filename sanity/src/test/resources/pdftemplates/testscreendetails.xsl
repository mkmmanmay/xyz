<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">
	
	<xsl:template name="testscreendetails">	
	
		<fo:block margin-top="10pt" font-size="10px" font-family="sans-serif" text-align="center" font-weight="bold">Test Details</fo:block>
		<fo:block font-size="8px" margin-top="5pt">
			<fo:table table-layout="fixed" width="100%" border-bottom="0.8pt solid black" border-collapse="collapse">
				<fo:table-column column-width="20px" />
				<fo:table-column column-width="proportional-column-width(1)" />	
				<fo:table-column column-width="180px" />
				<fo:table-column column-width="60px" />
				<fo:table-column column-width="60px" />			
				<fo:table-column column-width="70px" />
				<fo:table-column column-width="40px" />
				<fo:table-header>
					<fo:table-row font-weight="bold" border-bottom-style="none">
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" border-left="0.8pt solid black" text-align="center" padding-top="2pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>#</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="left" padding-left="5pt" padding-top="2pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>Test Step</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="left" padding-left="5pt" padding-top="2pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>Java Test Class</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center" padding-top="2pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>Started</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center" padding-top="2pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>Finished</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" text-align="center"  padding-top="2pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>Duration (sec)</fo:block>
						</fo:table-cell>
						<fo:table-cell border="0.1pt solid gray" border-top="0.8pt solid black" border-right="0.8pt solid black" text-align="center" padding-top="2pt" padding-bottom="1pt" background-color="lightgray">
							<fo:block>Status</fo:block>
						</fo:table-cell>						
					</fo:table-row>
				</fo:table-header>
				<fo:table-body>
					<xsl:for-each select="./test-method">	
						<xsl:if test="@screenshot"> 
							<xsl:variable name="screenshot-path" select="@screenshot"/>
							<fo:table-row keep-with-previous="always" >
									<fo:table-cell  number-columns-spanned="2"  border="0.1pt solid gray" border-left="0.8pt solid black" text-align="right" padding-left="2pt" padding-right="5pt" padding-top="1pt" padding-bottom="1pt">
										<fo:block font-style="italic">Screenshot</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="5"  border="0.1pt solid gray" border-right="0.8pt solid black" padding="5pt">
										<fo:block><fo:external-graphic display-align="center" src="url('{$screenshot-path}')" content-width="390px" content-height="290px"></fo:external-graphic></fo:block>
									</fo:table-cell>
							</fo:table-row>								
						 </xsl:if> 
						
						
					</xsl:for-each>
				</fo:table-body>
			</fo:table>
		</fo:block>

	</xsl:template>

</xsl:stylesheet>