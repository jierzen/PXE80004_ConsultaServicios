package cl.amsa.consultaservicios.processors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.DefaultMessage;
import org.testng.annotations.Test;

public class ProcesadorResponseBeanBaseTest {
	CamelContext camelContext = new DefaultCamelContext();
  @Test
  public void processTest() {
		Exchange exchange = new DefaultExchange(camelContext);
		

		LinkedHashMap<Object, Object> bodyResponse = new LinkedHashMap<Object, Object>();
		
		List<Object> lista = new ArrayList<Object>();
		
		Map<String, Object> convertValue2 = new HashMap<String, Object>();
		
		convertValue2.put("IdServicio", "IdServicio");
		convertValue2.put("Nombre", "Nombre");
		convertValue2.put("Descripcion", "Descripcion");
		convertValue2.put("HoraInicio", "HoraInicio");
		convertValue2.put("HoraFin", "HoraFin");
		convertValue2.put("Incompatibles", "Incompatibles");
		convertValue2.put("NombreEquipo", "NombreEquipo");
		
		lista.add(convertValue2);
		
		bodyResponse.put("#result-set-1", lista);
		
		Message in = new DefaultMessage(camelContext);
		in.setBody(bodyResponse);
		in.setHeader(Exchange.FILE_NAME, "archivo.csv");
		exchange.setIn(in);
//		exchange = camelContext.createProducerTemplate().send("direct:start", exchange);
		
		ProcesadorResponseBeanBase instance = new ProcesadorResponseBeanBase();
		try {
			instance.process(exchange);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assert(true);
  }
}