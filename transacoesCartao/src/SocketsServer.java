import service.ProcessadorTransacao;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketsServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080, 1);
        Thread.currentThread().setName("ThreadServidor");
        ProcessadorTransacao processador = new ProcessadorTransacao();


        while (true) {
            System.out.print("Esperando conectar...");
            Socket conexao = server.accept();
            System.out.println(" Conectou!");
            DataInputStream entrada = new DataInputStream(conexao.getInputStream());
            byte[] byteDados = new byte[45];
            entrada.readFully(byteDados);
            String msg = new String(byteDados, StandardCharsets.UTF_8);
            System.out.println(processador.processarTransacao(msg).encryptToByte());
        }

    }
}