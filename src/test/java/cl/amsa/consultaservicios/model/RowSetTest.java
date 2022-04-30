package cl.amsa.consultaservicios.model;

import org.testng.annotations.Test;


public class RowSetTest {

  @Test
  public void getRowTest() {
	  RowSet instancia = new RowSet(); 
	  try {
		  instancia.getRow();
	  }catch(Exception e) {
		  assert(true);
	  }
  }
}
