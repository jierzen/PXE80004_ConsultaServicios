package cl.amsa.consultaservicios.model;

import org.testng.annotations.Test;


public class OutputParametersTest {

  @Test
  public void getRowSetTest() {
	  OutputParameters instancia = new OutputParameters(); 
	  if (instancia.getRowSet() != null)
		  assert(true);
  }
}
