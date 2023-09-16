package entities;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Transacao {

    private String valor;
    private String data;
    private String hora;
    private String redeTransmissora;
    private String formaPagamento;
    private String nsu;
    private String codigoResposta;

    private String numeroCartao;

    public Transacao(String valor, String data, String hora, String redeTransmissora, String formaPagamento, String nsu, String codigoResposta, String numeroCartao) {
        this.valor = valor;
        this.data = data;
        this.hora = hora;
        this.redeTransmissora = redeTransmissora;
        this.formaPagamento = formaPagamento;
        this.nsu = nsu;
        this.codigoResposta = codigoResposta;
        this.numeroCartao = numeroCartao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getRedeTransmissora() {
        return redeTransmissora;
    }

    public void setRedeTransmissora(String redeTransmissora) {
        this.redeTransmissora = redeTransmissora;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }

    public String getCodigoResposta() {
        return codigoResposta;
    }

    public void setCodigoResposta(String codigoResposta) {
        this.codigoResposta = codigoResposta;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public byte[] encryptToByte(){
        String message = "0210" + this.valor + this.hora + this.data + this.redeTransmissora
                + this.codigoResposta + this.nsu;
        byte[] finalMessage = message.getBytes(StandardCharsets.UTF_8);
        return finalMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return Objects.equals(valor, transacao.valor) && Objects.equals(data, transacao.data) && Objects.equals(hora, transacao.hora) && Objects.equals(redeTransmissora, transacao.redeTransmissora) && Objects.equals(formaPagamento, transacao.formaPagamento) && Objects.equals(nsu, transacao.nsu) && Objects.equals(codigoResposta, transacao.codigoResposta) && Objects.equals(numeroCartao, transacao.numeroCartao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, data, hora, redeTransmissora, formaPagamento, nsu, codigoResposta, numeroCartao);
    }

    @Override
    public String toString() {
        return "entities.Transacao{" +
                "valor='" + valor + '\'' +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", redeTransmissora='" + redeTransmissora + '\'' +
                ", formaPagamento='" + formaPagamento + '\'' +
                ", nsu='" + nsu + '\'' +
                ", codigoResposta='" + codigoResposta + '\'' +
                ", cartao=" + numeroCartao +
                '}';
    }
}
