package net.dorzey.assertj_pizza_example.builders.shop;

import net.dorzey.assertj_pizza_example.models.pizza.Pizza;
import net.dorzey.assertj_pizza_example.models.shop.Customer;
import net.dorzey.assertj_pizza_example.models.shop.Order;

import java.util.Date;
import java.util.List;

public class OrderBuilder {
  private Customer customer;
  private List<Pizza> pizzas;

  private OrderBuilder() {
  }

  public static OrderBuilder anOrder() {
    return new OrderBuilder();
  }

  public OrderBuilder withCustomer(Customer customer) {
    this.customer = customer;
    return this;
  }

  public OrderBuilder withPizzas(List<Pizza> pizzas) {
    this.pizzas = pizzas;
    return this;
  }

  public Order build() {
    Order order = new Order(customer, pizzas);
    return order;
  }
}
