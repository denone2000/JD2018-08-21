<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/transport">
        <table border="1">
            <tr>
                <td>From</td>
                <td>PointTo</td>
                <td>Date</td>
                <td>TypeTicket</td>
                <td>Price</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/transport/transportType">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/transport/transportType/from">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/transport/transportType/pointTo">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/transport/transportType/date">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/transport/transportType/typeTicket">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/transport/transportType/price">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

</xsl:stylesheet>