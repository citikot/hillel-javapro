package homework29;

import java.sql.SQLException;

/*
add order to the customer (by id), without details
update order status and comment
delete order
find order by id
 */
public interface homeworkDao {

    public void addOrder(int id) throws SQLException;

    public void updateOrder(String status, String comment) throws SQLException;

    public void deleteOrder(int id) throws SQLException;

    public Order findOrder(int id) throws SQLException;

}
