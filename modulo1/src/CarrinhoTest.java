import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarrinhoTest {

    private Carrinho carrinho;
    private List<Produto> produtos;
    private CarrinhoManipulacao carrinhoManipulacao;

    @BeforeEach
    public void init(){
        produtos = new ArrayList<>();
        carrinho = new Carrinho();
        carrinhoManipulacao = new CarrinhoManipulacao();
    }

    @Test
    public void deveAdicionarCarrinhoComSucesso(){
        //Criar variaveis (Setup)
        Produto produto1 = new Produto("Carta Charizard", 1, 1, 450.0, "Carta charizard edição um", Tipos.COLECIONAVEL);
        Produto produto2 = new Produto("Carta Venusaur", 2, 1, 350.0, "Carta venusaur edição um", Tipos.COLECIONAVEL);
        produtos.add(produto1);
        produtos.add(produto2);
        carrinho.setProdutos(produtos);
        carrinhoManipulacao.adicionarCarrinho(carrinho);

        //Ação (Act)
        boolean retorno = carrinhoManipulacao.isEmpty();

        //Verificação (Assert)
        assertFalse(retorno);

    }

    @Test
    public void deveRemoverCarrinhoComSucesso(){
        //Criar variaveis (Setup)
        Produto produto1 = new Produto("Carta Charizard", 1, 1, 450.0, "Carta charizard edição um", Tipos.COLECIONAVEL);
        Produto produto2 = new Produto("Carta Venusaur", 2, 1, 350.0, "Carta venusaur edição um", Tipos.COLECIONAVEL);
        produtos.add(produto1);
        produtos.add(produto2);
        carrinho.setProdutos(produtos);
        carrinhoManipulacao.adicionarCarrinho(carrinho);
        Carrinho carrinho2 = new Carrinho();

        //Ação (Act)
        carrinhoManipulacao.removerCarrinhoPorIndice(0);
        boolean retorno = carrinhoManipulacao.isEmpty();

        //Verificação (Assert)
        assertTrue(retorno);
    }

}
