package org.packt.swarm.petstore.cart.model;

import java.util.HashMap;

public class Cart {
    private Integer userId;
    private HashMap<Integer, Integer> items;

    public Integer getUserId() {
        return userId;
    }
}
