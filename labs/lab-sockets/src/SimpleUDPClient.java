import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class SimpleUDPClient {
    private DatagramSocket socket;
    private byte[] buffer;

    public void start(String serverIp, int serverPort) throws IOException {
        // Iniciando socket e buffer
        System.out.println("[C1] Criando socket UDP para enviar mensagem para servidor");
        socket = new DatagramSocket();
        this.buffer = new byte[1024];

        // Lendo mensagem do teclado
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma mensagem: ");
        String msg = scanner.nextLine();
        scanner.close();

        // Enviando mensagem para servidor
        System.out.println("[C2] Enviando msg para " + serverIp + ":" + serverPort + ": " + msg);
        sendMessage(msg, serverIp, serverPort);
        System.out.println("[C3] Mensagem enviada, recebendo resposta");

        // Recebendo resposta do servidor
        String response = receiveMessage();
        System.out.println("[C4] Resposta recebida: " + response);
    }

    public void sendMessage(String msg, String ip, int port) throws IOException {
        InetAddress address = InetAddress.getByName(ip);
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), address, port);
        socket.send(packet);
    }

    public String receiveMessage() throws IOException {
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);	
        socket.receive(packet);
        return new String(packet.getData());
    }

    public void stop() {
        this.socket.close();
        this.buffer = null;
    }

    public static void main(String[] args) {
        String serverIp = "127.0.0.1";
        int serverPort = 6789;
		try {
            // Criando e iniciando cliente
            SimpleUDPClient client = new SimpleUDPClient();
            client.start(serverIp, serverPort);

            // Finalizando cliente
            client.stop();
		} catch (SocketException e){
            System.out.println("Socket: " + e.getMessage());
		} catch (IOException e){
            System.out.println("IO: " + e.getMessage());
		}
    }
}
