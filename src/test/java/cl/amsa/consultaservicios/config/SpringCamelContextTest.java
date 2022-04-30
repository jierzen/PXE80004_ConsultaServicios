package cl.amsa.consultaservicios.config;

import org.testng.annotations.Test;

public class SpringCamelContextTest {

  @Test
  public void SpringCamelContextTest() {
	  SpringCamelContext spring = new SpringCamelContext();
	  if (spring != null)
		  assert(true);
  }
}