package cl.amsa.consultaservicios.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RowSet" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/db_SCAConsultaServiciosRef}RowSet" maxOccurs="unbounded" minOccurs="0"/>
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
    "rowSet"
})
@XmlRootElement(name = "OutputParameters")
public class OutputParameters {

    @XmlElement(name = "RowSet", nillable = true)
    protected List<RowSet> rowSet;

    /**
     * Gets the value of the rowSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rowSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRowSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RowSet }
     * 
     * 
     */
    public List<RowSet> getRowSet() {
        if (rowSet == null) {
            rowSet = new ArrayList<>();
        }
        return this.rowSet;
    }

}
