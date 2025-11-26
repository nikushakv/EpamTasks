<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" indent="yes"/>

  <xsl:template match="/Education">
    <Education>
      <xsl:for-each select="Person">
        <xsl:copy>
          <xsl:copy-of select="@*"/>
          <xsl:attribute name="RecordNumber">
            <xsl:value-of select="position()"/>
          </xsl:attribute>
        </xsl:copy>
      </xsl:for-each>
    </Education>
  </xsl:template>

</xsl:stylesheet>
