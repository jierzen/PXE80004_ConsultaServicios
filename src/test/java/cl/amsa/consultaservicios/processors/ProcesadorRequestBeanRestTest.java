package cl.amsa.consultaservicios.processors;

import java.util.LinkedHashMap;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.DefaultMessage;
import org.testng.annotations.Test;


public class ProcesadorRequestBeanRestTest {
	CamelContext camelContext = new DefaultCamelContext();
  @Test
  public void processTest() {
		Exchange exchange = new DefaultExchange(camelContext);
		
		LinkedHashMap<String, String> body = new LinkedHashMap<String, String>();
		
		body.put("NombreEquipo", "12121212");
		body.put("IpEquipo", "121212==");
		
//		@SuppressWarnings("unchecked")
//		LinkedHashMap<String, String> bodyRequest = exchange.getIn().getBody(LinkedHashMap.class);
//
//		String nombreEquipo = bodyRequest.get("NombreEquipo");
//		String ipEquipo = bodyRequest.get("IpEquipo");
//
//		exchange.getOut().setHeader("nombreEquipo", nombreEquipo);
//		exchange.getOut().setHeader("ipEquipo", ipEquipo);
		
		
		

		Message in = new DefaultMessage(camelContext);
		in.setBody(body);
		in.setHeader(Exchange.FILE_NAME, "archivo.csv");
		exchange.setIn(in);
//		exchange = camelContext.createProducerTemplate().send("direct:start", exchange);
		
		ProcesadorRequestBeanRest instance = new ProcesadorRequestBeanRest();
		try {
			instance.process(exchange);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assert(true);
  }
}