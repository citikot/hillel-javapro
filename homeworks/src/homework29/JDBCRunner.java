package homework29;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
Add CRUD operations for orders. For each you may use orderId

add order to the customer (by id), without details
update order status and comment
delete order
find order by id

 */

public class JDBCRunner {
    public static void main(String[] args) throws SQLException {

        Order order = new Order(10428,
                '2004-01-05', '2004-01-15', '2004-01-20',
                'In Process', null, 144);

        HomeworkDaoImpl daoManager = new HomeworkDaoImpl();

        daoManager.addOrder(order);

    }
}
