package net.dorzey.assertj_pizza_example.models.shop;

import net.dorzey.assertj_pizza_example.models.pizza.Pizza;

import java.util.List;

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

  public List<Pizza> getPizzas() throws EmptyOrderException {
    if(pizzas.isEmpty()){
        throw new EmptyOrderException("No pizzas in order.");
    }
    return pizzas;
  }

  public double getTotal() {
    return pizzas.stream().mapToDouble(Pizza::getPrice).sum();
  }

}
