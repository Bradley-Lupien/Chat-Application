import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket socketServer;

    public Server(ServerSocket socketServer) {
        this.socketServer = socketServer;
    }

    public void startServer() {
        try {
            while (!socketServer.isClosed()) {
                Socket socket = socketServer.accept();
                System.out.println("New client has connected");
                ClientHandler cl = new ClientHandler(socket);

                Thread thread = new Thread(cl);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeServerSocket() {
        try {
            if (socketServer != null) {
                socketServer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
