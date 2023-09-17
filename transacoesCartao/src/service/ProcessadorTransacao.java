package service;

import entities.Cartao;
import entities.Transacao;

import java.util.HashMap;

public class ProcessadorTransacao {

    private HashMap<String, Cartao> listaCartoes = new HashMap<>();
    private int nsu = 0;

    public ProcessadorTransacao(HashMap<String, Cartao> listaCartoes) {
        this.listaCartoes = listaCartoes;
    }

    public HashMap<String, Cartao> getListaCartoes() {
        return listaCartoes;
    }

    public void setListaCartoes(HashMap<String, Cartao> listaCartoes) {
        this.listaCartoes = listaCartoes;
    }

    public int getNsu() {
        return nsu;
    }

    public synchronized void setNsu(int nsu) {
        this.nsu = nsu;
    }

    public void initializeCartoesMemoria() {
        listaCartoes.put("401231021845", new Cartao("401231021845", "Eduardo Marçal", 1000.50));
        listaCartoes.put("401231021846", new Cartao("401231021845", "Claudio Tornado", 275.75));
        listaCartoes.put("401231021847", new Cartao("401231021845", "Julia Lua", 12450.00));
    }

    public Transacao processarTransacao(String message) {
        String messageReq = message.substring(0, 4);
        String valor = message.substring(4, 16);
        String hora = message.substring(16, 22);
        String data = message.substring(22, 26);
        String redeTransmissora = message.substring(26, 32);
        String numeroCartao = message.substring(32, 44);
        String formaPagamento = message.substring(44);
        String codResposta = "";
        String nsuTransacao = "000000000000";
        Double valorTransacao = Double.parseDouble(valor) / 100;

        if (!listaCartoes.containsKey(numeroCartao)) {
            codResposta = "05";
        } else {
            Cartao cartao = listaCartoes.get(numeroCartao);
            if (cartao.getSaldo() >= valorTransacao) {
                codResposta = "00";
                cartao.setSaldo(cartao.getSaldo() - valorTransacao);
                setNsu(++this.nsu);
                nsuTransacao = formatNsu(this.nsu);
            } else codResposta = "51";
        }
        return new Transacao(valor, data, hora, redeTransmissora, formaPagamento, nsuTransacao, codResposta, numeroCartao);
    }

    public String formatNsu(int nsu) {
        String formatedNsu = String.valueOf(nsu);
        for (int i = formatedNsu.length(); i <= 11; i++) {
            formatedNsu = "0" + formatedNsu;
        }
        return formatedNsu;
    }
}
