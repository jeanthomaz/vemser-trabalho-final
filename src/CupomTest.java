import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CupomTest {

    private CupomManipulacao cupomManipulacao;

    @BeforeEach
    public void init(){
        cupomManipulacao = new CupomManipulacao();
    }

    @Test
    public void adicionarCupomComSucesso(){
        //Criar variaveis (Setup)
        Cupom cupom1 = new Cupom(120, true);
        Cupom cupom2 = new Cupom(150, true);
        cupomManipulacao.adicionarCupom(cupom1);
        cupomManipulacao.adicionarCupom(cupom2);

        //Ação (Act)
        boolean retorno = cupomManipulacao.isEmpty();

        //Verificação (Assert)
        assertFalse(retorno);

    }

    @Test
    public void removerCupomComSucesso(){
        //Criar variaveis (Setup)
        Cupom cupom1 = new Cupom(120, true);
        Cupom cupom2 = new Cupom(150, true);
        cupomManipulacao.adicionarCupom(cupom1);
        cupomManipulacao.adicionarCupom(cupom2);

        //Ação (Act)
        cupomManipulacao.removerCupomPorIndice(0);
        cupomManipulacao.removerCupomPorIndice(0);
        boolean retorno = cupomManipulacao.isEmpty();

        //Verificação (Assert)
        assertTrue(retorno);

    }

}
