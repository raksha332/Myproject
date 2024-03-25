//App.java
import java.io.IOException;
import java.sql.Connection;

public class App {
    private Connection conn;

    public App(Connection conn) {
        this.conn = conn;
    }

    public void start() {
        // Start the server
        Server server = new Server(conn);
        server.start();

        // Open the browser
        Browser.open("http://localhost:8080/index.html");
    }
}