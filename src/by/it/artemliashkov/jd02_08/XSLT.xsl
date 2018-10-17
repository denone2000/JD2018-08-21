<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:template match="/Companies">
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Role</td>
            <td>Country</td>
            <td>AmountAgents</td>
            <td>Agent</td>
            <td>Address</td>
        </tr>
        <xsl:apply-templates/>
    </table>
</xsl:template>

<xsl:template match="/Companies/Company">
    <tr>
        <xsl:apply-templates/>
    </tr>
</xsl:template>

<xsl:template match="/Companies/Company/Name">
    <td>
        <xsl:value-of select="text()"/>
    </td>
</xsl:template>

<xsl:template match="/Companies/Company/Role">
    <td>
        <xsl:value-of select="text()"/>
    </td>
</xsl:template>

<xsl:template match="/Companies/Company/Country">
    <td>
        <xsl:value-of select="text()"/>
    </td>
</xsl:template>

<xsl:template match="/Companies/Company/AmountAgents">
    <td>
        <xsl:value-of select="text()"/>
    </td>
</xsl:template>

<xsl:template match="/Companies/Company/Agents/Agent/Name">
    <td>
        <xsl:value-of select="text()"/>
    </td>
</xsl:template>

<xsl:template match="/Companies/Company/Agents/Agent/Address">
    <td>
        <xsl:value-of select="text()"/>
    </td>
</xsl:template>

</xsl:stylesheet>