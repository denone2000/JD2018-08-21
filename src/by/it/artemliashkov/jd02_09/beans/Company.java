package by.it.artemliashkov.jd02_09.beans;


import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Java class for Company complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Company">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Role" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AmountAgents" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="Agents" type="{http://beans.jd02_09.artemliashkov.it.by/}Agents"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Company", propOrder = {
        "name",
        "role",
        "country",
        "amountagents",
        "agents"
})
public class Company {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Role", required = true)
    protected String role;
    @XmlElement(name = "Country", required = true)
    protected String country;
    @XmlElement(name = "AmountAgents", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger amountagents;
    @XmlElement(name = "Agents", required = true)
    protected Agents agents;

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the genre property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the value of the genre property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRole(String value) {
        this.role = value;
    }

    /**
     * Gets the value of the country property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCountry(String value) {
        this.country = value;
    }

    public BigInteger getAmountagents() {
        return amountagents;
    }

    /**
     * Sets the value of the duration property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setAmountagents(BigInteger value) {
        this.amountagents = value;
    }

    /**
     * Gets the value of the agents property.
     *
     * @return
     *     possible object is
     *     {@link Agents }
     *
     */
    public Agents getAgents() {
        return agents;
    }

    /**
     * Sets the value of the agents property.
     *
     * @param value
     *     allowed object is
     *     {@link Agents }
     *
     */
    public void setAgents(Agents value) {
        this.agents = value;
    }

    @Override
    public String toString() {
        return "\nFilm{" +
                "\nname='" + name + '\'' +
                ",\n role='" + role + '\'' +
                ",\n country='" + country + '\'' +
                ",\n amountAgents=" + amountagents +
                ",\n agents=" + agents +
                "\n}";
    }
} 