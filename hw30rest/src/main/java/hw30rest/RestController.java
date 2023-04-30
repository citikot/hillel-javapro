package hw30rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
