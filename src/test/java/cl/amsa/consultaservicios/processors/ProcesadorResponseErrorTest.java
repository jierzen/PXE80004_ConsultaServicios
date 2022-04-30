package cl.amsa.consultaservicios.processors;


import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.DefaultMessage;
import org.testng.annotations.Test;


public class ProcesadorResponseErrorTest {
	CamelContext camelContext = new DefaultCamelContext();
  @Test
  public void processTest() {
	  
	  Exchange exchange = new DefaultExchange(camelContext);
		
		Message in = new DefaultMessage(camelContext);
		in.setBody(null);
		in.setHeader("codigo", "0023012");
		in.setHeader("descripcion", "asdasdasd");
		exchange.setIn(in);
		
		ProcesadorResponseError instance = new ProcesadorResponseError();
		try {
			instance.process(exchange);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assert(true);
  }
}