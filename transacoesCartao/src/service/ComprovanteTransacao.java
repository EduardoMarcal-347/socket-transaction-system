package service;

public class ComprovanteTransacao {

    private String messageReq;
    private String valor;
    private String hora;
    private String data;
    private String redeTransmissora;
    private String codigoResposta;
    private String nsu;

    public ComprovanteTransacao(String message) {
        this.messageReq = message.substring(0, 4);
        this.valor = message.substring(4, 16);
        this.hora = message.substring(16, 22);
        this.data = message.substring(22, 26);
        this.redeTransmissora = message.substring(26, 32);
        this.codigoResposta = message.substring(32, 34);
        this.nsu = message.substring(34, 46);
    }

    public void imprimirComprovante() {
        Double valorTransacao = Double.parseDouble(valor) / 100;
        String horarioTransacao = this.hora.substring(0,2)+":"+this.hora.substring(2,4)+":"+this.hora.substring(4,6);
        String dataTransacao = this.data.substring(0,2)+"/"+this.data.substring(2,4);
        String mensagemCodigo = "";
        switch (this.codigoResposta) {
            case "00" -> mensagemCodigo = "Transação aprovada.";
            case "05" -> mensagemCodigo = "Transação recusada, cartão inexistente.";
            case "51" -> mensagemCodigo = "Saldo insuficiente.";
        }

        System.out.println("||||  "+ mensagemCodigo+"  ||||" +
                "\n\nRequisição de Mensagem: " + this.messageReq);
        System.out.printf("Valor: %.2f", valorTransacao);
        System.out.println("\nHora: " + horarioTransacao +
                "\nData: " + dataTransacao +
                "\nRede Transmissora: " + this.redeTransmissora +
                "\nCodigo de Resposta: " + this.codigoResposta +
                "\nNSU: " + this.nsu);
    }
}
