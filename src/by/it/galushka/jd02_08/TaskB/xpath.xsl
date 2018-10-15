<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/Fighters/Lightweight">
        <table border="1">
            <tr><td colspan="8" align="center">Lightweight</td></tr>
            <tr>
                <td>Rank</td>
                <td>Name</td>
                <td>Nickname</td>
                <td>From</td>
                <td>Age</td>
                <td>Summary</td>
                <td>Record</td>
                <td>Events</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/Fighters/Lightweight/Fighter">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/Fighters/Lightweight/Fighter/Rank">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Fighters/Lightweight/Fighter/Name">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Fighters/Lightweight/Fighter/Nickname">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Fighters/Lightweight/Fighter/From">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Fighters/Lightweight/Fighter/Age">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Fighters/Lightweight/Fighter/Summary">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Fighters/Lightweight/Fighter/Record">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Fighters/Lightweight/Fighter/Events">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Fighters/Middleweight">
        <table border="1">
            <tr><td colspan="8" align="center">Middleweight</td></tr>
            <tr>
                <td>Rank</td>
                <td>Name</td>
                <td>Nickname</td>
                <td>From</td>
                <td>Age</td>
                <td>Summary</td>
                <td>Record</td>
                <td>Events</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/Fighters/Middleweight/Fighter">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/Fighters/Middleweight/Fighter/Rank">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Fighters/Middleweight/Fighter/Name">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Fighters/Middleweight/Fighter/Nickname">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Fighters/Middleweight/Fighter/From">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Fighters/Middleweight/Fighter/Age">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Fighters/Middleweight/Fighter/Summary">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Fighters/Middleweight/Fighter/Record">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Fighters/Middleweight/Fighter/Events">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>