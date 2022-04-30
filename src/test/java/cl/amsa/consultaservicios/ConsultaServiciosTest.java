package cl.amsa.consultaservicios;

import java.util.LinkedHashMap;

import javax.xml.bind.JAXBElement;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;


import com.oracle.xmlns.pcbpel.adapter.db.sp.db_scaconsultaserviciosref.InputParameters;
import com.oracle.xmlns.pcbpel.adapter.db.sp.db_scaconsultaserviciosref.ObjectFactory;

import cl.amsa.consultaservicios.processors.ProcesadorRequestBeanBase;
import cl.amsa.consultaservicios.processors.ProcesadorRequestBeanRest;


public class ConsultaServiciosTest extends CamelTestSupport {

	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		return new RouteBuilder() {

			@Override
			public void configure() throws Exception {

				
				from("direct:start-soap").id("rutaSoap")
				.process(new ProcesadorRequestBeanBase())
				//.to("sql-stored:sca_esb_ConsultaServicios(NVARCHAR ${header.nombreEquipo}, NVARCHAR ${header.ipEquipo})?dataSource=#datasource")
				.log("${exchange.getIn().getHeader(\"nombreEquipo\").toString()}")
				//.bean(ProcesadorResponseBeanBase.class)
				.to("mock:outputSoap");
				
				
				from("direct:start-rest").id("rutaRest")
				.log("${body}")
				.process(new ProcesadorRequestBeanRest())
				//.to("sql-stored:sca_esb_ConsultaServicios(NVARCHAR ${header.nombreEquipo}, NVARCHAR ${header.ipEquipo})?dataSource=#datasource")
				//.bean(ProcesadorResponseBeanRest.class)
				.to("mock:outputRest");
			}
		};
	}

	@Test
	public void testRouteRest() throws InterruptedException {
		LinkedHashMap<String, String> bodyRequest = new LinkedHashMap<String, String>();
		
		bodyRequest.put("NombreEquipo", "Casino_Minera_Centinela_Construccion_3");
		bodyRequest.put("IpEquipo", "1.1.1.1");
				

		MockEndpoint mockEndpoint = getMockEndpoint("mock:outputRest");
		mockEndpoint.expectedMessageCount(1);
		template.sendBody("direct:start-rest", bodyRequest);
		
		assertMockEndpointsSatisfied();
	}
	

	@Test
	public void testRouteSoap() throws InterruptedException {
		
		ObjectFactory factory = new ObjectFactory();
		JAXBElement<String> nombreEquipo = factory.createInputParametersNombreEquipo("Casino_Minera_Centinela_Construccion_3");
		JAXBElement<String> ipEquipo = factory.createInputParametersIpEquipo("1.1.1.1");
		
		InputParameters inputParameters = new InputParameters();		
		
		inputParameters.setIpEquipo(ipEquipo);
		inputParameters.setNombreEquipo(nombreEquipo);


		MockEndpoint mockEndpoint = getMockEndpoint("mock:outputSoap");
		mockEndpoint.expectedMessageCount(1);
		template.sendBody("direct:start-soap", inputParameters);
				
		assertMockEndpointsSatisfied();
	}
}
