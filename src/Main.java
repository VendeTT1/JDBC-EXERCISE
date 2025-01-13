import java.sql.Connection;
import java.sql.DriverManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            // Replace with your database details
            String url = "jdbc:mysql://localhost:3306/master_test";
            String user = "root";
            String password = "passroot";

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}