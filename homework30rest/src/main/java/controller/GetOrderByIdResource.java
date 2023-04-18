package controller;

import entity.Order;
import entity.OrderRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.awt.*;

@Path("/getorderbyid")
public class GetOrderByIdResource {

    @GET
    public String getOrderById (int id, OrderRepository repository){
        Order result = repository.getOrder(id);
        if (result != null) {
            return result.toString();
        } else {
            return "Not found";
        }
    }
}
