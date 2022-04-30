
package com.oracle.xmlns.pcbpel.adapter.db.sp.db_scaconsultaserviciosref;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NombreEquipo" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/db_SCAConsultaServiciosRef}string50" minOccurs="0"/&gt;
 *         &lt;element name="IpEquipo" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/db_SCAConsultaServiciosRef}string40" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nombreEquipo",
    "ipEquipo"
})
@XmlRootElement(name = "InputParameters")
public class InputParameters {

    @XmlElementRef(name = "NombreEquipo", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/db_SCAConsultaServiciosRef", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nombreEquipo;
    @XmlElementRef(name = "IpEquipo", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/db_SCAConsultaServiciosRef", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ipEquipo;

    /**
     * Obtiene el valor de la propiedad nombreEquipo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * Define el valor de la propiedad nombreEquipo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNombreEquipo(JAXBElement<String> value) {
        this.nombreEquipo = value;
    }

    /**
     * Obtiene el valor de la propiedad ipEquipo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIpEquipo() {
        return ipEquipo;
    }

    /**
     * Define el valor de la propiedad ipEquipo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIpEquipo(JAXBElement<String> value) {
        this.ipEquipo = value;
    }

}
