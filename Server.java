import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Connection conn;

    public Server(Connection conn) {
        this.conn = conn;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();

                // Read the request from the client
                String request = readRequest(input);
                System.out.println("Request: " + request);

                // Generate the response
                String response = generateResponse(request);
                System.out.println("Response: " + response);

                // Send the response to the client
                output.write(response.getBytes());

                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readRequest(InputStream input) {
        // Read the request from the client
        // ...
        return "";
    }

    private String generateResponse(String request) {
        // Generate the response based on the request
        // ...
        return "<html><body><h1>Hello, World!</h1></body></html>";
    }
}   