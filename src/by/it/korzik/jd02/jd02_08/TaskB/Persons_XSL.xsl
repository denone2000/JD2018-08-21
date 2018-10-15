<?xsl version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
<xsl:output method="html"/>
    <xsl:template match="/Persons">
        <table border="1">
            <tr><td>Name</td><td>NickName</td><td>Email</td><td>Password</td><td>Number</td><td>year</td><td>Model</td><td>CarType</td><td>FuelType</td><td>FuelPer100KM</td><td>Doors</td><td>Price</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>
    <xsl:template match="/Persons/Person">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/Persons/Person/Name">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Persons/Person/NickName">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Persons/Person/Email">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Persons/Person/Password">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Persons/Person/Number">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Persons/Person/Ads/Ad">
        <tr><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td><xsl:value-of select="attribute::year"/></td><xsl:apply-templates/></tr>

    </xsl:template>
    <xsl:template match="/Persons/Person/Ads/Ad/Model">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Persons/Person/Ads/Ad/CarType">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Persons/Person/Ads/Ad/FuelType">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Persons/Person/Ads/Ad/FuelPer100KM">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Persons/Person/Ads/Ad/Doors">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Persons/Person/Ads/Ad/Price">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>