package org.packt.swarm.petstore.cart;

import org.packt.swarm.petstore.cart.api.Item;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class CartService {

    private Map<String, HashMap<String,Item>> carts = new HashMap<>();

    private HashMap<String,Item> findCart(String customerId){
        HashMap<String,Item> cart = carts.get(customerId);
        if(cart == null){
            cart = new HashMap<>();
            carts.put(customerId, cart);
        }
        return cart;
    }

    public Collection<Item> getCart(String customerId){
        Map<String,Item> cart = findCart(customerId);
        return cart.values();
    }

    public void addToCart(String customerId, Item item){
        Map<String,Item> cart = findCart(customerId);
        cart.put(item.getItemId(), item);
    }

    public void removeFromCart(String customerId, String itemId){
        Map<String, Item> cart = findCart(customerId);
        cart.remove(itemId);
    }

}
