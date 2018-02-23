package project.webshop.repository;

import project.webshop.domain.Cart;
import project.webshop.domain.CartItem;

public interface CartRepository {
    // get cart by cart id
    Cart getCartById(String id);

    // add item to cart
    Cart addToCart(String id, CartItem cartItem);
}
