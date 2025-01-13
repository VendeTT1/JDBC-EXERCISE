package ma.enset.tpjdbc2025.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnexionSingleton {
    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    static {
        try {
            // Replace with your actual database details
            String url = "jdbc:mysql://localhost:3306/master_test";
            String user = "root";
            String password = "passroot";

            // Load the driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Replace with proper logging in production
        }
    }


}
