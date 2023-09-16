package service;

import entities.Cartao;
import entities.Transacao;

import java.util.HashMap;

public class ProcessadorTransacao {

    private HashMap<String, Cartao> listaCartoes = new HashMap<>();
    private String messageReq;
    private String valor;
    private String hora;
    private String data;
    private String redeTransmissora;
    private String numeroCartao;
    private String formaPagamento;
    private int nsu = 0;

    public ProcessadorTransacao() {
        initializeCartoesMemoria();
    }


    public HashMap<String, Cartao> getListaCartoes() {
        return listaCartoes;
    }

    public void setListaCartoes(HashMap<String, Cartao> listaCartoes) {
        this.listaCartoes = listaCartoes;
    }

    public String getMessageReq() {
        return messageReq;
    }

    public void setMessageReq(String messageReq) {
        this.messageReq = messageReq;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRedeTransmissora() {
        return redeTransmissora;
    }

    public void setRedeTransmissora(String redeTransmissora) {
        this.redeTransmissora = redeTransmissora;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
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
        this.messageReq = message.substring(0, 4);
        this.valor = message.substring(4, 16);
        this.hora = message.substring(16, 22);
        this.data = message.substring(22, 26);
        this.redeTransmissora = message.substring(26, 32);
        this.numeroCartao = message.substring(32, 44);
        this.formaPagamento = message.substring(44);

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
        return new Transacao(this.valor, this.data, this.hora, this.redeTransmissora, this.formaPagamento, nsuTransacao, codResposta, numeroCartao);
    }

    public String formatNsu(int nsu) {
        String formatedNsu = String.valueOf(nsu);
        for (int i = formatedNsu.length(); i <= 11; i++) {
            formatedNsu = "0" + formatedNsu;
        }
        return formatedNsu;
    }

    @Override
    public String toString() {
        return "ProcessadorTransacao{" +
                "messageReq='" + messageReq + '\'' +
                ", valor='" + valor + '\'' +
                ", hora='" + hora + '\'' +
                ", data='" + data + '\'' +
                ", redeTransmissora='" + redeTransmissora + '\'' +
                ", numeroCartao='" + numeroCartao + '\'' +
                ", formaPagamento='" + formaPagamento + '\'' +
                ", nsu=" + nsu +
                '}';
    }
}
