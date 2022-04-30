package cl.amsa.consultaservicios.processors;

import java.util.LinkedHashMap;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cl.amsa.exceptions.GlobalExceptionsUtils.AE0011BadRequestParameterException;


@Service
public class ProcesadorRequestBeanRest implements Processor {

	private static final Logger logger = Logger.getLogger(ProcesadorRequestBeanRest.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, String> bodyRequest = exchange.getIn().getBody(LinkedHashMap.class);

		String nombreEquipo = bodyRequest.get("NombreEquipo");
		String ipEquipo = bodyRequest.get("IpEquipo");

		/*VALIDACION
		 * Se define error "errorMessage":"Application Error"
		 * Respuesta de error OSB diferente de OpenShift
		 * NombreEquipo OSB != NombreEquipo OC*/
		
		try {
			if(nombreEquipo == null || ipEquipo == null || 
			   nombreEquipo.isEmpty() || ipEquipo.isEmpty() || 
			   nombreEquipo.trim().length() == 0 || ipEquipo.trim().length() == 0) {
				logger.info("Error en los datos suministrados: " + AE0011BadRequestParameterException.ERROR_INTERNAL_CODE + ": " + AE0011BadRequestParameterException.ERROR_INTERNAL_DESC);
			}else {
				exchange.getOut().setHeader("nombreEquipo", nombreEquipo);
				exchange.getOut().setHeader("ipEquipo", ipEquipo);
				logger.info(bodyRequest);
			}
		}catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
}
