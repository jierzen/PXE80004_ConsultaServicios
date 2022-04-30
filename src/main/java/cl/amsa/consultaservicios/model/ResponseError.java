package cl.amsa.consultaservicios.model;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Validated
@Data
public class ResponseError {

	@NotNull
	private String codigo;
	@NotNull
	private String descripcion;
	
}
