package org.basket.model;

import java.util.Objects;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class BasketItem<T> {

  // item can not be changed once created
  private final T item;
  // price can be changed. for example if there is a price update
  private double price;

  public BasketItem(final T item, final double price) {
    this.item = item;
    this.price = price;
  }

  public T getItem() {
    return item;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "BasketItem[price: " + price + ", item: " + item + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (this == o) {
      return true;
    }
    if (!(o instanceof BasketItem)) {
      return false;
    }
    return Objects.equals(item, ((BasketItem) o).getItem());
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 83 * hash + Objects.hashCode(this.item);
    return hash;
  }
}
