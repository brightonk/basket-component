package org.basket;

import java.util.logging.Logger;
import org.basket.api.Fruit;
import org.basket.model.Apple;
import org.basket.model.Banana;
import org.basket.model.BasketItem;
import org.basket.model.Lemon;
import org.basket.model.Orange;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class BasketTest {

  private static final Logger LOGGER = Logger.getLogger(BasketTest.class.getName());

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  private BasketItem<Fruit> basketItem1;
  private BasketItem<Fruit> basketItem2;
  private BasketItem<Fruit> basketItem3;
  private BasketItem<Fruit> basketItem4;
  private BasketItem<Fruit> basketItem5;
  private BasketItem<Fruit> basketItem6;
  private BasketItem<Fruit> basketItem7;
  private BasketItem<Fruit> basketItem8;
  private BasketItem<Fruit> basketItem9;
  private BasketItem<Fruit> basketItem10;

  public BasketTest() {
  }

  @Before
  public void setUp() {
    basketItem1 = new BasketItem<>(new Apple(1, "Granny Smith"), 0.32);
    basketItem2 = new BasketItem<>(new Apple(2, "Fuji"), 0.46);
    basketItem3 = new BasketItem<>(new Banana(3, "Cavendish"), 0.23);
    basketItem4 = new BasketItem<>(new Banana(4, "Lady Finger"), 0.14);
    basketItem5 = new BasketItem<>(new Orange(5, "Navel"), 0.43);
    basketItem6 = new BasketItem<>(new Orange(6, "Acid-less"), 0.30);
    basketItem7 = new BasketItem<>(new Lemon(7, "Meyer"), 0.38);
    basketItem8 = new BasketItem<>(new Lemon(8, "Regular"), 0.35);
    basketItem9 = new BasketItem<>(new Lemon(9, "Freestone "), 0.20);
    basketItem10 = new BasketItem<>(new Lemon(10, "Clingstone"), 0.25);
  }

  @After
  public void tearDown() {
    basketItem1 = null;
    basketItem2 = null;
    basketItem3 = null;
    basketItem4 = null;
    basketItem5 = null;
    basketItem6 = null;
    basketItem7 = null;
    basketItem8 = null;
    basketItem9 = null;
    basketItem10 = null;
  }

  /**
   * Test of accept method, of class Basket.
   */
  @Test
  public void testAccept() {
    LOGGER.info("accept");
    String key = "shopper-12345";
    Basket instance = Basket.getInstance(key);
    instance.accept(basketItem1);
    instance.accept(basketItem2);
    instance.accept(basketItem3);
    instance.accept(basketItem4);
    instance.accept(basketItem5);
    instance.accept(basketItem6);
    instance.accept(basketItem7);
    instance.accept(basketItem8);
    instance.accept(basketItem9);
    instance.accept(basketItem10);
    // test that method completes without exception
  }

  /**
   * Test of getTotalCost method, of class Basket.
   */
  @Test
  public void testGetTotalCost() {
    LOGGER.info("getTotalCost");
    String key = "shopper-12345";
    Basket instance = Basket.getInstance(key);
    instance.accept(basketItem1);
    assertEquals(0.32, instance.getTotalCost(), 0.01);
    instance.accept(basketItem2);
    assertEquals(0.78, instance.getTotalCost(), 0.01);
    instance.accept(basketItem3);
    assertEquals(1.01, instance.getTotalCost(), 0.01);
    instance.accept(basketItem4);
    assertEquals(1.15, instance.getTotalCost(), 0.01);
    instance.accept(basketItem5);
    assertEquals(1.58, instance.getTotalCost(), 0.01);
    instance.accept(basketItem6);
    assertEquals(1.88, instance.getTotalCost(), 0.01);
    instance.accept(basketItem7);
    assertEquals(2.26, instance.getTotalCost(), 0.01);
    instance.accept(basketItem8);
    assertEquals(2.61, instance.getTotalCost(), 0.01);
    instance.accept(basketItem9);
    assertEquals(2.81, instance.getTotalCost(), 0.01);
    instance.accept(basketItem10);
    assertEquals(3.06, instance.getTotalCost(), 0.01);
  }

  /**
   * Test of getInstance method, of class Basket.
   */
  @Test
  public void testGetInstance() {
    LOGGER.info("getInstance");
    String key = "shopper-12345";
    Basket expResult = Basket.getInstance(key);
    Basket result = Basket.getInstance(key);
    assertEquals(expResult, result);
  }
}
