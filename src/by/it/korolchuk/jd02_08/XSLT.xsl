<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/Theatres">
        <table border="1">
            <tr>
                <td>TheatreName</td>
                <td>Address</td>
                <td>Show</td>
                <td>Genre</td>
                <td>Director</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/Theatres/Theatre">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/Theatres/Theatre/TheatreName">
        <td>
            <xsl:value-of select="text()"/>
        </td>

    </xsl:template>

    <xsl:template match="/Theatres/Theatre/Address">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>

    <xsl:template match="/Theatres/Theatre/Show/Name">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>

    <xsl:template match="/Theatres/Theatre/Show/Genre">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>

    <xsl:template match="/Theatres/Theatre/Show/Director">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>


</xsl:stylesheet>