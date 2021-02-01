package de.pischka.arquillian.junit5;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hallo")
public class HalloRessource {

  @Inject
  private HalloBean halloBean;

  @GET
  public String hallo() {
    return this.halloBean.sagHalloZu("Arquillian mit JUnit5");
  }
}
