package cl.amsa.consultaservicios.processors;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.DefaultMessage;
import org.testng.annotations.Test;

import com.oracle.xmlns.pcbpel.adapter.db.sp.db_scaconsultaserviciosref.InputParameters;



public class ProcesadorRequestBeanBaseTest {
	  CamelContext camelContext = new DefaultCamelContext();

  @Test
  public void processTest() {
		Exchange exchange = new DefaultExchange(camelContext);
		
		
		InputParameters request = new InputParameters();
		
		JAXBElement<String> nombreEquipo = 
			    new JAXBElement(new QName("http://mycompany/services", "amount"), String.class, "asdasd");
		
		JAXBElement<String> ipEquipo = 
			    new JAXBElement(new QName("http://mycompany/services", "amount"), String.class, "12121-1.12.12.12.12");
		
		
		request.setNombreEquipo(nombreEquipo);
		request.setIpEquipo(ipEquipo);
		

		Message in = new DefaultMessage(camelContext);
		in.setBody(request);
		in.setHeader(Exchange.FILE_NAME, "archivo.csv");
		exchange.setIn(in);
//		exchange = camelContext.createProducerTemplate().send("direct:start", exchange);
		

		
		ProcesadorRequestBeanBase instance = new ProcesadorRequestBeanBase();
		try {
			instance.process(exchange);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assert(true);
}
}
