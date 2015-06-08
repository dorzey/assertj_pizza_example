package net.dorzey.assertj_pizza_example.models.pizza;

public enum Base {
  DEEP_PAN(10),
  ITALIAN(5);

  private final double price;

  Base(double price) {

    this.price = price;
  }

  public double getPrice() {
    return price;
  }
}
