Server.java

import java.net.*;
import java.io.*;
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        Socket client = server.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        String msgFromClient, msgToClient;
        while (true) {
            msgFromClient = in.readLine();
            if (msgFromClient == null || msgFromClient.equalsIgnoreCase("bye")) break;
            System.out.println("Client: " + msgFromClient);
            System.out.print("Server: ");
            msgToClient = userInput.readLine();
            out.println(msgToClient);
            if (msgToClient.equalsIgnoreCase("bye")) break;
        }
        client.close();
        server.close();
    }
}



Client.java

import java.net.*;
import java.io.*;
public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        String msgFromServer, msgToServer;
        while (true) {
            System.out.print("Client: ");
            msgToServer = userInput.readLine();
            out.println(msgToServer);
            if (msgToServer.equalsIgnoreCase("bye")) break;
            msgFromServer = in.readLine();
            if (msgFromServer == null || msgFromServer.equalsIgnoreCase("bye")) break;
            System.out.println("Server: " + msgFromServer);
        }
        socket.close();
    }
