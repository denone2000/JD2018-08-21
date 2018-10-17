package by.it.artemliashkov.jd02_09.beans;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Company" type="{http://beans.jd02_09.artemliashkov.it.by/}Company" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "company"
})
@XmlRootElement(name = "Companies")
public class Companies {

    @XmlElement(name = "Company")
    protected List<Company> company;

    /**
     * Gets the value of the company property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the company property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompany().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Company }
     *
     *
     */
    public List<Company> getCompany() {
        if (company == null) {
            company = new ArrayList<Company>();
        }
        return this.company;
    }

    @Override
    public String toString() {
        return "Companies{" +
                "\ncompany=" + company +
                "\n}";
    }
}