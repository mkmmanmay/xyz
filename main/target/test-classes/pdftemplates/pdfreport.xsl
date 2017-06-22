<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">

	  <xsl:import href="./testrunsummary.xsl"/>  
	  <xsl:import href="./suitesummary.xsl"/>  
	   <xsl:import href="./testsummary.xsl"/> 
	   <xsl:import href="./teststeps.xsl"/> 
	   <xsl:import href="./teststepdetails.xsl"/>
	   <xsl:import href="./logreport.xsl"/>

	<xsl:template match="test-run-result">	
		<fo:root >
			<xsl:call-template name="master-set-layout"/>
    		<xsl:call-template name="page-sequence"/>
 		</fo:root>
	</xsl:template>
	
	<xsl:template name="master-set-layout">
		<fo:layout-master-set>
			<fo:simple-page-master master-name="Test Report"
				margin-top="0.5cm" margin-bottom="0.5cm" margin-left="1cm"
				margin-right="1cm">
				<fo:region-body margin-top="0.5cm" margin-bottom="0.5cm" />
			</fo:simple-page-master>
		</fo:layout-master-set>
	</xsl:template>

	<xsl:template name="page-sequence">
	
		<fo:page-sequence master-reference="Test Report">
				<fo:flow flow-name="xsl-region-body">					
					<!-- Report title -->					
					<fo:block font-size="10px" text-align="center" font-family="sans-serif" color="#000080" font-weight="400">Test Run Report</fo:block>
					<!--  Include run summary if more than one suite is present in results -->
					<xsl:if test="count(./suite) &gt; 1">
						<xsl:call-template name="testrunsummary"/>		
					</xsl:if>
					<!-- Suite Summary -->
					<xsl:for-each select="./suite">
					<xsl:variable name="verbosityType"  select="@verbosity" />
							<xsl:if test="contains($verbosityType,'-1-')">
							<xsl:call-template name="suitesummary"/>	
							</xsl:if>
							<xsl:for-each select="./test">
								<!-- <fo:block page-break-before="always"> -->
								<xsl:if test="contains($verbosityType,'-2-')">
									<xsl:call-template name="testsummary"/>
								</xsl:if>
								<xsl:if test="contains($verbosityType,'-4-')">
									<xsl:call-template name="teststeps"/>
								</xsl:if>
								<xsl:if test="contains($verbosityType,'-8-') or contains($verbosityType,'-32-') or contains($verbosityType,'-64-')">
									<xsl:call-template name="teststepdetails">
									<xsl:with-param name="reportDetailLevel" select="$verbosityType" />	
									<xsl:with-param name="testStatus" select="@status" />																										
									</xsl:call-template>
								</xsl:if>									
								
							</xsl:for-each>	
							<xsl:if test="contains($verbosityType,'-16-')">
							<xsl:call-template name="logreport"/>	
							</xsl:if>															
					</xsl:for-each>
				</fo:flow>
			</fo:page-sequence>

	</xsl:template>
	
	

	
</xsl:stylesheet>