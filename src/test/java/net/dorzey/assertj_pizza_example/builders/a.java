package net.dorzey.assertj_pizza_example.builders;

import net.dorzey.assertj_pizza_example.builders.shop.CustomerBuilder;
import net.dorzey.assertj_pizza_example.builders.shop.OrderBuilder;
import net.dorzey.assertj_pizza_example.models.pizza.Pizza;

import static com.google.common.collect.Sets.newHashSet;
import static net.dorzey.assertj_pizza_example.builders.pizza.PizzaBuilder.aPizza;
import static net.dorzey.assertj_pizza_example.builders.shop.CustomerBuilder.aCustomer;
import static net.dorzey.assertj_pizza_example.builders.shop.OrderBuilder.anOrder;
import static net.dorzey.assertj_pizza_example.models.pizza.Base.DEEP_PAN;
import static net.dorzey.assertj_pizza_example.models.pizza.Base.ITALIAN;
import static net.dorzey.assertj_pizza_example.models.pizza.Topping.PROSCIUTTO_DI_PARMA;
import static net.dorzey.assertj_pizza_example.models.pizza.Topping.MOZZARELLA;
import static net.dorzey.assertj_pizza_example.models.pizza.Topping.TOMATO;
import static net.dorzey.assertj_pizza_example.models.pizza.Topping.ONION;


public class a {

  public static Pizza margheritaPizza() {
    return aPizza().withBase(ITALIAN).withToppings(newHashSet(MOZZARELLA, TOMATO)).build();
  }

  public static Pizza sanDanielePizza() {
    return aPizza().withBase(ITALIAN).withToppings(newHashSet(MOZZARELLA, TOMATO, PROSCIUTTO_DI_PARMA)).build();
  }

  public static Pizza pugliesePizza() {
    return aPizza().withBase(ITALIAN).withToppings(newHashSet(MOZZARELLA, TOMATO, ONION)).build();
  }

  public static Pizza deepPanPizza() {
    return aPizza().withBase(DEEP_PAN).withToppings(newHashSet(MOZZARELLA, TOMATO, ONION, PROSCIUTTO_DI_PARMA)).build();
  }

  public static OrderBuilder order() {
    return anOrder();
  }

  public static CustomerBuilder customer() {
    return aCustomer();
  }
}
