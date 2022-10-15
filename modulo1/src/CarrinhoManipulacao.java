import java.util.ArrayList;
import java.util.List;

public class CarrinhoManipulacao{

    private List<Carrinho> listaDeCarrinho;

    public CarrinhoManipulacao() {
        this.listaDeCarrinho = new ArrayList<>();
    }

    public void adicionarCarrinho(Carrinho carrinho) {
        this.listaDeCarrinho.add(carrinho);
    }

    public void removerCarrinhoPorIndice(Integer index) {
        this.listaDeCarrinho.remove(index.intValue());
    }

    public void editarCarrinho(Integer index, Carrinho carrinho) {
        Carrinho carrinhoProcurado = listaDeCarrinho.get(index);
        carrinhoProcurado.setProdutos(carrinho.getProdutos());
        carrinhoProcurado.setCupom(carrinho.getCupom());
    }

    public void listarCarrinho() {
        for (int i = 0; i < listaDeCarrinho.size(); i++) {
            System.out.println("id=" + i + " | " + listaDeCarrinho.get(i));
        }
    }

    public boolean isEmpty() {
        return this.listaDeCarrinho.isEmpty();
    }
}