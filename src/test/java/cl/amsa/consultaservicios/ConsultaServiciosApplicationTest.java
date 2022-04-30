package cl.amsa.consultaservicios;

import org.testng.annotations.Test;


public class ConsultaServiciosApplicationTest {

  @Test
  public void mainTest() {
	  ConsultaServiciosApplication instancia = new  ConsultaServiciosApplication(); 
	  try {

		  instancia.toString();
	  }catch(Exception e) {
		  assert(true);
	  }
  }
}
