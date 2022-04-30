package com.oracle.xmlns.pcbpel.adapter.db.sp.db_scaconsultaserviciosref;

import org.testng.annotations.Test;


public class OutputParametersTest {

  @Test
  public void getRowSetTest() {
	  OutputParameters instancia = new OutputParameters(); 
	  if (instancia.getRowSet() != null)
		  assert(true);
  }
}
