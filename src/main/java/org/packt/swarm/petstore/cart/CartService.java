package org.packt.swarm.petstore.cart;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class CartService {

    private Map<Integer, HashMap<Integer,Integer>> carts = new HashMap<>();

    public Map<Integer,Integer> getCart(int customerId){
        HashMap<Integer,Integer> cart = carts.get(customerId);
        if(cart == null){
            cart = new HashMap<>();
            carts.put(customerId, cart);
        }
        return cart;
    }

    public void addToCart(int customerId, int itemId, int quantity){
        Map<Integer,Integer> cart = getCart(customerId);
        cart.put(itemId, quantity);
    }

    public void removeFromCart(int customerId, int itemId){
        Map<Integer,Integer> cart = getCart(customerId);
        cart.remove(customerId);
    }

}
