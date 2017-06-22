<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" >
<xsl:output method="text" omit-xml-declaration="yes" indent="no"/>
<xsl:template match="/">Test Step,Description,Test Class,Started,Finished,Duration(sec),Status,FailureMessage,Additional Parameters,
<xsl:text>&#xA;</xsl:text>
<xsl:for-each select="//test-method">
<xsl:value-of select="concat(@name,',',translate(normalize-space(./@step),'.,','.;'),',',@class,',',@started-at,',',@finished-at,',',format-number(@duration-ms div 1000, '######.0'),',',@status,',',translate(normalize-space(./exception/message),'.,',''),',',@testaddedparameter,'&#xA;')"/>
</xsl:for-each>
</xsl:template>
</xsl:stylesheet>
