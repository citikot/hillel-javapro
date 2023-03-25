package homework29;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class homeworkDaoImpl implements homeworkDao {
    @Override
    public void addOrder(int id) throws SQLException {
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
    public void updateOrder(String status, String comment) throws SQLException {
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
