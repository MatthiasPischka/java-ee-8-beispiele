package de.pischka.primefaces.schnellstart.model;

import java.util.Objects;
import java.util.UUID;

public class ToDo {

  private final String id;
  private final String titel;

  public ToDo(String titel) {
    this.id = UUID.randomUUID().toString();
    this.titel = titel;
  }

  public String getId() {
    return id;
  }

  public String getTitel() {
    return titel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ToDo toDo = (ToDo) o;
    return id.equals(toDo.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
