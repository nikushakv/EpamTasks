<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"/>
    
    <xsl:template match="*[@SEGMENT='1']">
        <xsl:copy>
            <xsl:copy-of select="@*"/>
            <xsl:for-each select="*[not(@SEGMENT)]">
                <xsl:attribute name="{name()}"><xsl:value-of select="."/></xsl:attribute>
            </xsl:for-each>
            <xsl:apply-templates select="*[@SEGMENT='1']"/>
        </xsl:copy>
    </xsl:template>
    
    <xsl:template match="*[not(@SEGMENT) and not(parent::*[@SEGMENT='1'])]">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()"/>
        </xsl:copy>
    </xsl:template>
    
    <xsl:template match="@*">
        <xsl:copy/>
    </xsl:template>
</xsl:stylesheet>