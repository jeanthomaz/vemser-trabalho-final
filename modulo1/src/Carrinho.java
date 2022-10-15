import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Produto> produtos = new ArrayList<>(); //TESTE CRUD QUANTIDADE
    private List<Cupom> cupons = new ArrayList<>(); //TESTE CRUD VALIDADE

    private Cupom cupom;

    public Carrinho() {

    }

    public Carrinho(List<Produto> produtos, Cupom cupom) {

        this.produtos = produtos;
        this.cupom = cupom;
    }

    public double getValor() {
        if (produtos.size() > 0) {
            double a = 1;
            double b = 0;
            double aux;
            for (int i = 0; i < produtos.size(); i++) {
                aux = produtos.get(i).getValor() * produtos.get(i).getQuantidade();
                a = aux + b;
                b = a;
            }
            if (cupom == null) {
                return b;
            } else {
                double valor = b - cupom.getValor();
                return valor;
            }
        } else {
           return 0;
        }
    }

    public void removerProdutos() {

    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cupom getCupom() {
        return cupom;
    }

    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "produtos=" + produtos +
                '}';
    }
}
