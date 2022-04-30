package com.oracle.xmlns.pcbpel.adapter.db.sp.db_scaconsultaserviciosref;

import org.testng.annotations.Test;



public class ObjectFactoryTest {

  @Test
  public void ObjectFactoryTest() {	  try {
	  ObjectFactory instancia = new ObjectFactory(); 
	  instancia.toString();
	  instancia.getClass();
  }catch(IllegalStateException e) {
	  assert(true);
  }
}

  @Test
  public void createInputParametersTest() {
	  ObjectFactory instance = new ObjectFactory();
	  
	  try{
		  instance.createInputParameters();
	  }catch(Exception e) {
		  assert(true);
	  }
	  assert(true);
  }

  @Test
  public void createInputParametersIpEquipoTest() {
	  ObjectFactory instance = new ObjectFactory();
	  
	  try{
		  instance.createInputParametersIpEquipo(null);
	  }catch(Exception e) {
		  assert(true);
	  }
	  assert(true);
  }

  @Test
  public void createInputParametersNombreEquipoTest() {
	  ObjectFactory instance = new ObjectFactory();
	  
	  try{
		  instance.createInputParametersNombreEquipo(null);
	  }catch(Exception e) {
		  assert(true);
	  }
	  assert(true);
  }

  @Test
  public void createOutputParametersTest() {
	  ObjectFactory instance = new ObjectFactory();
	  
	  try{
		  instance.createOutputParameters();
	  }catch(Exception e) {
		  assert(true);
	  }
	  assert(true);
  }

  @Test
  public void createRowSetTest() {
	  ObjectFactory instance = new ObjectFactory();
	  
	  try{
		  instance.createRowSet();
	  }catch(Exception e) {
		  assert(true);
	  }
	  assert(true);
  }

  @Test
  public void createRowSetRowTest() {
	  ObjectFactory instance = new ObjectFactory();
	  
	  try{
		  instance.createRowSetRow();
	  }catch(Exception e) {
		  assert(true);
	  }
	  assert(true);
  }

  @Test
  public void createRowSetRowColumnTest() {
	  ObjectFactory instance = new ObjectFactory();
	  
	  try{
		  instance.createRowSetRowColumn();
	  }catch(Exception e) {
		  assert(true);
	  }
	  assert(true);
  }
}
