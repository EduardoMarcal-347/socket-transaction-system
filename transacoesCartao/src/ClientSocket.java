import java.io.*;
import java.net.Socket;

public class ClientSocket {

    public static void main(String[] args) throws IOException {
        Socket conexao = new Socket("127.0.0.1", 8080);
        DataInputStream entrada = new DataInputStream(conexao.getInputStream());
        DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());



        System.out.println("Conexao encerrada!");
        conexao.close();
    }

}
