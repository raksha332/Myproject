import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            // Register the Oracle driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "username", "password");

            // Initialize the application
            App app = new App(conn);

            // Start the application
            app.start();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}