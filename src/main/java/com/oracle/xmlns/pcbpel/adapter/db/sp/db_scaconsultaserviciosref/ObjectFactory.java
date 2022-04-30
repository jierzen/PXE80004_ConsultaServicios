
package com.oracle.xmlns.pcbpel.adapter.db.sp.db_scaconsultaserviciosref;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.pcbpel.adapter.db.sp.db_scaconsultaserviciosref package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InputParametersNombreEquipo_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/db_SCAConsultaServiciosRef", "NombreEquipo");
    private final static QName _InputParametersIpEquipo_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/db_SCAConsultaServiciosRef", "IpEquipo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.pcbpel.adapter.db.sp.db_scaconsultaserviciosref
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RowSet }
     * 
     */
    public RowSet createRowSet() {
        return new RowSet();
    }

    /**
     * Create an instance of {@link RowSet.Row }
     * 
     */
    public RowSet.Row createRowSetRow() {
        return new RowSet.Row();
    }

    /**
     * Create an instance of {@link InputParameters }
     * 
     */
    public InputParameters createInputParameters() {
        return new InputParameters();
    }

    /**
     * Create an instance of {@link OutputParameters }
     * 
     */
    public OutputParameters createOutputParameters() {
        return new OutputParameters();
    }

    /**
     * Create an instance of {@link RowSet.Row.Column }
     * 
     */
    public RowSet.Row.Column createRowSetRowColumn() {
        return new RowSet.Row.Column();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/db_SCAConsultaServiciosRef", name = "NombreEquipo", scope = InputParameters.class)
    public JAXBElement<String> createInputParametersNombreEquipo(String value) {
        return new JAXBElement<String>(_InputParametersNombreEquipo_QNAME, String.class, InputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/db_SCAConsultaServiciosRef", name = "IpEquipo", scope = InputParameters.class)
    public JAXBElement<String> createInputParametersIpEquipo(String value) {
        return new JAXBElement<String>(_InputParametersIpEquipo_QNAME, String.class, InputParameters.class, value);
    }

}
