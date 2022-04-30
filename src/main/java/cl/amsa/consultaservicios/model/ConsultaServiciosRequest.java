package cl.amsa.consultaservicios.model;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Validated @Data

public class ConsultaServiciosRequest {
	@NotNull
	String nombreEquipo;
	@NotNull
	String ipEquipo;
	
}
