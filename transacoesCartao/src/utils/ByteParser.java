package utils;

import entities.Transacao;

public class ByteParser {

    private String message;

    public ByteParser(String message) {
        this.message = message;
    }

    public void ClientByteParser() {
        String messageReq = message.substring(0,3);
        String valor = message.substring(4,15);
        String hora = message.substring(16,21);
        String data = message.substring(22,25);
        String numeroCartao = message.substring(32,43);
        String formaPagamento = message.substring(44);
    }

}
