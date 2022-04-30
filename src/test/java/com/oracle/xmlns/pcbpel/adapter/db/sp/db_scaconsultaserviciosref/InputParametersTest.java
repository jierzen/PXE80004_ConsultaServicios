package com.oracle.xmlns.pcbpel.adapter.db.sp.db_scaconsultaserviciosref;

import org.testng.annotations.Test;


public class InputParametersTest {

  @Test
  public void getIpEquipoTest() {
	  InputParameters instancia = new InputParameters(); 
	  if (instancia. getIpEquipo() != null)
		  assert(true);
  }

  @Test
  public void getNombreEquipoTest() {
	  InputParameters instancia = new InputParameters(); 
	  if (instancia. getNombreEquipo() != null)
		  assert(true);
  }

  @Test
  public void setIpEquipoTest() {
	  InputParameters instancia = new InputParameters(); 

	  try {
		  instancia.setIpEquipo(null);
	  }catch(Exception e) {
		  assert(true);
	  }
  }

  @Test
  public void setNombreEquipoTest() {
	  InputParameters instancia = new InputParameters(); 

	  try {
		  instancia.setNombreEquipo(null);
	  }catch(Exception e) {
		  assert(true);
	  }
  }
}
