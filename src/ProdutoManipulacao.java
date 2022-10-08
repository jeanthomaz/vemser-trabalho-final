import java.util.ArrayList;
import java.util.List;

public class ProdutoManipulacao {

    private List<Produto> listaDeProdutos;

    public ProdutoManipulacao() {
        this.listaDeProdutos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        this.listaDeProdutos.add(produto);
    }

    public void removerProdutoPorIndice(Integer index) {
        this.listaDeProdutos.remove(index.intValue());
    }

    public void editarProduto(Integer index, Produto produto) {
        Produto produtoProcurado = listaDeProdutos.get(index);
        produtoProcurado.setNome(produto.getNome());
        produtoProcurado.setId(produto.getId());
        produtoProcurado.setQuantidade(produto.getQuantidade());
        produtoProcurado.setTipo(produto.getTipo());
        produtoProcurado.setValor(produto.getValor());
        produtoProcurado.setDescricao(produto.getDescricao());
    }

    public void listarProdutos() {
        for (int i = 0; i < listaDeProdutos.size(); i++) {
            System.out.println("id=" + i + " | " + listaDeProdutos.get(i));
        }
    }
}
