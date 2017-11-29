package org.packt.swarm.petstore.cart;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/")
public class CartResource {

    @Inject
    private CartService cartService;

    @GET
    @Path("cart/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<Integer, Integer> getCart(@PathParam("id") int id) {
        return cartService.getCart(id);
    }

    @POST
    @Path("cart/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void addToCart(@PathParam("id") int customerId, @QueryParam("itemId") int itemId, @QueryParam("quantity") int quantity) {
        cartService.addToCart(customerId, itemId, quantity);
    }

    @DELETE
    @Path("cart/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void addToCart(@PathParam("id") int customerId, @QueryParam("itemId") int itemId) {
        cartService.removeFromCart(customerId, itemId);
    }

}
