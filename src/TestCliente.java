import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestCliente {

    public static void main(String[] args) throws EmailRepetidoException {

        //vender
        // produto2(atributos);
        // produtoManipulacao.adicionarProduto(p2);

        //


        boolean teste = false;
        Scanner entrada = new Scanner(System.in);
        ClienteManipulacao clienteManipulacao = new ClienteManipulacao();
        ProdutoManipulacao produtoManipulacao = new ProdutoManipulacao();
        CarrinhoManipulacao carrinhoManipulacao = new CarrinhoManipulacao();
        CupomManipulacao cupomManipulacao = new CupomManipulacao();

        Produto p1 = new Produto("Pikachu", 31235313, 3, 45.0, "Pelucia gigante do Pikachu", Tipos.COLECIONAVEL);
        Produto p2 = new Produto("Nintendo 64", 894848, 2, 300.0, "Console video Game - Nintendo 64", Tipos.CONSOLE);
        Produto p3 = new Produto("Pokemon Fire Red", 32131454, 8, 80.0, "Jogo de Game Boy Advance, estado novo", Tipos.JOGOS);
        produtoManipulacao.adicionarProduto(p1);
        produtoManipulacao.adicionarProduto(p2);
        produtoManipulacao.adicionarProduto(p3);

        Cupom cupom1 = new Cupom(50, true);
        Cupom cupom2 = new Cupom(40, true);
        Cupom cupom3 = new Cupom(30, true);
        cupomManipulacao.adicionarCupom(cupom1);
        cupomManipulacao.adicionarCupom(cupom2);
        cupomManipulacao.adicionarCupom(cupom3);

        Cliente c1 = new Cliente("João", "Rua Um", "041.423.678-90", "Porto Alegre", "RS", "(51)99999-91234", "joao@hotmail.com", "joaozinho123", "joao@hotmail.com");
        Cliente c2 = new Cliente("João", "Rua Um", "041.423.678-90", "Porto Alegre", "RS", "(51)99999-91234", "joao1@hotmail.com", "joaozinho123", "joao@hotmail.com");
        Cliente c3 = new Cliente("João", "Rua Um", "041.423.678-90", "Porto Alegre", "RS", "(51)99999-91234", "joao2@hotmail.com", "joaozinho123", "joao@hotmail.com");
        clienteManipulacao.adicionarCliente(c1);
        clienteManipulacao.adicionarCliente(c2);
        clienteManipulacao.adicionarCliente(c3);

        int escolha = 9;

        while (escolha != 0) {

            System.out.println("----BEM VINDO AO SISTEMA----");
            System.out.println("Digite 1 para Fazer Login.");
            System.out.println("Digite 2 para Cadastrar.");
            System.out.println("Digite 0 para Sair");
            System.out.println("-----------------------");
            escolha = entrada.nextInt();
            entrada.nextLine();

            switch (escolha) {
                case 1 -> {
                    System.out.println("------BEM VINDO AO LOGIN--------");
                    Cliente c4 = new Cliente();
                    c4 = fazerLogin(entrada, clienteManipulacao);
                    while(c4 == null){
                        c4 = fazerLogin(entrada, clienteManipulacao);
                    }
                    System.out.println("----LOGIN COM SUCESSO----");
                    System.out.println("--------------------------");
                    System.out.println("O que você quer fazer? ");
                    System.out.println("Digite 1 para comprar");
                    System.out.println("Digite 2 para vender");
                    System.out.println("Digite 0 para sair");
                    int escolhaFazer = entrada.nextInt();
                    entrada.nextLine();

                    switch(escolhaFazer) {

                        case 1 ->{


                        }

                        case 2 ->{


                        }

                        case 0 -> {
                            entrada.close();
                        }
                    }


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
                    cadastroEmail(entrada, clienteManipulacao, c4, teste);
                    System.out.println("Digite um Senha:");
                    c4.setSenha(entrada.nextLine());
                    System.out.println("Digite seu Pix:");
                    c4.setPix(entrada.nextLine());
                    clienteManipulacao.adicionarCliente(c4);
                    clienteManipulacao.listarClientes();
                }

                case 0 -> {
                    entrada.close();
                }

            }

        }
    }

    public static void cadastroEmail (Scanner entrada, ClienteManipulacao clienteManipulacao, Cliente c4, boolean teste) throws EmailRepetidoException {
        try {
            System.out.println("Digite um Email:");
            c4.setEmail(entrada.nextLine());
            clienteManipulacao.testarEmail(c4.getEmail());
            if (clienteManipulacao.testarEmail(c4.getEmail())) {
                teste = true;
                System.out.println("Digite uma senha");
                return;
            }
        } catch (EmailRepetidoException exception) {
            System.out.println("E-mail existente, digitar novamente");
            cadastroEmail(entrada, clienteManipulacao, c4, teste);
        }
    }

    public static Cliente fazerLogin(Scanner entrada, ClienteManipulacao clienteManipulacao){
        try {
            System.out.println("Digite o email");
            String email = entrada.nextLine();
            System.out.println("Digite uma senha");
            String senha = entrada.nextLine();
            return clienteManipulacao.fazerLogin(email, senha);
        } catch (EmailRepetidoException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static void fazerCadastro () {

    }

    public static void fazerCompra () {

    }

    public static void fazerVenda () {

    }
}


