package net.dorzey.assertj_pizza_example.builders.shop;

import net.dorzey.assertj_pizza_example.models.shop.Customer;

public class CustomerBuilder {
  String name;
  String address;

  private CustomerBuilder() {
  }

  public static CustomerBuilder aCustomer() {
    return new CustomerBuilder();
  }

  public CustomerBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public CustomerBuilder withAddress(String address) {
    this.address = address;
    return this;
  }

  public Customer build() {
    Customer customer = new Customer(name, address);
    return customer;
  }
}
