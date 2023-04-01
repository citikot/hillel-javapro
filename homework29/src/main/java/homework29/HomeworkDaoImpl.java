package homework29;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeworkDaoImpl implements HomeworkDao {
    @Override
    public void addOrder(Order order) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        String sql = """
                INSERT INTO orders(orderNumber, orderDate, requiredDate,
                shippedDate, status, comments, customerNumber)
                VALUES (?, ?, ?, ?, ?, ?, ?);
                """;

        try {
            connection = ConnectToDb.getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, order.getOrderNumber());
            stmt.setDate(2,order.getOrderDate());
            stmt.setDate(3,order.getRequiredDate());
            stmt.setDate(4,order.getShippedDate());
            stmt.setString(5,order.getStatus());
            stmt.setString(6,order.getComments());
            stmt.setInt(7,order.getCustomerNumber());
            stmt.execute();
        } finally {
            assert stmt != null;
            stmt.close();
            connection.close();
        }
    }

    @Override
    public void updateOrder(int id, String newOrderStatus, String newOrderComment) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        String sql = """
                UPDATE orders
                SET status = ?,
                    comments = ?
                WHERE
                    orderNumber = ?;
                """;

        try {
            connection = ConnectToDb.getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, newOrderStatus);
            stmt.setString(2, newOrderComment);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } finally {
            stmt.close();
            connection.close();
        }

    }

    @Override
    public void deleteOrder(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        String sql = """
                DELETE FROM orders
                WHERE
                    orderNumber = ?;
                """;

        try {
            connection = ConnectToDb.getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } finally {
            stmt.close();
            connection.close();
        }

    }

    @Override
    public Order findOrder(int id) throws SQLException {
        Order order = new Order();
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = """
                SELECT * FROM orders
                WHERE
                    orderNumber = ?;
                """;
        try {
            connection = ConnectToDb.getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                order.setCustomerNumber(rs.getInt("customerNumber"));
                order.setOrderDate(rs.getDate("orderDate"));
                order.setRequiredDate(rs.getDate("requiredDate"));
                order.setShippedDate(rs.getDate("shippedDate"));
                order.setStatus(rs.getString("status"));
                order.setComments(rs.getString("comments"));
                order.setOrderNumber(rs.getInt("orderNumber"));
            }

        } finally {
            rs.close();
            stmt.close();
            connection.close();
        }

        return order;
    }
}
