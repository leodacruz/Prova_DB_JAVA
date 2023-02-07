package Main;

import Utils.Inputs;

import java.util.ArrayList;

public class Pedido {

    private static Cliente cliente;
    private static ArrayList<Item> listaDeItens = new ArrayList<>();
    private static double valorTotalDoPedido = 0;
    private static String metodoDePagamento ="";

    public static void calculaValorTotal() {
        double subTotal = 0;
        for (Item item : listaDeItens) {
            subTotal += item.getValorDoItem();
        }
        valorTotalDoPedido = subTotal;
    }

    public static boolean adicionaItemNaLista(Produto produto, int quantidade) {
        // primeiro ve se o produto ja existe na lista de itens
        for (Item item : listaDeItens) {
            if (item.getProduto().getNome().equals(produto.getNome())) {

                if (Estoque.temEstoqueOuNao(produto, quantidade)) { // isso me garante que nunca ira tirar mais do que
                                                                    // tem no estoque
                    Estoque.darBaixaEmEstoque(item.getProduto().getId(), quantidade); // da pra simplificar esse metodo
                    item.setQuantidade(item.getQuantidade() + quantidade);
                    item.defineValorTotal();
                    System.out.println("Foi adicionada a quantidade ao item ja existente.");
                    return true;
                } else {
                    System.out.println("Quantidade execede o limite atual de estoque");
                    return false;
                }
            }
        }
        // isso ele sempre faz quando o produto ainda nao foi adicionado na lista de
        // itens
        if (Estoque.temEstoqueOuNao(produto, quantidade)) {
            listaDeItens.add(new Item(produto, quantidade));
            Estoque.darBaixaEmEstoque(produto.getId(), quantidade);
            System.out.println("Foi adicionado o produto na lista de compras.");
            return true;

        } else {
            System.out.println("Quantidade do produto excede o limite em estoque");
            return false;
        }
    }

    public static void imprimePedido() {
        System.out.println("\n_____________________________________________________________________________________");
        System.out.println("                              NOTA FISCAL");
        System.out.printf("ID       |NOME            |PRECO UN           |QUANTIDADE   |PRECO ITEM \n");
        for (Item item : listaDeItens) {
            System.out.printf("%-8d | %-14s | R$%-15.2f | %-10d  | R$%.2f\n", item.getProduto().getId(),
                    item.getProduto().getNome(),
                    item.getProduto().getPreco(), item.getQuantidade(), item.getValorDoItem());
        }
        imprimeValorTotal();
    }

    public static void imprimeCarrinho() {
        // ve se a lista esta vazia
        if (listaDeItens.size() == 0) {
            System.out.println("\nSUA LISTA DE COMPRAS ESTA VAZIA\n");
            return;
        }
        System.out.println("_____________________________________________________________________________________");
        System.out.println("                              SEU CARRINHO DE COMPRAS");
        System.out.printf("ID       |NOME            |PRECO UN           |QUANTIDADE   |PRECO ITEM \n");
        for (Item item : listaDeItens) {
            System.out.printf("%-8d | %-14s | R$%-15.2f | %-10d  | R$%.2f\n", item.getProduto().getId(),
                    item.getProduto().getNome(),
                    item.getProduto().getPreco(), item.getQuantidade(), item.getValorDoItem());
        }
        imprimeValorTotal();

    }

    private static void imprimeValorTotal() {
        System.out.println();
        System.out.printf("Total: R$%.2f", valorTotalDoPedido);
        System.out
                .println("\n_____________________________________________________________________________________\n\n");
    }

    public static void adicionaItem() { // arrumei todo 3esse metodo,tava estranho

        // aqui precisa de um controle de excecoes
        String nome;
        try {
            nome = recebeNomeDoTeclado();
        } catch (Exception e) {
            System.out.println("ERRO AO INFORMAR O NOME DO ITEM");
            return;
        }

        Produto produto = Estoque.encontraProduto(nome);

        // dois filtros pre baixa do estoque

        // para ver se o produto existe no estoque
        if (produto == null) {
            System.out.println("Produto nao encontrado");
            return;
        }

        // ver se o produto tem alguma quantidade no estoque
        if (Estoque.getQuantidadeAtualEmEstoque(produto) <= 0) {
            System.out.println("Produto sem estoque no momento");
            return;
        }

        // aqui precisa de um controle de excecoes
        int quantidade;
        try {
            quantidade = recebeQuantidadeDoTeclado();
        } catch (Exception e) {
            System.out.println("ERRO AO INFORMAR UM NUMERO");
            return;
        }

        // caso o item foi adicionado na lista tu faz o calculo do valor total
        if (adicionaItemNaLista(produto, quantidade)) {
            calculaValorTotal();
        }
    }

    public static String recebeNomeDoTeclado() {
        System.out.print("Digite o nome: ");
        return Inputs.inputString();
    }

    public static int recebeQuantidadeDoTeclado() {
        System.out.print("Digite a quantidade: ");
        return Inputs.inputInt();
    }

    public void limparCarrinho() {
        listaDeItens.clear();
    }

    public static ArrayList<Item> getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(ArrayList<Item> listaDeItens) {
        Pedido.listaDeItens = listaDeItens;
    }

    public double getValorTotalDoPedido() {
        return valorTotalDoPedido;
    }

    public void setValorTotalDoPedido(double valorTotalDoPedido) {
        Pedido.valorTotalDoPedido = valorTotalDoPedido;
    }

    public static void retiraItem() {

        // Mostra o carrinho de compras para o usuario
        imprimeCarrinho();

        // pede para o usuario informar qual item quer retirar
        System.out.println("Informe o Item que deseja retirar do carrinho");

        // tratamento da excecao
        String nome;
        try {
            nome = recebeNomeDoTeclado();
        } catch (Exception e) {
            System.out.println("ERRO AO INFORMAR O NOME DO ITEM"); // nem sei como ativar essa excecao
            return;
        }

        // ver se o produto existe na lista de compras
        Item item = temNaLista(nome);
        if (item == null) {
            System.out.println("Produto não existe na sua  lista de compras");
            return;
        }

        // removo o item da lista de compras, mas antes reponho ele no estoque
        Estoque.reporEstoqueProduto(item); // repor o estoque deste produto
        System.out.println("\nProduto removido com sucesso!!\n");
        listaDeItens.remove(item); // removo ele da lista de compras

    }

    public static Item temNaLista(String nome) {
        for (Item item : listaDeItens) {
            if (item.getProduto().getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        return null;
    }

    public static void finalizarCompra() {
        // mostar o carrinho e perguntar se quer finalizar a compra
        // deixe ele se identificar caso queira(Gerar nota fiscal-opcao secreta numero
        // 99) ok
        // metodo de pagamento
        // cartao de credito ou dinheiro
        // cartao de credito eh permitido parcelar mas dependendo da quantidade possuiu
        // juros
        // tabela de juros
        // ate 200 3x sem juros; max limite de parcelas
        // ate 400 6x sem juros; 8x com juros 10% do valor
        // ate 600 8 sem juros;10x com juros 10% do valor
        // acima de 600 10x sem juros;12 com juros 10% valor

        // apos finalizar a compra aparece a nota fiscal (dai sim usa o imprimePedido)
        // apos finalizar a compra salva a nota fiscal e limpa a lista de compras
        // talvez criar o metodo de salvar um arquivo como nota fiscal mesmo, acho que
        // seria legal
        // mas pode ser só o print na tela mesmo que da certo tb

        // deixar uma opcao secreta que aparece as vendas de todos os clientes do dia

        // na opcao de pagar com dinheiro
        // se a pessoa dar um valor maior que o preco final devolver o troco certinho
        // se a pessoa dar um valor inferior,oferecer tres opcoes de retirar um item do
        // carrinho, voltar para formas de pagamento e cancelar compra(limpa o carrinho)

        // cadastro cliente
        // ------------------------------------------------------------------------------------------------------------
        System.out.println("FINALIZAR COMPRA");
        imprimeCarrinho();
        System.out.println("VOCE DESEJA CPF NA NOTA?\n DIGITE 1 PARA SIM, 2 PARA NAO OU 0 PARA VOLTAR");

        Cliente clienteAux; //varivael aux para salvar o prox cliente

        try {
            switch (Inputs.inputInt()) {
                case 1:
                    clienteAux = criaCliente();
                    break;
                case 2:
                    clienteAux = new Cliente((NotasFiscais.TotalDeNotas() + 1), null);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("VOCE NAO ESCOLHEU UMA OPCAO VALIDA, VOLTANDO");
                    return;
            }
        } catch (Exception e) {
            System.out.println("VOCE NAO ESCOLHEU UM NUMERO, VOLTANDO");
            return;
        }

        // continuar compra
        // -------------------------------------------------------------------------------------------------------------------

        System.out.println("ESCOLHA SEU METODO DE PAGAMENTO");
        System.out.println("DIGITE 1 PARA COMPRAR COM CARTAO DE CREDITO   ");
        System.out.println("DIGITE 2 PARA COMPRAR COM DINHEIRO   ");
        System.out.println("DIGITE 0 PARA VOLTAR   ");

        String metodoDePagamentoAux; //variavel auxiliar para salvar metodo de pagamento
        try {
            switch (Inputs.inputInt()) {
                case 1:
                    metodoDePagamentoAux = pagamentoComCartaoCredito();
                    break;
                case 2:
                    metodoDePagamentoAux = pagamentoComDinheiro();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("VOCE NAO ESCOLHEU UMA OPCAO VALIDA, VOLTANDO");
                    return;
            }
        } catch (Exception e) {
            System.out.println("VOCE NAO ESCOLHEU UM NUMERO, VOLTANDO");
            return;
        }

        //Compra finalizada !!-----------------------------------------------------------------------------------------------------------------------
        System.out.println("SUA NOTA FISCAL");
        imprimePedido();
        System.out.println("SEU METODO DE PAGAMENTO\n"+metodoDePagamento);
        cliente = clienteAux; //atribuo o cliente auxiliar no Atributo Cliente da classe
        metodoDePagamento = metodoDePagamentoAux;
        
        NotasFiscais.addNotaFiscal(new Pedido());
        



    }

    public static Cliente criaCliente() {
        String nome;
        int cpf;

        // Para informar o nome
        System.out.println("INFORME SEU NOME");
        try {
            nome = Inputs.inputString();
        } catch (Exception e) {
            System.out.println("ERRO AO INFORMAR SEU NOME");
            System.out.println("SEU NOME FOI DEFINIDO PARA FULANO(A)");
            nome = "FULANO(A)";
        }

        // para identificar o cpf
        System.out.println("INFORME SEU NOME");
        try {
            cpf = Inputs.inputInt();
        } catch (Exception e) {
            System.out.println("ERRO AO INFORMAR SEU NOME");
            System.out.println("SEU NOME FOI DEFINIDO PARA FULANO(A)");
            cpf = listaDeClientes.size() + 1;
        }

        return new Cliente(cpf, nome);
    }

    public static String pagamentoComCartaoCredito(){
        return " pagou com cartao";
    }

    public static String pagamentoComDinheiro(){
        return " pagou com dinheiro";
    }
}
