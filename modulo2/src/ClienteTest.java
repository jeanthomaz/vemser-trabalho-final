import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    private Cliente cliente;
    private ClienteManipulacao clienteManipulacao;
    Cliente c1,c2,c3;

    @BeforeEach
    public void init(){
        clienteManipulacao = new ClienteManipulacao();
         c1 = new Cliente("João", "Rua Um", "041.423.678-90", "Porto Alegre", "RS", "(51)99999-91234", "admin", "admin", "joao@hotmail.com");
         c2 = new Cliente("João", "Rua Um", "041.423.678-90", "Porto Alegre", "RS", "(51)99999-91234", "joao1@hotmail.com", "joaozinho123", "joao@hotmail.com");
         c3 = new Cliente("João", "Rua Um", "041.423.678-90", "Porto Alegre", "RS", "(51)99999-91234", "joao2@hotmail.com", "joaozinho123", "joao@hotmail.com");
    }

    @Test
    public void deveAdicionarClienteComSucesso(){
        //Criar variaveis (Setup)
        clienteManipulacao.adicionarCliente(c1);
        clienteManipulacao.adicionarCliente(c2);
        clienteManipulacao.adicionarCliente(c3);

        //Ação (Act)
        boolean retorno = clienteManipulacao.isEmpty();

        //Verificação (Assert)
        assertFalse(retorno);

    }

    @Test
    public void deveRemoverClienteComSucesso(){
        //Criar variaveis (Setup)
        clienteManipulacao.adicionarCliente(c1);
        clienteManipulacao.adicionarCliente(c2);
        clienteManipulacao.adicionarCliente(c3);

        //Ação (Act)
        clienteManipulacao.removerClientePorIndice(0);
        clienteManipulacao.removerClientePorIndice(0);
        clienteManipulacao.removerClientePorIndice(0);
        boolean retorno = clienteManipulacao.isEmpty();

        //Verificação (Assert)
        assertTrue(retorno);
    }

}