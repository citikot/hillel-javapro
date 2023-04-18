package controller;

import entity.Order;
import entity.OrderRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.xml.ws.Response;

import java.util.List;

@Path("/getallorders")
public class GetAllOrdersResource {

    @GET
    public List<Order> getAllOrders (OrderRepository repository){
        return repository.getAllOrders();
    }
}