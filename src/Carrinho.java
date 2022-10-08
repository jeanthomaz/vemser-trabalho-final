import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    List<Produto> produtos = new ArrayList<>(); //TESTE CRUD QUANTIDADE
    List<Cupom> cupons = new ArrayList<>(); //TESTE CRUD VALIDADE

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Cupom> getCupons() {
        return cupons;
    }

    public void setCupons(List<Cupom> cupons) {
        this.cupons = cupons;
    }
}
