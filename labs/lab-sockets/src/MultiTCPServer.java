import java.net.*;
import java.io.*;

public class MultiTCPServer {
    public static void main(String args[]) {
        try {
            int serverPort = 6666; // the server port
            ServerSocket serverSocket = new ServerSocket(serverPort);
            while (serverSocket.isBound()) {
                System.out.println("Aguardando conexao no endereco: " + InetAddress.getLocalHost() + ":" + serverPort);
                Socket clientSocket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(clientSocket);
                handler.start();
                System.out
                        .println("Conexao feita com: " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
            }
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Listen socket:" + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;

    public ClientHandler(Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    public void run() {
        try { // an echo server
            String data = in.readUTF(); // read a line of data from the stream
            System.out.println("Mensagem recebida: " + data);
            out.writeUTF(data.toUpperCase());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                /* close failed */}
        }
    }
}