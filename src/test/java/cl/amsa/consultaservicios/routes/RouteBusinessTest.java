package cl.amsa.consultaservicios.routes;

import org.testng.annotations.Test;

public class RouteBusinessTest {

  @Test
  public void configureTest() {
	  RouteBusiness route = new RouteBusiness();
	  try {
		route.configure();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  assert(true);
  }
}