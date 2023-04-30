package hw30rest;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import java.util.List;

@Path("/orders")
public class RestController {
    OrderRepository orderRepository = new OrderRepository();

    @GET
    @Produces("application/json")
    public List<Order> list() {
        return orderRepository.getAllOrders();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Order getOrderById(@PathParam("id") int id) {
        return orderRepository.getOrderById(id);
    }
}
