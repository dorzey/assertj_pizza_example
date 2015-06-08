package net.dorzey.assertj_pizza_example.builders.pizza;

import net.dorzey.assertj_pizza_example.models.pizza.Base;
import net.dorzey.assertj_pizza_example.models.pizza.Pizza;
import net.dorzey.assertj_pizza_example.models.pizza.Topping;

import java.util.Set;

public class PizzaBuilder {
  private Base base;
  private Set<Topping> toppings;

  private PizzaBuilder() {
  }

  public static PizzaBuilder aPizza() {
    return new PizzaBuilder();
  }

  public PizzaBuilder withBase(Base base) {
    this.base = base;
    return this;
  }

  public PizzaBuilder withToppings(Set<Topping> toppings) {
    this.toppings = toppings;
    return this;
  }

  public Pizza build() {
    Pizza pizza = new Pizza(base, toppings);
    return pizza;
  }

}
