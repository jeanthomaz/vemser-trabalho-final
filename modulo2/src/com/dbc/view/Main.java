package com.dbc.view;

import com.dbc.enums.Tipos;
import com.dbc.model.Pedido;
import com.dbc.model.Produto;
import com.dbc.model.Usuario;
import com.dbc.model.Cupom;
import com.dbc.exceptions.*;

import com.dbc.repository.PedidoRepository;
import com.dbc.repository.UsuarioRepository;
import com.dbc.service.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ProdutoService produtoService = new ProdutoService();
        PedidoService pedidoService = new PedidoService();
        CupomService cupomService = new CupomService();
        UsuarioService usuarioService = new UsuarioService();

        //EDITAR DAQUI PRA BAIXO ///



        int opcao = -1;
        int escolha = 9;
        int choise = -1;

        while (opcao != 0) {
            System.out.println("Digite 1 para realizar seu cadastro");
            System.out.println("Digite 2 para editar um usuário");
            System.out.println("Digite 3 para excluir um usuário");
            System.out.println("Digite 4 para listar os usuarios");
            System.out.println("Digite 5 para logar em sua conta");
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
                    user.setCpf(scanner.nextInt());

                    System.out.println("Digite sua cidade: ");
                    user.setCidade(scanner.nextLine());

                    System.out.println("Digite seu estado: ");
                    user.setEstado(scanner.nextLine());

                    System.out.println("Digite seu telefone: ");
                    user.setTelefone(scanner.nextInt());

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
                    System.out.println("Digite o seu nome: ");
                    newUser.setNome(scanner.nextLine());

                    System.out.println("Digite o seu endereço: ");
                    newUser.setEndereco(scanner.nextLine());

                    System.out.println("Digite o seu CPF: ");
                    newUser.setCpf(scanner.nextInt());

                    System.out.println("Digite sua cidade: ");
                    newUser.setCidade(scanner.nextLine());

                    System.out.println("Digite seu estado: ");
                    newUser.setEstado(scanner.nextLine());

                    System.out.println("Digite seu telefone: ");
                    newUser.setTelefone(scanner.nextInt());

                    System.out.println("Digite seu email: ");
                    newUser.setEmail(scanner.nextLine());

                    System.out.println("Digite sua senha: ");
                    newUser.setSenha(scanner.nextLine());

                    System.out.println("Digite o seu pix: ");
                    newUser.setPix(scanner.nextLine());

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
                    usuario = fazerLogin(scanner, usuarioService);

                    while(usuario == null) {
                        usuario = fazerLogin(scanner, usuarioService);
                    }

                    System.out.println("---- Login efetuado com sucesso -----");
                    System.out.println("Digite 1 para listar os produtos disponiveis na loja");
                    System.out.println("Digite 2 para realizar um pedido");
                    System.out.println("Digite 3 para cadastrar um produto");
                    System.out.println("Digite 4 para alterar informações de um produto já cadastrado por você");
                    System.out.println("Digite 5 para excluir um produto cadastrado por você da lista");

                    escolha = scanner.nextInt();
                    scanner.nextInt();

                    switch (escolha) {
                        case 1: {
                            // listagem produtos
                            produtoService.listarProdutos();
                            break;
                        }
                        case 2: {
                            //Realiza a compra dos pedidos
                            Pedido pedido = new Pedido();
                            produtoService.listarProdutos();
                            System.out.println("Escolha seu produto pelo ID");
                            pedido.getp();
                            pedidoService.adicionarPedido(pedido);



                        }
                        case 3 : {

                            // cadastro de produto
                            Produto produto = new Produto();

                            System.out.println("Digite o nome do produto: ");
                            produto.setNome(scanner.nextLine());

                            System.out.println("Digite a descrição do produto: ");
                            produto.setDescricao(scanner.nextLine());

                            System.out.println("Digite a quantidade de produtos: ");
                            produto.setQuantidade(scanner.nextInt());

                            System.out.println("Digite o tipo de produto (1-JOGOS 2-CONSOLE 3-COLECIONÁVEIS): ");
                            produto.setTipo(Tipos.ofTipo(scanner.nextInt()));
                            scanner.nextLine();

                            System.out.println("Digite o valor do produto por unidade: ");
                            produto.setValor(scanner.nextDouble());
                            break;
                        }
                        case 4 : {
                            // edição de produto
                            System.out.println("Qual Produto você deseja editar ?");
                            produtoService.listarProdutos();

                            Produto editarproduto = new Produto();
                            scanner.nextLine();

                            System.out.println("Digite o nome do produto: ");
                            editarproduto.setNome(scanner.nextLine());

                            System.out.println("Digite a descrição do produto: ");
                            editarproduto.setDescricao(scanner.nextLine());

                            System.out.println("Digite a quantidade de produtos: ");
                            editarproduto.setQuantidade(scanner.nextInt());

                            System.out.println("Digite o tipo de produto (1-JOGOS 2-CONSOLE 3-COLECIONÁVEIS): ");
                            editarproduto.setTipo(Tipos.ofTipo(scanner.nextInt()));
                            scanner.nextLine();

                            System.out.println("Digite o valor do produto por unidade: ");
                            editarproduto.setValor(scanner.nextDouble());
                            break;
                        }
                        case 5 : {
                            // exclusão de produto
                            System.out.println("Qual produto você deseja excluir?");
                            produtoService.listarProdutos();
                            boolean validouNumero = false;
                            while (!validouNumero){
                                try{
                                    int id = scanner.nextInt();
                                    produtoService.removerProduto(id);
                                    validouNumero = true;
                                } catch (InputMismatchException ex){
                                    System.err.println("numero invalido");
                                }
                            }
                            break;
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
}

    public static Usuario fazerLogin(Scanner entrada, UsuarioService usuarioService) throws BancoDeDadosException {
        try {
            System.out.println("Digite o email");
            String email = entrada.nextLine();
            System.out.println("Digite uma senha");
            String senha = entrada.nextLine();
            return usuarioService.fazerLogin(email, senha);
        } catch (EmailRepetidoException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            return null;
        }
    }
}

