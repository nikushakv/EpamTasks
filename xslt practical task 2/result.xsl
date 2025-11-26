<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" indent="yes"/>

  <xsl:template match="/">
    <PaymentResultList>
      <xsl:for-each-group select="PaymentList/PaymentItem" group-by="@CustomerID">
        <Payments CustomerID="{current-grouping-key()}" 
                  ResultAmount="{sum(current-group()/@Amount)}"
                  PaymentsCount="{count(current-group())}"/>
      </xsl:for-each-group>
    </PaymentResultList>
  </xsl:template>

</xsl:stylesheet>