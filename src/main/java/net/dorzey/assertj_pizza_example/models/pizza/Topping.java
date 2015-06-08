package net.dorzey.assertj_pizza_example.models.pizza;

public enum Topping {
  TOMATO(true, 5),
  MOZZARELLA(true, 10),
  ONION(true, 10),
  PROSCIUTTO_DI_PARMA(false, 15);

  private final boolean vegetarian;
  private final double price;

  Topping(boolean vegetarian, double price) {
    this.vegetarian = vegetarian;
    this.price = price;
  }

  public boolean isVegetarian() {
    return vegetarian;
  }

  public double getPrice() {
    return price;
  }
}
