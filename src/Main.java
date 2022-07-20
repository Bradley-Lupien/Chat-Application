import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Would you like to host or connect?");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if (input.equalsIgnoreCase("host")) {
            try {
                ServerSocket socketServer = new ServerSocket(1337);
                Server server = new Server(socketServer);
                server.startServer();
                System.out.println("Server successfully started on port 1337.");

            } catch(IOException e) {
                e.printStackTrace();
            }
        }
       else if (input.equalsIgnoreCase("connect")) {
            System.out.print("Please enter your username for the chat: ");
            String username = scan.nextLine();
            Socket socket = new Socket("localhost", 1337);
            Client client = new Client(socket, username);
            System.out.println("Successfully connected to chat.");
            client.listenForMessage();
            client.sendMessage();
        }

    }
}

