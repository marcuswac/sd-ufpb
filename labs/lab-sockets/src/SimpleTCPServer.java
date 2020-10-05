import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleTCPServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public void start(int port) throws IOException {
        // Cria server socket para aguardar conexoes de clientes em loop
        System.out.println("[S1] Criando server socket para aguardar conexões de clientes em loop");
        serverSocket = new ServerSocket(port);
        while (serverSocket.isBound()) {
            
            // Aguarda conexao de novo cliente (bloqueante)
            System.out.println("[S2] Aguardando conexão em: " + serverSocket.getLocalSocketAddress());
            socket = serverSocket.accept();
            
            // Conexao estabelecida, obtem canais de entrada e saida de dados com cliente
            System.out.println("[S3] Conexão estalecida com cliente:" + socket.getRemoteSocketAddress());
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            
            // Recebe mensagem do cliente do canal de entrada
            String msg = input.readUTF();
            System.out.println("[S4] Mensagem recebida de " + socket.getRemoteSocketAddress() + ": " + msg);
            
            // Envia resposta ao cliente no canal de saida
            String reply = msg.toUpperCase();
            output.writeUTF(reply);
            System.out.println("[S5] Mensagem enviada para " + socket.getRemoteSocketAddress() + ": " + reply);
        }
    }

    public void stop() throws IOException {
        input.close();
        output.close();
        socket.close();
        serverSocket.close();
    }
    public static void main(String[] args) {
        int serverPort = 6666;
        try {
            // Inicia e roda servidor
            SimpleTCPServer server = new SimpleTCPServer();
            server.start(serverPort);

            // Finaliza servidor
            server.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
