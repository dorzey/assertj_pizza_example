package net.dorzey.assertj_pizza_example.models.shop;

/**
 * Created by nick on 15/03/17.
 */
public class EmptyOrderException extends Throwable {

    public EmptyOrderException(String message) {
        super(message);
    }
}
