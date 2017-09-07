package org.basket.api;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public abstract class Fruit {

  /**
   * An identifier to distinguish two objects. for example two apples will have
   * different ids.
   */
  private long id;
  /**
   * Human readable name of the fruit
   */
  private String name;

  public Fruit(final long id, final String name) {
    this.id = id;
    this.name = name;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    // gets the name of the child object, for example Apple, Banana.
    return this.getClass().getSimpleName() + " Fruit[id: " + id + ", name: " + name + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (this == o) {
      return true;
    }
    if (!(o instanceof Fruit)) {
      return false;
    }
    return id == ((Fruit) o).getId();
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 11 * hash + (int) (this.id ^ (this.id >>> 32));
    return hash;
  }
}
