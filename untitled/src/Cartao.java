import java.util.Objects;

public class Cartao {

    private String numero;
    private String nomeCliente;
    private Double saldo;

    public Cartao() {
    }

    public Cartao(String numero, String nomeCliente, Double saldo) {
        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cartao cartao = (Cartao) o;
        return Objects.equals(numero, cartao.numero) && Objects.equals(nomeCliente, cartao.nomeCliente) && Objects.equals(saldo, cartao.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, nomeCliente, saldo);
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "numero='" + numero + '\'' +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
