package homework29;

import java.sql.SQLException;

/*
add order to the customer (by id)
update order status and comment
delete order
find order by id
 */
public interface HomeworkDao {

    public void addOrder(Order order) throws SQLException;

    public void updateOrder(int id, String newOrderStatus, String newOrderComment) throws SQLException;

    public void deleteOrder(int id) throws SQLException;

    public Order findOrder(int id) throws SQLException;

}
