package org.basket;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import org.basket.api.Fruit;
import org.basket.model.BasketItem;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class Basket implements Consumer<BasketItem<Fruit>> {

  private static final ConcurrentHashMap<String, Basket> INSTANCES
      = new ConcurrentHashMap<>(0);

  /**
   * Used to retrieve the basket for each user of the e-commerce system. Each
   * user of the e-commerce system will have their own basket.
   *
   * @param key
   * @return
   */
  public static Basket getInstance(String key) {
    Basket instance;
    synchronized (Basket.class) {
      instance = INSTANCES.get(key);
      if (instance == null) {
        instance = new Basket();
        INSTANCES.put(key, instance);
      }
    }
    return instance;
  }
  private final Object LOCK = new Object();
  private double totalCost;

  private Basket() {
  }

  /**
   * Accepts items into the basket and recalculates the total.
   *
   * @param basketItem
   */
  @Override
  public void accept(final BasketItem<Fruit> basketItem) {
    synchronized (LOCK) {
      totalCost += basketItem.getPrice();
    }
  }

  /**
   * returns the totcal cost of items in this basket.
   *
   * @return the average trade
   */
  public double getTotalCost() {
    synchronized (LOCK) {
      return totalCost;
    }
  }
}
