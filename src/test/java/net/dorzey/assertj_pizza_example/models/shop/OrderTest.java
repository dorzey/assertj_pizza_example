package net.dorzey.assertj_pizza_example.models.shop;

import net.dorzey.assertj_pizza_example.builders.a;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static net.dorzey.assertj_pizza_example.models.pizza.Base.DEEP_PAN;
import static net.dorzey.assertj_pizza_example.models.pizza.Base.ITALIAN;
import static net.dorzey.assertj_pizza_example.models.pizza.Topping.MOZZARELLA;
import static net.dorzey.assertj_pizza_example.models.pizza.Topping.ONION;
import static net.dorzey.assertj_pizza_example.models.pizza.Topping.PROSCIUTTO_DI_PARMA;
import static net.dorzey.assertj_pizza_example.models.pizza.Topping.TOMATO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.tuple;

import static net.dorzey.assertj_pizza_example.models.shop.CustomerAssert.assertThat;

public class OrderTest {

  @Test
  public void an_order_of_a_margherita_and_a_pugliese_should_cost_50(){

    Order order = a.order().withPizzas(newArrayList(a.margheritaPizza(), a.pugliesePizza())).build();

    assertThat(order.getTotal()).isEqualTo(50);
  }

  @Test
  public void an_order_should_be_for_the_given_customer(){

    Order order = a.order().withCustomer(
        a.customer().withName("Joe").withAddress("123 Another Street").build())
        .build();

    Customer customer = order.getCustomer();

    assertThat(customer.getName()).isEqualTo("Joe");
    assertThat(customer.getAddress()).isEqualTo("123 Another Street");
  }

  @Test
  public void an_order_should_be_for_the_given_customer_using_generated_assertions(){

    Order order = a.order().withCustomer(
        a.customer().withName("Joe").withAddress("123 Another Street").build())
        .build();

    Customer customer = order.getCustomer();

    assertThat(customer).hasName("Joe").hasAddress("123 Another Street");
  }

  @Test
  public void an_order_should_contain_the_correct_pizzas() throws EmptyOrderException {

    Order order = a.order().withPizzas(
        newArrayList(a.margheritaPizza(), a.sanDanielePizza(), a.pugliesePizza(), a.deepPanPizza()))
        .build();

    assertThat(order.getPizzas()).hasSize(4).extracting("base", "toppings")
        .contains(
            tuple(ITALIAN, newHashSet(MOZZARELLA, TOMATO)),
            tuple(ITALIAN, newHashSet(MOZZARELLA, TOMATO, PROSCIUTTO_DI_PARMA)),
            tuple(ITALIAN, newHashSet(MOZZARELLA, TOMATO, ONION)),
            tuple(DEEP_PAN, newHashSet(MOZZARELLA, TOMATO, ONION, PROSCIUTTO_DI_PARMA))
        );
  }

  @Test
  public void shouldThrowExceptionWhenOrderHasNoPizzas(){
    Order order = a.order().withPizzas(newArrayList()).build();

    Throwable actual = catchThrowable(order::getPizzas);

    assertThat(actual).isNotNull()
            .isInstanceOf(EmptyOrderException.class)
            .hasMessage("No pizzas in order.");
  }
}
