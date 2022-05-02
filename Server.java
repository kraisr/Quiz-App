import java.net.ServerSocket;
import java.net.Socket;
/**
 * Project 5 - Server.java
 * <p>
 * This class is the server that accepts the socket connection from the client and handles the execution of
 * threads upon user's request.
 *
 * @author Hyungchul Kim
 * @version May 2, 2022
 */
public class Server {

    private static ServerSocket serverSocket; //server socket
    private static Socket clientSocket = null;

    public static void main(String[] args) {

        try {
            serverSocket = new ServerSocket(3005);
            System.out.println("Server started."); //to check if the server started
        } catch (Exception e) {
            System.err.println("Port already in use."); //to check is the server is already running in the port #.
            System.exit(1);
        }


        try {
            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Accepted connection : " + clientSocket); //checking the socket info

                Thread t = new Thread(new ClientHandler(clientSocket)); //the ClientHandler thread
                t.start(); //begins the execution of the thread
                System.out.println("Accepted thread : " + t); //checking which thread is currently on run

            }
        } catch (Exception e) {
            System.err.println("Error in connection attempt.");
        }

    }
}
