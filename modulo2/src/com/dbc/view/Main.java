package com.dbc.view;

import com.dbc.enums.Tipos;
import com.dbc.model.*;

import com.dbc.repository.*;
import com.dbc.service.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ProdutoService produtoService = new ProdutoService();
        PedidoService pedidoService = new PedidoService();
        CupomService cupomService = new CupomService();
        UsuarioService usuarioService = new UsuarioService();

        //EDITAR DAQUI PRA BAIXO ///

//       usuarioService.listar();
//        pedidoService.listarPedido();

        int opcao = -1;
        int escolha = 9;
        int choise = -1;

//        usuarioService.listar();
        // remover é dar um setDeletado para "T"//
        while (opcao != 0) {
            System.out.println("Digite 1 para realizar seu cadastro");
            System.out.println("Digite 2 para editar um usuário");
            System.out.println("Digite 3 para excluir um usuário"); // aqui ta que tu pode excluir o usuario sem fazer login, teria que ser o admin mas a gente n tem//
            System.out.println("Digite 4 para listar os usuarios");
            System.out.println("Digite 5 para logar em sua conta"); //aqui da para fazer o excluir o PROPRIO USUARIO (TRANSFORMANDO O DELETADO EM T"
            System.out.println("Digite 0 para encerrar o programa");


            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1: {// Cadastro de usuário
                    Usuario user = new Usuario();
                    System.out.println("Digite o seu nome: ");
                    user.setNome(scanner.nextLine());

                    System.out.println("Digite o seu endereço: ");
                    user.setEndereco(scanner.nextLine());

                    System.out.println("Digite o seu CPF: ");
                    user.setCpf(scanner.nextLine());

                    System.out.println("Digite sua cidade: ");
                    user.setCidade(scanner.nextLine());

                    System.out.println("Digite seu estado: ");
                    user.setEstado(scanner.nextLine());

                    System.out.println("Digite seu telefone: ");
                    user.setTelefone(scanner.nextLine());

                    System.out.println("Digite seu email: ");
                    user.setEmail(scanner.nextLine());

                    System.out.println("Digite sua senha: ");
                    user.setSenha(scanner.nextLine());

                    System.out.println("Digite o seu pix: ");
                    user.setPix(scanner.nextLine());

                    usuarioService.adicionarUsuario(user);
                    break;
                }
                case 2: {
                    // edição
                    System.out.println("Selecione um dos usuários a baixo para editar");
                    usuarioService.listar();
                    int index = scanner.nextInt();
                    scanner.nextLine();

                    Usuario newUser = new Usuario();

                    newUser.setIdUsuario(index);

                    System.out.println("Digite o seu nome: ");
                    newUser.setNome(scanner.nextLine());

                    System.out.println("Digite o seu endereço: ");
                    newUser.setEndereco(scanner.nextLine());

                    System.out.println("Digite o seu CPF: ");
                    newUser.setCpf(scanner.nextLine());

                    System.out.println("Digite sua cidade: ");
                    newUser.setCidade(scanner.nextLine());

                    System.out.println("Digite seu estado: ");
                    newUser.setEstado(scanner.nextLine());

                    System.out.println("Digite seu telefone: ");
                    newUser.setTelefone(scanner.nextLine());

                    System.out.println("Digite seu email: ");
                    newUser.setEmail(scanner.nextLine());

                    System.out.println("Digite sua senha: ");
                    newUser.setSenha(scanner.nextLine());

                    System.out.println("Digite o seu pix: ");
                    newUser.setPix(scanner.nextLine());

                    System.out.println("O usuário é válido ? Digite F para válido e T para inválido");
                    newUser.setDeletado(scanner.nextLine());

                    usuarioService.editar(index, newUser);
                    break;
                }
                case 3: {
                    // exclusão
                    System.out.println("Qual pessoa você deseja excluir?");
                    usuarioService.listar();
                    int id = scanner.nextInt();
                    usuarioService.remover(id);
                    break;
                }
                case 4: {
                    // listagem
                    usuarioService.listar();
                    break;
                }

                case 5: {
                    Usuario usuario = new Usuario();
                    usuario = fazerLogin(usuarioService, scanner);

                    while (usuario == null) {
                        usuario = fazerLogin(usuarioService, scanner);
                    }
                    boolean verdade = true;

                    while (verdade) {
                        System.out.println("Digite 1 para listar os produtos disponiveis na loja");
                        System.out.println("Digite 2 para realizar um pedido");
                        System.out.println("Digite 3 para cadastrar um produto");
                        System.out.println("Digite 4 para alterar informações de um produto já cadastrado por você");
                        System.out.println("Digite 5 para excluir um produto cadastrado por você da lista");
                        System.out.println("Digige 6 para listar os produtos do Usuario");
                        System.out.println("Digite 7 para sair do login.");

                        escolha = scanner.nextInt();

                        switch (escolha) {
                            case 1: {
                                //listagem produtos
                                List<Produto> listaProdutos = produtoService.listarProdutos();
                                listaProdutos.forEach(System.out::println);
                                break;
                            }
                            case 2: {
                                //Realiza a compra dos pedidos
                                Pedido pedido = new Pedido();
                                pedido.setIdUsuario(usuario.getIdUsuario());
                                List<Produto> listaProdutos = produtoService.listarProdutos();
                                while (true) {
                                    listaProdutos.forEach(System.out::println);
                                    ProdutoPedido produtoPedido = new ProdutoPedido();
                                    System.out.println("Escolha seu produto pelo ID ou 0 para finalizar");
                                    Integer idProduto = scanner.nextInt();
                                    scanner.nextLine();
                                    if(idProduto == 0){
                                        break;
                                    }
                                    System.out.println("Digite a quantidade desejada: ");
                                    Integer quantidadeDesejada = scanner.nextInt();
                                    scanner.nextLine();

                                    Produto produtoSelecionado = listaProdutos.stream()
                                            .filter(produto -> produto.getIdProduto().equals(idProduto))
                                            .findFirst()
                                            .get();

                                    produtoPedido.setProduto(produtoSelecionado);
                                    produtoPedido.setQuantidade(quantidadeDesejada);
                                    produtoPedido.setValor(produtoSelecionado.getValor()*quantidadeDesejada);
                                    pedido.getProdutosPedido().add(produtoPedido);
                                    pedido.setValorFinal(produtoPedido.getValor());
                                    System.out.println(produtoPedido);
                                }
                                System.out.println("PRODUTOS SELECIONADOS COM SUCESSO");
                                System.out.println(pedido);
                                System.out.println("---------------------------------");
                                System.out.println("Escolha um cupom para adicionar");
                                cupomService.listarCupons().forEach(System.out::println);
                                Integer cupomSelecionado = scanner.nextInt();
                                scanner.nextLine();

                                List<Cupom> listaCupons = cupomService.listarCupons();
                                Cupom cupom3 = listaCupons.stream()
                                        .filter(cupom -> cupom.getIdCupom().equals(cupomSelecionado))
                                        .findFirst()
                                        .get();

                                Pedido pedidoCriado = pedidoService.adicionarPedido(pedido);
//                                pedido.setCupom(cupom3);
//                                pedidoService.inserirCupom(cupom3,pedido);
//                                pedidoService.calcularValorFinal(pedido);
                                pedidoCriado.setCupom(cupom3);
                                double valorFinalComCupom = 0;
                                if (pedido.getCupom() != null && pedido.getCupom().getDeletado().equals("F")) {
                                    valorFinalComCupom = pedido.getValorFinal() - pedidoCriado.getCupom().getValor();
                                }
                                pedido.setValorFinal(valorFinalComCupom);
                                System.out.println("---------------------------------");
                                System.out.println(pedido);
                                System.out.println("---------------------------------");
                                scanner.nextLine();
                                System.out.println(pedidoCriado);
                                scanner.nextLine();
                                break;

                            }
                            case 3: {

                                // cadastro de produto
                                Produto produto = new Produto();

                                System.out.println("Digite o nome do produto: ");
                                produto.setNome(scanner.nextLine());

                                System.out.println("Digite a descrição do produto: ");
                                produto.setDescricao(scanner.nextLine());

                                System.out.println("Digite a quantidade de produtos: ");
                                produto.setQuantidade(scanner.nextInt());

                                System.out.println("Digite o tipo de produto (1-JOGOS 2-CONSOLE 3-COLECIONÁVEIS): ");
                                produto.setTipo(Tipos.ofTipo(scanner.nextLine()));
                                scanner.nextLine();

                                System.out.println("Digite o valor do produto por unidade: ");
                                produto.setValor(scanner.nextDouble());
                                break;
                            }
                            case 4: {
                                // edição de produto
                                System.out.println("Qual Produto você deseja editar ?");
                                produtoService.listarProdutos();

                                Produto editarproduto = new Produto();
                                scanner.nextLine();

                                System.out.println("Digite o nome do produto: ");
                                editarproduto.setNome(scanner.nextLine());
                                scanner.nextLine();

                                System.out.println("Digite a descrição do produto: ");
                                editarproduto.setDescricao(scanner.nextLine());

                                System.out.println("Digite a quantidade de produtos: ");
                                editarproduto.setQuantidade(scanner.nextInt());

                                System.out.println("Digite o tipo de produto (1-JOGOS 2-CONSOLE 3-COLECIONÁVEIS): ");
                                editarproduto.setTipo(Tipos.ofTipo(scanner.nextLine()));
                                scanner.nextLine();

                                System.out.println("Digite o valor do produto por unidade: ");
                                editarproduto.setValor(scanner.nextDouble());
                                break;
                            }
                            case 5: {
                                // exclusão de produto
                                System.out.println("Qual produto você deseja excluir?");
                                produtoService.listarProdutos();
                                boolean validouNumero = false;
                                while (!validouNumero) {
                                    try {
                                        int id = scanner.nextInt();
                                        produtoService.removerProduto(id);
                                        validouNumero = true;
                                    } catch (InputMismatchException ex) {
                                        System.err.println("numero invalido");
                                    }
                                }
                                break;
                            }

                            case 6: {
                                pedidoService.listarPedido();
                                break;
                            }

                            case 7: {
                                verdade = false;
                                break;
                            }
                        }
                    }
                }
                case 0:
                    break;
                default:
                    System.err.println("opção inválida");
                    break;
            }
        }
    }

    public static Usuario fazerLogin(UsuarioService usuarioService, Scanner entrada) {

        Usuario usuario = new Usuario();
        Usuario resultadoUser = null;

        try {
            while (true) {
                System.out.println("Digite o email ");
                usuario.setEmail(entrada.nextLine());
                System.out.println("Digite a senha:");
                usuario.setSenha(entrada.nextLine());
                Usuario usuarioEncontrado = usuarioService.verificarUsuario(usuario);
                if (usuarioEncontrado.getEmail().equals(usuario.getEmail()) && usuarioEncontrado.getSenha().equals(usuario.getSenha())) {
                    System.out.println("\n" + usuario.getEmail() + " Logado com sucesso!");
                    resultadoUser = usuarioEncontrado;
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultadoUser;
    }
}


