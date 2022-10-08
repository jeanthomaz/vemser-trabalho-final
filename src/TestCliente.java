import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestCliente {

    public static void main(String[] args) throws EmailRepetidoException {

        boolean teste = false;

        Scanner entrada = new Scanner(System.in);


        List<Cliente> listaClientes = new ArrayList<>();
        ClienteManipulacao clienteManipulacao = new ClienteManipulacao();


        Cliente c1 = new Cliente("João", "Rua Um", "041.423.678-90", "Porto Alegre", "RS", "(51)99999-91234", "joao@hotmail.com", "joaozinho123", "joao@hotmail.com");
        Cliente c2 = new Cliente("João", "Rua Um", "041.423.678-90", "Porto Alegre", "RS", "(51)99999-91234", "joao1@hotmail.com", "joaozinho123", "joao@hotmail.com");
        Cliente c3 = new Cliente("João", "Rua Um", "041.423.678-90", "Porto Alegre", "RS", "(51)99999-91234", "joao2@hotmail.com", "joaozinho123", "joao@hotmail.com");
        clienteManipulacao.adicionarCliente(c1);
        clienteManipulacao.adicionarCliente(c2);
        clienteManipulacao.adicionarCliente(c3);

        System.out.println("----BEM VINDO AO SISTEMA----");
        System.out.println("Digite 1 para Fazer login.");
        System.out.println("Digite 2 para Cadastrar." );
        System.out.println("-----------------------");

        int escolha = entrada.nextInt();
        entrada.nextLine();

        switch(escolha) {
            case 1 -> {

            }

            case 2 -> {
                System.out.println("Criando cadastro: ");
                Cliente c4 = new Cliente();
                System.out.println("Digite um Nome:");
                c4.setNome(entrada.nextLine());
                System.out.println("Digite um Endereço:");
                c4.setEndereco(entrada.nextLine());
                System.out.println("Digite um CPF:");
                c4.setCpf(entrada.nextLine());
                System.out.println("Digite um Cidade:");
                c4.setCidade(entrada.nextLine());
                System.out.println("Digite um Estado:");
                c4.setEstado(entrada.nextLine());
                System.out.println("Digite um Telefone:");
                c4.setTelefone(entrada.nextLine());
                //while(teste != true) {
                emailFunction(entrada, clienteManipulacao, c4, teste);
                //}
                System.out.println("Digite um Senha:");
                c4.setSenha(entrada.nextLine());
                System.out.println("Digite seu Pix:");
                c4.setPix(entrada.nextLine());
                clienteManipulacao.adicionarCliente(c4);
            }


        }

        clienteManipulacao.listarClientes();
        entrada.close();
    }

    public static void emailFunction(Scanner entrada, ClienteManipulacao clienteManipulacao, Cliente c4, boolean teste) throws EmailRepetidoException {
        try {
            System.out.println("Digite um Email:");
            c4.setEmail(entrada.nextLine());
            clienteManipulacao.testandoEmail(c4.getEmail());
            if(clienteManipulacao.testandoEmail(c4.getEmail())){
                teste = true;
                return;
            }
        }catch (EmailRepetidoException exception){
            System.out.println("E-mail existente, digitar novamente");
            emailFunction(entrada,clienteManipulacao, c4, teste);
        }
    }
}


