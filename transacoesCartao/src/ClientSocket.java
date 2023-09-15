import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class ClientSocket {


    public static void main(String[] args) throws IOException {
        Socket conexao = new Socket("127.0.0.1", 8080);

        byte[] m_msgBytes_0200 = {
                '0', '2', '0', '0', //tipo da mensagem - 200 é uma mensagem de requisição de transação financeira
                '0', '0', '0', '0', '0', '0', '0', '0', '2', '0', '1', '0', // bit 4, valor em centavos - neste exemplo, são 20 reais e 10 centavos
                '1', '0', '4', '4', '4', '6', // bit 12, hora local da transacao - 10:44:46
                '0', '5', '1', '2', // bit 13, data da transacao 05/12
                '0', '4', '0', '1', '0', '4', // bit 33, rede transmissora
                '4', '0', '1', '2', '3', '1', '0', '2', '1', '8', '4', '5', // bit 62, número do cartão 4012-3102-1845
                '1' // bit 62, forma de pagamento 1 - débito, 2 - crédito
        };

        DataInputStream entrada = new DataInputStream(conexao.getInputStream());
        DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
        saida.write(m_msgBytes_0200);
        saida.flush();

        System.out.println("Conexao encerrada!");
        conexao.close();
    }

}
