import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProdutoTest {

    private ProdutoManipulacao produtoManipulacao;

    @BeforeEach
    public void init() {
        produtoManipulacao = new ProdutoManipulacao();
    }

    @Test
    public void deveAdicionarProdutoComSucesso() {
        //Criar variaveis (Setup)
        Produto produto1 = new Produto("Carta Charizard", 1, 1, 450.0, "Carta charizard edição um", Tipos.COLECIONAVEL);
        Produto produto2 = new Produto("Carta Venusaur", 2, 1, 350.0, "Carta venusaur edição um", Tipos.COLECIONAVEL);
        produtoManipulacao.adicionarProduto(produto1);
        produtoManipulacao.adicionarProduto(produto2);

        //Ação (Act)
        boolean retorno = produtoManipulacao.isEmpty();

        //Verificação (Assert)
        assertFalse(retorno);
    }

    @Test
    public void deveRemoverProdutoComSucesso() {
        //Criar variaveis (Setup)
        Produto produto1 = new Produto("Carta Charizard", 1, 1, 450.0, "Carta charizard edição um", Tipos.COLECIONAVEL);
        Produto produto2 = new Produto("Carta Venusaur", 2, 1, 350.0, "Carta venusaur edição um", Tipos.COLECIONAVEL);
        produtoManipulacao.adicionarProduto(produto1);
        produtoManipulacao.adicionarProduto(produto2);

        //Ação (Act)
        produtoManipulacao.removerProdutoPorIndice(0);
        produtoManipulacao.removerProdutoPorIndice(0);
        boolean retorno = produtoManipulacao.isEmpty();

        //Verificação (Assert)
        assertTrue(retorno);
    }

}
