package cl.amsa.consultaservicios.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

import com.oracle.xmlns.pcbpel.adapter.db.sp.db_scaconsultaserviciosref.InputParameters;

public class ProcesadorRequestBeanBase implements Processor {
	private static final Logger logger = Logger.getLogger(ProcesadorRequestBeanBase.class);


	@Override
	public void process(Exchange exchange) throws Exception {

		
		InputParameters inputRequest = exchange.getIn().getBody(InputParameters.class);

		
		exchange.getOut().setHeader("nombreEquipo", inputRequest.getNombreEquipo().getValue());
		exchange.getOut().setHeader("ipEquipo", inputRequest.getIpEquipo().getValue());
		
		logger.info(exchange.getOut().getHeaders().toString());

	}

}
