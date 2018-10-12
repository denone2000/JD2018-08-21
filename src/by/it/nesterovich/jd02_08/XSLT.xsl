<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/Films">
        <table border="1">
            <tr>
                <td>Name film</td>
                <td>Genre</td>
                <td>Country</td>
                <td>Year of issue</td>
                <td>Duration</td>
                <td>Cinema</td>
                <td>Address</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/Films/Film">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/Films/Film/Name">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>

    <xsl:template match="/Films/Film/Genre">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>

    <xsl:template match="/Films/Film/Country">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>

    <xsl:template match="/Films/Film/YearOfIssue">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>

    <xsl:template match="/Films/Film/Duration">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>

    <xsl:template match="/Films/Film/Cinemas/Cinema/Name">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>

    <xsl:template match="/Films/Film/Cinemas/Cinema/Address">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>

</xsl:stylesheet>