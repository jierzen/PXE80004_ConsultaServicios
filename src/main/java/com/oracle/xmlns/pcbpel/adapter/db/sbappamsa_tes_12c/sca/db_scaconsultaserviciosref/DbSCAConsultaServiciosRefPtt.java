package com.oracle.xmlns.pcbpel.adapter.db.sbappamsa_tes_12c.sca.db_scaconsultaserviciosref;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.4.5
 * 2021-12-15T11:04:49.677-03:00
 * Generated source version: 3.4.5
 *
 */
@WebService(targetNamespace = "http://xmlns.oracle.com/pcbpel/adapter/db/SBAppAMSA_TES_12c/SCA/db_SCAConsultaServiciosRef", name = "db_SCAConsultaServiciosRef_ptt")
@XmlSeeAlso({com.oracle.xmlns.pcbpel.adapter.db.sp.db_scaconsultaserviciosref.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface DbSCAConsultaServiciosRefPtt {

    @WebMethod(operationName = "db_SCAConsultaServiciosRef")
    @WebResult(name = "OutputParameters", targetNamespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/db_SCAConsultaServiciosRef", partName = "OutputParameters")
    public com.oracle.xmlns.pcbpel.adapter.db.sp.db_scaconsultaserviciosref.OutputParameters dbSCAConsultaServiciosRef(

        @WebParam(partName = "InputParameters", name = "InputParameters", targetNamespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/db_SCAConsultaServiciosRef")
        com.oracle.xmlns.pcbpel.adapter.db.sp.db_scaconsultaserviciosref.InputParameters inputParameters
    );
}