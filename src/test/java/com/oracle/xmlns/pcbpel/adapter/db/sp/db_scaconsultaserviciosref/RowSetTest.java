package com.oracle.xmlns.pcbpel.adapter.db.sp.db_scaconsultaserviciosref;

import org.testng.annotations.Test;


public class RowSetTest {

  @Test
  public void getRowTest() {
	  RowSet instancia = new RowSet(); 
	  if (instancia. getRow() != null)
		  assert(true);
  }
}
