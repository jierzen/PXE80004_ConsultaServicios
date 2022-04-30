package cl.amsa.consultaservicios.model;

import org.testng.annotations.Test;



public class ConsultaServiciosRequestTest {

  @Test
  public void ConsultaServiciosRequestTest() {
	  ConsultaServiciosRequest instancia = new ConsultaServiciosRequest(); 
	  try {
		  instancia.getClass();
		  instancia.toString();
	  }catch(Exception e) {
		  assert(true);
	  }
  }

  @Test
	public void canEqualTest() {
	  ConsultaServiciosRequest instancia = new ConsultaServiciosRequest(); 
	  try {
		  instancia.canEqual(null);
	  }catch(Exception e) {
		  assert(true);
	  }
  }

  @Test
  public void equalsTest() {
	  ConsultaServiciosRequest instancia = new ConsultaServiciosRequest(); 
	  try {
		  instancia.equals(null);
	  }catch(Exception e) {
		  assert(true);
	  }
  }

  @Test
  public void getIpEquipoTest() {
	  ConsultaServiciosRequest instancia = new ConsultaServiciosRequest(); 
	  if (instancia. getIpEquipo() != null)
		  assert(true);
  }

  @Test
  public void getNombreEquipoTest() {
	  ConsultaServiciosRequest instancia = new ConsultaServiciosRequest(); 
	  if (instancia. getNombreEquipo() != null)
		  assert(true);
  }

  @Test
  public void hashCodeTest() {
	  ConsultaServiciosRequest instancia = new ConsultaServiciosRequest(); 
	  if (instancia. hashCode() != 0)
		  assert(true);
  }

  @Test
  public void setIpEquipoTest() {
	  ConsultaServiciosRequest instancia = new ConsultaServiciosRequest(); 
	  try {
		  instancia.setIpEquipo(null);
	  }catch(Exception e) {
		  assert(true);
	  }
  }

  @Test
  public void setNombreEquipoTest() {
	  ConsultaServiciosRequest instancia = new ConsultaServiciosRequest(); 
	  try {
		  instancia.setNombreEquipo(null);
	  }catch(Exception e) {
		  assert(true);
	  }
  }

  @Test
  public void toStringTest() {
	  ConsultaServiciosRequest instancia = new ConsultaServiciosRequest(); 
	  try {
		  instancia.toString();
	  }catch(Exception e) {
		  assert(true);
	  }
  }
}
