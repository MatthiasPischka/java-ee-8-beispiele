package de.pischka.arquillian.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Diese Testklasse läuft außerhalb von Arquillian. Hier wird erwartet, dass die per CDI injizierte Bean NULL ist.
 */
public class HalloTest {

  private static final Logger LOGGER = Logger.getLogger(HalloTest.class.getName());

  @Inject
  private HalloBean halloBean;

  @Test
  public void testeOhneCdi() {
    LOGGER.info("Test-Ausführung außerhalb des Containers");
    Assertions.assertThrows(NullPointerException.class, () -> this.halloBean.sagHalloZu("JUnit ohne Arquillian"));
  }
}
