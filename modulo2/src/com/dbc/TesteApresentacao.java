package com.dbc;

import com.dbc.enums.Tipos;
import com.dbc.exceptions.EmailRepetidoException;
import com.dbc.model.Produto_Cliente;
import com.dbc.model.Usuario;
import com.dbc.model.Cupom;
import com.dbc.model.Produto;

import java.util.Scanner;

public class TesteApresentacao {

    public static void main(String[] args) throws EmailRepetidoException {

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

        Usuario c1 = new Usuario("João", "Rua Um", "041.423.678-90", "Porto Alegre", "RS", "(51)99999-91234", "admin", "admin", "joao@hotmail.com");
        Usuario c2 = new Usuario("João", "Rua Um", "041.423.678-90", "Porto Alegre", "RS", "(51)99999-91234", "joao1@hotmail.com", "joaozinho123", "joao@hotmail.com");
        Usuario c3 = new Usuario("João", "Rua Um", "041.423.678-90", "Porto Alegre", "RS", "(51)99999-91234", "joao2@hotmail.com", "joaozinho123", "joao@hotmail.com");
        clienteManipulacao.adicionarCliente(c1);
        clienteManipulacao.adicionarCliente(c2);
        clienteManipulacao.adicionarCliente(c3);

        Produto_Cliente produtoCliente2 = new Produto_Cliente();

        int escolha = 9;
        int escolhaFazer = 9;
        int escolha3 = 9;

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
                    Usuario c4 = new Usuario();
                    c4 = fazerLogin(entrada, clienteManipulacao);

                    while (c4 == null) {
                        c4 = fazerLogin(entrada, clienteManipulacao);
                    }

                    System.out.println("----LOGIN COM SUCESSO----");
                    System.out.println("--------------------------");
                    System.out.println("O que você quer fazer? ");
                    System.out.println("Digite 1 para comprar");
                    System.out.println("Digite 2 para vender");
                    System.out.println("Digite 0 para sair");
                    escolhaFazer = entrada.nextInt();
                    entrada.nextLine();

                    switch (escolhaFazer) {

                        case 1 -> { // PARTE DA COMPRA

                            while (escolhaFazer != 0) {

                                System.out.println("");
                                System.out.println("Escolha uma opção: ");
                                System.out.println("1 - Adicionar produtos.");
                                System.out.println("2 - Adicionar cupom");
                                System.out.println("3 - Efetuar a compra");
                                System.out.println("0 - Encerrar carrinho");

                                escolhaFazer = entrada.nextInt();
                                entrada.nextLine();
                                switch (escolhaFazer) {
                                    case 1 -> {
                                        if (produtoManipulacao.temProdutos()) {
                                            System.out.println("Escolha seu produto: ");

                                            produtoManipulacao.listarProdutos();

                                            int prod = entrada.nextInt();

                                            Produto selecionado = produtoManipulacao.getProduto(prod);

                                            produtoCliente2.getProdutos().add(selecionado);

                                            produtoManipulacao.removerProdutoPorIndice(prod);

                                            System.out.println("Produtos adicionados com sucesso.");
                                        } else {
                                            System.out.println("Não possuimos mais produtos! Retornar outro dia");
                                            escolha = 0;
                                        }
                                    }
                                    case 2 -> {
                                        System.out.println("Selecione seu cupom, caso possua um: ");

                                        cupomManipulacao.listarCupons();

                                        int ticket = entrada.nextInt();

                                        Cupom selected = cupomManipulacao.getCupom(ticket);

                                        produtoCliente2.setCupom(selected);

                                        cupomManipulacao.removerCupomPorIndice(ticket);
                                        System.out.println("com.dbc.model.Cupom adicionado com sucesso.");

                                    }
                                    case 3 -> {
                                        System.out.println("Sua compra foi finalizada com sucesso.");
                                        System.out.println(produtoCliente2);
                                        System.out.println("O valor total de sua compra será de : " + produtoCliente2.getValor());
                                        System.out.println("");
                                        System.out.println("Digite 1 para concluir sua compra e efetuar o pagamento.");
                                        System.out.println("Digite 2 para cancelar o seu carrinho");
                                        int c = entrada.nextInt();
                                        entrada.nextLine();

                                        switch (c) {
                                            case 1 -> {
                                                System.out.println("Efetuando a compra...");
                                                System.out.println("Tecle para continuar.");
                                                Produto_Cliente c5 = new Produto_Cliente();
                                                produtoCliente2 = c5;
                                                entrada.nextLine();
                                                c4.comprar();
                                            }
                                            case 2 -> {

                                                for (int i = 0; i < produtoCliente2.getProdutos().size(); i++) {
                                                    produtoManipulacao.adicionarProduto(produtoCliente2.getProdutos().get(i));
                                                }
                                                cupomManipulacao.adicionarCupom(produtoCliente2.getCupom());
                                                Produto_Cliente produtoCliente3 = new Produto_Cliente();
                                                produtoCliente2 = produtoCliente3;
                                            }
                                        }
                                    }
                                }

                            }

                        }

                        case 2 -> { //VENDA

                            while (escolha3 != 0) {

                                System.out.println("");
                                System.out.println("Escolha uma opção: ");
                                System.out.println("1 - Cadastrar produtos.");
                                System.out.println("0 - Encerrar cadastro");

                                escolha3 = entrada.nextInt();
                                entrada.nextLine();

                                switch (escolha3) {

                                    case 1 -> {
                                        Produto p5 = new Produto();
                                        System.out.println("Cadastre seu produto: ");
                                        System.out.println("Digite o nome: ");
                                        p5.setNome(entrada.nextLine());
                                        System.out.println("Digite o ID: ");
                                        p5.setId(entrada.nextLong());
                                        entrada.nextLine();
                                        System.out.println("Digite a quantidade: ");
                                        p5.setQuantidade(entrada.nextInt());
                                        entrada.nextLine();
                                        System.out.println("Digite o valor: ");
                                        p5.setValor(entrada.nextDouble());
                                        entrada.nextLine();
                                        System.out.println("Digite a descrição: ");
                                        p5.setDescricao(entrada.nextLine());
                                        System.out.println("Digite o tipo:");
                                        System.out.println("1 - Jogos ");
                                        System.out.println("2 - Console");
                                        System.out.println("3 - Colecionavel");
                                        p5.setTipo(Tipos.pegaTipoPorValor(entrada.nextInt()));
                                        produtoManipulacao.adicionarProduto(p5);
                                        System.out.println("com.dbc.model.Produto listado com sucesso!");
                                        c4.vender();
                                    }

                                    case 0 -> {

                                    }


                                }
                            }
                        }
                    }
                }

                case 2 -> {
                    System.out.println("Criando cadastro: ");
                    Usuario c4 = new Usuario();
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


    public static void cadastroEmail(Scanner entrada, ClienteManipulacao clienteManipulacao, Usuario c4, boolean teste) throws EmailRepetidoException {
        try {
            System.out.println("Digite um Email:");
            c4.setEmail(entrada.nextLine());
            clienteManipulacao.testarEmail(c4.getEmail());
            if (clienteManipulacao.testarEmail(c4.getEmail())) {
                teste = true;
                return;
            }
        } catch (EmailRepetidoException exception) {
            System.out.println("E-mail existente, digitar novamente");
            cadastroEmail(entrada, clienteManipulacao, c4, teste);
        }
    }

    public static Usuario fazerLogin(Scanner entrada, ClienteManipulacao clienteManipulacao) {
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

}


