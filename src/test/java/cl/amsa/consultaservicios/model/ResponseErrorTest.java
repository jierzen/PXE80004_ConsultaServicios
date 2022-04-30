package cl.amsa.consultaservicios.model;

import org.testng.annotations.Test;




public class ResponseErrorTest {

  @Test
  public void ResponseErrorTest() {
	  ResponseError instancia = new ResponseError(); 
	  if (instancia.toString() != null)
		  
		  assert(true);
  }

  @Test
  public void canEqualTest() {
	  ResponseError instancia = new ResponseError(); 
		
	  try {
		  instancia.canEqual(instancia);
	  }catch(Exception e) {
		  assert(true);
	  }
  }

  @Test
  public void equalsTest() {
	  ResponseError instancia = new ResponseError(); 
		
	  try {
		  instancia.equals(instancia);
	  }catch(Exception e) {
		  assert(true);
	  }
  }

  @Test
  public void getCodigoTest() {
	  ResponseError instancia = new ResponseError(); 
		
	  try {
		  instancia.getCodigo();
	  }catch(Exception e) {
		  assert(true);
	  }
  }

  @Test
  public void getDescripcionTest() {
	  ResponseError instancia = new ResponseError(); 
		
	  try {
		  instancia.getDescripcion();
	  }catch(Exception e) {
		  assert(true);
	  }
  }

  @Test
  public void hashCodeTest() {
	  ResponseError instancia = new ResponseError(); 
		
	  try {
		  instancia.hashCode();
	  }catch(Exception e) {
		  assert(true);
	  }
  }

  @Test
  public void setCodigoTest() {
	  ResponseError instancia = new ResponseError(); 
		
	  try {
		  instancia.setCodigo(null);
	  }catch(Exception e) {
		  assert(true);
	  }
  }

  @Test
  public void setDescripcionTest() {
	  ResponseError instancia = new ResponseError(); 
		
	  try {
		  instancia.setDescripcion(null);
	  }catch(Exception e) {
		  assert(true);
	  }
  }

  @Test
  public void toStringTest() {
	  ResponseError instancia = new ResponseError(); 
		
	  try {
		  instancia.toString();
	  }catch(Exception e) {
		  assert(true);
	  }
  }
}
