<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/Dota">
        <table border="1">
            <tr><td>Region</td><td>Name</td><td>Birth</td><td>PlayerRoster</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/Dota/Team">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/Dota/Team/Region">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Dota/Team/Name">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Dota/Team/Birth">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Dota/Team/PlayerRoster">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>