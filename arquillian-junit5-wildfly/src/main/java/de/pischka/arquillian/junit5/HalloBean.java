package de.pischka.arquillian.junit5;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class HalloBean {

  public String sagHalloZu(String name) {
    return "Hallo " + name;
  }
}
