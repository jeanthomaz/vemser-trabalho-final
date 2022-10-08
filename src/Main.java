import java.sql.SQLOutput;
import java.util.*;


public class Main {


    public static void main(String[] args) {


        List<Produto> listaProdutos = new ArrayList<>();


        ProdutoManipulacao produtoManipulacao = new ProdutoManipulacao();
        CupomManipulacao cupomManipulacao = new CupomManipulacao();
        CarrinhoManipulacao carrinhoManipulacao = new CarrinhoManipulacao();

        Produto produto1 = new Produto("Carta Charizard", 1, 1, 450.0, "Carta charizard edição um", Tipos.COLECIONAVEL);
        Produto produto2 = new Produto("Carta Venusaur", 2, 1, 350.0, "Carta venusaur edição um", Tipos.COLECIONAVEL);

        produtoManipulacao.adicionarProduto(produto1);
        produtoManipulacao.adicionarProduto(produto2);

        Cupom cupoms1 = new Cupom(150.0, true);
        Cupom cupoms2 = new Cupom(250.0, true);
        cupomManipulacao.adicionarCupom(cupoms1);
        cupomManipulacao.adicionarCupom(cupoms2);

        Carrinho carrinho1 = new Carrinho(List.of(produto1), cupoms1);
        carrinhoManipulacao.adicionarCarrinho(carrinho1);
        Scanner entrada = new Scanner(System.in);

        int escolha = 9;
        Carrinho carrinho2 = new Carrinho();
        System.out.println("Boas compras, seu carrinho foi inicializado com sucesso !");
        while (escolha != 0) {
            System.out.println("");
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Adicionar produtos.");
            System.out.println("2 - Adicionar cupom");
            System.out.println("3 - Efetuar a compra");
            System.out.println("0 - Encerrar carrinho");

            escolha = entrada.nextInt();
            entrada.nextLine();
            switch (escolha) {
                case 1 -> {
                    System.out.println("Escolha seu produto: ");

                    produtoManipulacao.listarProdutos();

                    int prod = entrada.nextInt();

                    Produto selecionado = produtoManipulacao.getProduto(prod);

                    carrinho2.getProdutos().add(selecionado);

                    produtoManipulacao.removerProdutoPorIndice(prod);

                    System.out.println("Produtos adicionados com sucesso.");
                }
                case 2 -> {
                    System.out.println("Selecione seu cupom, caso possua um: ");

                    cupomManipulacao.listarCupons();

                    int ticket = entrada.nextInt();

                    Cupom selected = cupomManipulacao.getCupom(ticket);

                    carrinho2.setCupom(selected);

                    cupomManipulacao.removerCupomPorIndice(ticket);
                    System.out.println("Cupom adicionado com sucesso.");

                }
                case 3 -> {
                    System.out.println("Sua compra foi finalizada com sucesso.");
                    System.out.println(carrinho2);
                    System.out.println("O valor total de sua compra será de : " + carrinho2.getValor());
                    System.out.println("");
                    System.out.println("Digite 1 para concluir sua compra e efetuar o pagamento.");
                    System.out.println("Digite 2 para cancelar o seu carrinho");
                    int c = entrada.nextInt();
                    entrada.nextLine();
                    switch (c){
                        case 1 ->{
                            System.out.println("INSERIR CLIENTE.COMPRARA AQUI");
                        }
                        case 2 ->{

                            for (int i = 0; i < carrinho2.getProdutos().size(); i++){
                                produtoManipulacao.adicionarProduto(carrinho2.getProdutos().get(i));
                            }
//                            Iterator itr = carrinho2.getProdutos().iterator();
//                            while (itr.hasNext())
//                            {
//                               int x = (Produto) itr.next();
//                                if (x < 10)
//                                    itr.remove();
//                            }
                            cupomManipulacao.adicionarCupom(carrinho2.getCupom());
                        }
                    }
                }
                case 0 -> {
                    entrada.close();
                }
            }

        }
    }
}