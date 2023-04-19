package controller;

import entity.OrderRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path(value = "/orders")
public class OrdersResource {

    OrderRepository repository = new OrderRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllOrders() {
        return "GetAllOrders Resource";
    }

//    public List<Order> getAllOrders (){
//        return repository.getAllOrders();
//    }

    //    public String getOrderById (int id, OrderRepository repository){
//        Order result = repository.getOrder(id);
//        if (result != null) {
//            return result.toString();
//        } else {
//            return "Not found";
//        }
//    }
}