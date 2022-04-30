package cl.amsa.consultaservicios.routes;

import java.util.concurrent.TimeoutException;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import cl.amsa.consultaservicios.config.SpringCamelContext;
import cl.amsa.consultaservicios.processors.ProcesadorRequestBeanBase;
import cl.amsa.consultaservicios.processors.ProcesadorRequestBeanRest;
import cl.amsa.consultaservicios.processors.ProcesadorResponseBeanBase;
import cl.amsa.consultaservicios.processors.ProcesadorResponseBeanRest;



import cl.amsa.exceptions.GlobalExceptionsUtils.AE0001OkStatusConstant;
import cl.amsa.exceptions.GlobalExceptionsUtils.AE0003InternalServerErrorException;
import cl.amsa.exceptions.GlobalExceptionsUtils.AE0009ServiceUnavailableException;
import cl.amsa.exceptions.GlobalExceptionsUtils.AE0015BadRequestMessageException;
@Component
public class RouteBusiness extends RouteBuilder {

	public static final String CODIGO = "codigo";
	public static final String DESCRIPCION = "descripcion";	

	@Override
	public void configure() throws Exception {


		onException(SQLServerException.class).handled(true)
		.setHeader(CODIGO, simple(AE0003InternalServerErrorException.ERROR_INTERNAL_CODE))
		.setHeader(DESCRIPCION, simple(AE0003InternalServerErrorException.ERROR_INTERNAL_DESC))
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(AE0003InternalServerErrorException.ERROR_HTTP_CODE))
		.removeHeader("nombreEquipo")
		.removeHeader("ipEquipo").end();

onException(TimeoutException.class).handled(true)
		.log(LoggingLevel.INFO, "Ocurrio un error: ${exception.message}")
		.setHeader(CODIGO, simple(AE0009ServiceUnavailableException.ERROR_INTERNAL_CODE))
		.setHeader(DESCRIPCION, simple(AE0009ServiceUnavailableException.ERROR_INTERNAL_DESC))
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(AE0009ServiceUnavailableException.ERROR_HTTP_CODE))
		.removeHeader("nombreEquipo")
		.removeHeader("ipEquipo").end();

onException(NullPointerException.class).handled(true)
		.log(LoggingLevel.INFO, "Ocurrio un error: ${exception.message}")
		.setHeader(CODIGO, simple(AE0015BadRequestMessageException.ERROR_INTERNAL_CODE))
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(AE0015BadRequestMessageException.ERROR_HTTP_CODE))
		.setHeader(DESCRIPCION, simple(AE0015BadRequestMessageException.ERROR_INTERNAL_DESC))
		.removeHeader("nombreEquipo")
		.removeHeader("ipEquipo").end();

onException(Exception.class).routeId("exceptionHandler").handled(true)
		.log(LoggingLevel.INFO, "Ocurrio un error: ${exception.message}")
		.setHeader(CODIGO, simple(AE0003InternalServerErrorException.ERROR_INTERNAL_CODE))
		.setHeader(DESCRIPCION, simple(AE0003InternalServerErrorException.ERROR_INTERNAL_DESC))
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(AE0003InternalServerErrorException.ERROR_HTTP_CODE))
		.removeHeader("ipEquipo").end();

		
		
		/*
		 * RUTA HTTP-SOAP
		 */
		
		from(SpringCamelContext.endpoint).id("routeBusiness").process(new ProcesadorRequestBeanBase())
				.log("Inicio")
		        .doTry()
				.to("sql-stored:sca_esb_ConsultaServicios(NVARCHAR ${header.nombreEquipo}, NVARCHAR ${header.ipEquipo})?dataSource=#datasource")
				.log("despues de stored:sca_esb_ConsultaServicios")
				.process(new ProcesadorResponseBeanBase())
				.setHeader(CODIGO, constant(AE0001OkStatusConstant.SUCCESS_INTERNAL_CODE))
				.setHeader(DESCRIPCION, constant(AE0001OkStatusConstant.SUCCESS_INTERNAL_DESC))
				.doCatch(TimeoutException.class)
				.throwException(new AE0009ServiceUnavailableException())
		        .end();
		/*
		 * REST CONFIG
		 */

		restConfiguration().component("jetty").port("{{rest.port}}").bindingMode(RestBindingMode.json)
				.dataFormatProperty("prettyPrint", "true");

		/*
		 * RUTA REST
		 */

		rest().path("{{rest.path}}").id("RouteBusinessRest").post().route().log("antes ${body}")
				.log("Inicio")
				.process(new ProcesadorRequestBeanRest())
				.log("ANTES DE stored:sca_esb_ConsultaServicios")
				.doTry()
				.to("sql-stored:sca_esb_ConsultaServicios(NVARCHAR ${header.nombreEquipo}, "
						+ "NVARCHAR ${header.ipEquipo})?dataSource=#datasource")
				.log("${body}")
				.to("log:${body}")
				.log("despues DE stored:sca_esb_ConsultaServicios")
				.process(new ProcesadorResponseBeanRest())
				.setHeader(CODIGO, constant(AE0001OkStatusConstant.SUCCESS_INTERNAL_CODE))
				.setHeader(DESCRIPCION, constant(AE0001OkStatusConstant.SUCCESS_INTERNAL_DESC))
				.doCatch(TimeoutException.class)
				.throwException(new AE0009ServiceUnavailableException())
		        .end();

	}

}