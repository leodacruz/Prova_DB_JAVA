package Main;

import Utils.Inputs;

import java.util.ArrayList;

public class Pedido {

    private static ArrayList<Item> listaDeItens = new ArrayList<>();
    private static double valorTotalDoPedido = 0;

    public static void calculaValorTotal() {
        double subTotal = 0;
        for (Item item : listaDeItens) {
            subTotal += item.getValorDoItem();
        }
        valorTotalDoPedido = subTotal;
    }

    public static boolean adicionaItemNaLista(Produto produto, int quantidade) {
        System.out.println(produto.getNome());
        // primeiro ve se o produto ja existe na lista de itens
        for (Item item : listaDeItens) {
            if (item.getProduto().getNome().equals(produto.getNome())) {

                if (Estoque.temEstoqueOuNao(produto, quantidade)) { //isso me garante que nunca ira tirar mais do que tem no estoque
                    Estoque.darBaixaEmEstoque(item.getProduto().getId(), quantidade); //da pra simplificar esse metodo
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
        System.out.println("                              NOTA FISCAL");
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
        System.out.println("________________________________________________________________________");
        System.out.println();
        System.out.println();
    }

    public static void adicionaItem() { // arrumei todo esse metodo,tava estranho
        String nome = recebeNomeDoTeclado();
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
}
