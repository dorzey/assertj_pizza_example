package net.dorzey.assertj_pizza_example.models.pizza;

import net.dorzey.assertj_pizza_example.builders.a;
import org.junit.Test;

import static net.dorzey.assertj_pizza_example.models.pizza.Base.DEEP_PAN;
import static net.dorzey.assertj_pizza_example.models.pizza.Topping.MOZZARELLA;
import static net.dorzey.assertj_pizza_example.models.pizza.Topping.ONION;
import static net.dorzey.assertj_pizza_example.models.pizza.Topping.PROSCIUTTO_DI_PARMA;
import static net.dorzey.assertj_pizza_example.models.pizza.Topping.TOMATO;
import static org.assertj.core.api.Assertions.assertThat;

public class PizzaTest {

  @Test
  public void a_margherita_should_be_vegetarian() {

    Pizza margherita = a.margheritaPizza();

    assertThat(margherita.isVegetarian()).isTrue();
  }

  @Test
  public void a_pugliese_pizza_should_have_mozzarella_tomato_and_onion_as_toppings() {

    Pizza pugliese = a.pugliesePizza();

    assertThat(pugliese.getToppings()).hasSize(3).contains(MOZZARELLA, TOMATO, ONION).doesNotContain(PROSCIUTTO_DI_PARMA);
  }

  @Test
  public void a_deep_pan_pizza_should_have_a_deep_pan_base() {

    Pizza deepPan = a.deepPanPizza();

    assertThat(deepPan.getBase()).isEqualTo(DEEP_PAN);
  }

  @Test
  public void a_san_daniele_pizza_should_cost_35() {

    Pizza sanDaniele = a.sanDanielePizza();

    assertThat(sanDaniele.getPrice()).isEqualTo(35);
  }
}