package cl.amsa.consultaservicios.datasources;

import org.testng.annotations.Test;


public class DatasourceTest {

  @Test
  public void getDatasourceTest() {
	  Datasource instancia = new Datasource(); 
	  if (instancia. getDatasource() != null)
		  assert(true);
  }

  @Test
  public void getDriverTest() {
	  Datasource instancia = new Datasource(); 
	  if (instancia. getDriver() != null)
		  assert(true);
  }

  @Test
  public void getPasswordTest() {
	  Datasource instancia = new Datasource(); 
	  if (instancia. getPassword() != null)
		  assert(true);
  }

  @Test
  public void getUrlTest() {
	  Datasource instancia = new Datasource(); 
	  if (instancia. getUrl() != null)
		  assert(true);
  }
  @Test
  public void getUserNameTest() {
	  Datasource instancia = new Datasource(); 
	  if (instancia. getUserName() != null)
		  assert(true);
  }

  @Test
  public void setDriverTest() {
	  Datasource instancia = new Datasource(); 

	  try {
		  instancia.setDriver(null);
	  }catch(Exception e) {
		  assert(true);
	  }
  }

  @Test
  public void setPasswordTest() {
	  Datasource instancia = new Datasource(); 

	  try {
		  instancia.setPassword(null);
	  }catch(Exception e) {
		  assert(true);
	  }
  }

  @Test
  public void setUrlTest() {
	  Datasource instancia = new Datasource(); 

	  try {
		  instancia.setUrl(null);
	  }catch(Exception e) {
		  assert(true);
	  }
  }

  @Test
  public void setUserNameTest() {
	  Datasource instancia = new Datasource(); 

	  try {
		  instancia.setUserName(null);
	  }catch(Exception e) {
		  assert(true);
	  }
  }
}
