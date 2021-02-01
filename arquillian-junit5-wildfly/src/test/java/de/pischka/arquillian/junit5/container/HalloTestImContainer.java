package de.pischka.arquillian.junit5.container;


import de.pischka.arquillian.junit5.HalloBean;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.inject.Inject;
import java.io.File;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Diese Testklasse läuft mit Arquillian im Container. Hier wird erwartet, dass die per CDI injizierte Bean vorhanden
 * ist.
 */
@ExtendWith(ArquillianExtension.class)
public class HalloTestImContainer {

  private static final Logger LOGGER = Logger.getLogger(HalloTestImContainer.class.getName());

  @Inject
  private HalloBean halloBean;

  @Test
  public void testeMitCdi() {
    LOGGER.info("Test-Ausführung im Container");
    System.out.println("##### Dieser Text erscheint im Server-Log #####");
    Assertions.assertEquals("Hallo Arquillian", this.halloBean.sagHalloZu("Arquillian"));
  }

  /**
   * Erzeugt das Deployment zur Ausführung des Tests.
   *
   * @return Deployment Archiv
   */
  @Deployment
  public static WebArchive createDeployment() {
    LOGGER.info("Erzeuge Deployment-Archiv für die Test-Ausführung");

    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    File classpathRoot = new File(Objects.requireNonNull(classLoader.getResource("")).getPath());

    /* Verwende das Archiv des normalen Deployments als Grundlage */
    String pfadZurWar = classpathRoot.getParent().concat("/arquillian-junit5-wildfly.war");

    WebArchive archive = ShrinkWrap.create(ZipImporter.class, "test-arquillian-junit5-wildfly.war")
        .importFrom(new File(pfadZurWar))
        .as(WebArchive.class);

    /* Füge zu testende Klassen hinzu */
    archive.addPackages(true, "de.pischka.arquillian.junit5.container");

    File[] libs = Maven.resolver()
        .loadPomFromFile("pom.xml")
        .importTestDependencies()
        .resolve().withTransitivity().asFile();

    /* Füge alle Test-Dependencies aus der pom.xml hinzu */
    for (File file : libs) {
      archive.addAsLibrary(file);
    }

    return archive;
  }
}
