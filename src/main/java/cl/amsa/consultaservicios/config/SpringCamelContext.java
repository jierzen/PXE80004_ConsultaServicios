package cl.amsa.consultaservicios.config;

import javax.xml.namespace.QName;

import org.apache.camel.CamelContext;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cl.amsa.consultaservicios.routes.RouteBusiness;
import lombok.Data;
@Data
@Service
public class SpringCamelContext {

	private static final Logger logger = Logger.getLogger(SpringCamelContext.class);
	public static final CxfEndpoint endpoint = new CxfEndpoint();
	public static final CamelContext context = new DefaultCamelContext();

	public SpringCamelContext() {

		PropertiesComponent pc = new PropertiesComponent();
		pc.setLocation("classpath:application.properties");
		SpringCamelContext.context.addComponent("properties", pc);
		
		String address = "{{camelcontext.endpointsoap.address}}";
		address = address + "{{camelcontext.endpointsoap.path}}";


		try {
			SpringCamelContext.endpoint.setBeanId("cxfConsultaServiciosHTTP");
			SpringCamelContext.endpoint.setAddress(address);
			SpringCamelContext.endpoint.setServiceClass(
					"com.oracle.xmlns.pcbpel.adapter.db.sbappamsa_tes_12c.sca.db_scaconsultaserviciosref.DbSCAConsultaServiciosRefPtt");
			SpringCamelContext.endpoint.setEndpointName(new QName(
					"http://xmlns.oracle.com/pcbpel/adapter/db/SBAppAMSA_TES_12c/SCA/db_SCAConsultaServiciosRef",
					"db_SCAConsultaServiciosRef_ptt-bindingQSPort"));
			SpringCamelContext.endpoint.setWsdlURL("wsdl/db_SCAConsultaServiciosRef-concrete.wsdl");

			
			endpoint.setCamelContext(context);

			context.addRoutes(new RouteBusiness());

		} catch (Exception e) {
			logger.info(e.getLocalizedMessage());
		}

	}
}
