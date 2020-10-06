import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SimpleTCPClient {
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public void start(String serverIp, int serverPort) throws IOException {
        // Cria socket de comunicacao com o servidor e obtem canais de entrada e saida
        System.out.println("[C1] Conectando com servidor " + serverIp + ":" + serverPort);
        socket = new Socket(serverIp, serverPort);
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());

        // Espera mensagem ser digitada da entrada padrão (teclado)
        System.out.println("[C2] Conexão estabelecida, eu sou o cliente: " + socket.getLocalSocketAddress());
        System.out.print("Digite uma mensagem: ");
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.nextLine();
        scanner.close();
        
        // Envia mensagem para o servidor no canal de saida
        System.out.println("[C3] Enviando mensagem para servidor");
        output.writeUTF(msg);
        System.out.println("[C4] Mensagem enviada, recebendo resposta");
        
        // Recebendo resposta do servidor
        String response = input.readUTF();
        System.out.println("[C5] Resposta recebida: " + response);
    }
 
    public void stop() {
        try {
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String serverIp = "0.0.0.0";
        int serverPort = 6666;
        try {
            // Cria e roda cliente
            SimpleTCPClient client = new SimpleTCPClient();
            client.start(serverIp, serverPort);
            
            // Finaliza cliente
            client.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
