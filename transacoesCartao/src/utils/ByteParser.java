package utils;

import entities.Transacao;

public class ByteParser {

    private String message;
    private String messageReq;
    private String valor;
    private String hora;
    private String data;
    private String numeroCartao;
    private String formaPagamento;

    public ByteParser(String message) {
        this.message = message;
        clientByteParser();
    }

    public void clientByteParser() {
        this.messageReq = message.substring(0,4);
        this.valor = message.substring(4,16);
        this.hora = message.substring(16,22);
        this.data = message.substring(22,26);
        this.numeroCartao = message.substring(32,44);
        this.formaPagamento = message.substring(44);
    }

    @Override
    public String toString() {
        return "ByteParser{" +
                "messageReq='" + messageReq + '\'' +
                ", valor='" + valor + '\'' +
                ", hora='" + hora + '\'' +
                ", data='" + data + '\'' +
                ", numeroCartao='" + numeroCartao + '\'' +
                ", formaPagamento='" + formaPagamento + '\'' +
                '}';
    }
}
