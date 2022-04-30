package cl.amsa.consultaservicios.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import cl.amsa.consultaservicios.model.ResponseError;

public class ProcesadorResponseError implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		ResponseError responseError = new ResponseError();
		
		responseError.setCodigo(exchange.getIn().getHeader("codigo").toString());
		responseError.setDescripcion(exchange.getIn().getHeader("descripcion").toString());
		
		exchange.getOut().setBody(responseError);
	}

}
