import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketsServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket( 8080, 1 );
        Thread.currentThread().setName("ThreadServidor");
        while (true) {
            System.out.print("Esperando conectar...");
            Socket conexao = server.accept();
            System.out.println(" Conectou!");
        }

    }
}