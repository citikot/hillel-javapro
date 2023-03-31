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
            stmt.executeUpdate();
        } finally {
            assert stmt != null;
            stmt.close();
            connection.close();
        }
    }

    @Override
    public void updateOrder(int id, String status, String comment) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = ConnectToDb.getConnection();
            stmt = connection.prepareStatement("SELECT * FROM  customers");
            rs = stmt.executeQuery();


        } finally {
            rs.close();
            stmt.close();
            connection.close();
        }

    }

    @Override
    public void deleteOrder(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = ConnectToDb.getConnection();
            stmt = connection.prepareStatement("SELECT * FROM  customers");
            rs = stmt.executeQuery();


        } finally {
            rs.close();
            stmt.close();
            connection.close();
        }

    }

    @Override
    public Order findOrder(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = ConnectToDb.getConnection();
            stmt = connection.prepareStatement("SELECT * FROM  customers");
            rs = stmt.executeQuery();
        } finally {
            rs.close();
            stmt.close();
            connection.close();
        }
        return null;
    }
}
