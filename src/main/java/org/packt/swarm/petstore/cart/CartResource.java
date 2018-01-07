package org.packt.swarm.petstore.cart;

import org.packt.swarm.petstore.cart.model.Item;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/")
public class CartResource {

    @Inject
    private CartService cartService;

    @GET
    @Path("cart/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCart(@PathParam("customerId") String customerId) {
        Collection<Item> cart = cartService.getCart(customerId);
        return Response.ok(cart).build();
    }

    @POST
    @Path("cart/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addToCart(@PathParam("customerId") String customerId, Item item) {
        cartService.addToCart(customerId, item);
        return Response.ok().build();
    }

    @DELETE
    @Path("cart/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addToCart(@PathParam("customerId") String customerId, String itemId) {
        cartService.removeFromCart(customerId, itemId);
        return Response.ok().build();
    }

}
