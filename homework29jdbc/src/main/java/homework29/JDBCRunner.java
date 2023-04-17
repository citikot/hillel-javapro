package homework29;

import java.sql.SQLException;
import java.sql.Date;

public class JDBCRunner {
    public static void main(String[] args) throws SQLException {

        // Task 1: add order to the customer (by id), without details (impossible)

        Order order1 = new Order(144, Date.valueOf("2004-01-05"),
                Date.valueOf("2004-01-15"), Date.valueOf("2004-01-20"),
                "In Process", null);

        Order order2 = new Order(119, Date.valueOf("2004-01-05"),
                Date.valueOf("2004-01-15"), Date.valueOf("2004-01-20"),
                "Shipped", "Package damaged");

        Order order3 = new Order(103, Date.valueOf("2004-01-05"),
                Date.valueOf("2004-01-15"), Date.valueOf("2004-01-20"),
                "Shipped", "Package damaged");

        HomeworkDaoImpl daoManager = new HomeworkDaoImpl();

        daoManager.addOrder(order1);
        daoManager.addOrder(order2);
        daoManager.addOrder(order3);

        daoManager.updateOrder(10501, "In Process", "Claim settled");

        daoManager.deleteOrder(10501);

        System.out.println(daoManager.findOrder(10500).toString());
        System.out.println(daoManager.findOrder(10502).toString());
        System.out.println(daoManager.findOrder(10400).toString());

    }
}
