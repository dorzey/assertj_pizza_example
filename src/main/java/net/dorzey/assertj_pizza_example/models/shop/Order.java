package net.dorzey.assertj_pizza_example.models.shop;

import net.dorzey.assertj_pizza_example.models.pizza.Pizza;

import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.summingDouble;

public class Order {
  private Customer customer;
  private List<Pizza> pizzas;

  public Order(Customer customer, List<Pizza> pizzas) {
    this.customer = customer;
    this.pizzas = pizzas;
  }

  public Customer getCustomer() {
    return customer;
  }

  public List<Pizza> getPizzas() {
    return pizzas;
  }

  public double getTotal() {
    return pizzas.stream().collect(summingDouble(p -> p.getPrice()));
  }

}
