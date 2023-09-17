package tests.service;

import entities.Cartao;
import entities.Transacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import service.ProcessadorTransacao;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class ProcessadorTransacaoTest {

    private static ProcessadorTransacao processador;

    @BeforeAll
    public static void initialize() {
        HashMap<String, Cartao> repositoryCartoes = new HashMap<>();
        repositoryCartoes.put("401231021845", new Cartao("401231021845", "Eduardo Marçal", 1000.50));
        repositoryCartoes.put("401231021846", new Cartao("401231021845", "Claudio Tornado", 275.75));
        repositoryCartoes.put("401231021847", new Cartao("401231021845", "Julia Lua", 12450.00));
        processador = new ProcessadorTransacao(repositoryCartoes);
        processador.setNsu(12121); // inicializando com um valor mais alto para verificar incremento da nsu e seu parse para String
    }

    @Test
    @DisplayName("Testa transação com saldo insuficiente")
    public void testaTransacaoSaldoInsuficiente() {
        byte[] m_msgBytes_0200 = {
                '0', '2', '0', '0', //tipo da mensagem - 200 é uma mensagem de requisição de transação financeira
                '0', '0', '0', '0', '0', '0', '1', '0', '2', '0', '1', '0', // bit 4, valor em centavos - neste exemplo, são 1020 reais e 10 centavos
                '1', '0', '4', '4', '4', '6', // bit 12, hora local da transacao - 10:44:46
                '0', '5', '1', '2', // bit 13, data da transacao 05/12
                '0', '4', '0', '1', '0', '4', // bit 33, rede transmissora
                '4', '0', '1', '2', '3', '1', '0', '2', '1', '8', '4', '5', // bit 62, número do cartão 4012-3102-1845
                '1' // bit 62, forma de pagamento 1 - débito, 2 - crédito
        };
        String codigoEsperado = "51";
        String nsuEsperado = "000000000000";

        Transacao transacao = processador.processarTransacao(
                new String(m_msgBytes_0200, StandardCharsets.UTF_8));

        Assertions.assertEquals(codigoEsperado, transacao.getCodigoResposta());
        Assertions.assertEquals(nsuEsperado, transacao.getNsu());
    }

    @Test
    @DisplayName("Testa transação com numero de cartâo inexistente")
    public void testaTransacaoCartaoInexistente() {
        byte[] m_msgBytes_0200 = {
                '0', '2', '0', '0', //tipo da mensagem - 200 é uma mensagem de requisição de transação financeira
                '0', '0', '0', '0', '0', '0', '1', '0', '2', '0', '1', '0', // bit 4, valor em centavos - neste exemplo, são 1020 reais e 10 centavos
                '1', '0', '4', '4', '4', '6', // bit 12, hora local da transacao - 10:44:46
                '0', '5', '1', '2', // bit 13, data da transacao 05/12
                '0', '4', '0', '1', '0', '4', // bit 33, rede transmissora
                '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', // bit 62, número do cartão inexistente
                '1' // bit 62, forma de pagamento 1 - débito, 2 - crédito
        };
        String codigoEsperado = "05";
        String nsuEsperado = "000000000000";

        Transacao transacao = processador.processarTransacao(
                new String(m_msgBytes_0200, StandardCharsets.UTF_8));

        Assertions.assertEquals(codigoEsperado, transacao.getCodigoResposta());
        Assertions.assertEquals(nsuEsperado, transacao.getNsu());
    }

    @Test
    @DisplayName("Testa transação bem sucedida")
    public void testaTransacaoBemSucedida() {
        byte[] m_msgBytes_0200 = {
                '0', '2', '0', '0', //tipo da mensagem - 200 é uma mensagem de requisição de transação financeira
                '0', '0', '0', '0', '0', '0', '0', '0', '2', '0', '1', '0', // bit 4, valor em centavos - neste exemplo, são 20 reais e 10 centavos
                '1', '0', '4', '4', '4', '6', // bit 12, hora local da transacao - 10:44:46
                '0', '5', '1', '2', // bit 13, data da transacao 05/12
                '0', '4', '0', '1', '0', '4', // bit 33, rede transmissora
                '4', '0', '1', '2', '3', '1', '0', '2', '1', '8', '4', '5', // bit 62, número do cartão 4012-3102-1845
                '1' // bit 62, forma de pagamento 1 - débito, 2 - crédito
        };
        String codigoEsperado = "00";
        String nsuEsperado = "000000012122"; //o ultimo nsu registrado foi 12121 pois foi inicializado com esse valor

        Transacao transacao = processador.processarTransacao(
                new String(m_msgBytes_0200, StandardCharsets.UTF_8));

        Assertions.assertEquals(codigoEsperado, transacao.getCodigoResposta());
        Assertions.assertEquals(nsuEsperado, transacao.getNsu());
    }


}
