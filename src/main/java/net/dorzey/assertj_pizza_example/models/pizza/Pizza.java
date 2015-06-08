package net.dorzey.assertj_pizza_example.models.pizza;

import java.util.Set;

import static java.util.stream.Collectors.summingDouble;

public class Pizza {
  private Base base;
  private Set<Topping> toppings;

  public Pizza(Base base, Set<Topping> toppings) {
    this.base = base;
    this.toppings = toppings;
  }

  public Base getBase() {

    return base;
  }

  public Set<Topping> getToppings() {

    return toppings;
  }

  public double getPrice(){

    return toppings.stream().collect(summingDouble(t -> t.getPrice())) + base.getPrice();
  }

  public boolean isVegetarian(){

    return toppings.stream().allMatch(t -> t.isVegetarian());
  }
}
