public class Cupom {

    private double valor; //TESTE CRUD VALOR > 0
    private boolean validade; //TESTE CRUD BOOLEAN VALIDO

    public Cupom(double valor, boolean validade) {
        this.valor = valor;
        this.validade = validade;
    }

    public void imprimirCupom(){
        System.out.println("Cupom de desconto de " + valor * 100 + "%");
        System.out.println("Ainda é autenticável: " + validade);
    }

    @Override
    public String toString() {
        return "Cupom{" +
                "valor=" + valor +
                ", validade=" + validade +
                '}';
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isValidade() {
        return validade;
    }

    public void setValidade(boolean validade) {
        this.validade = validade;
    }
}
