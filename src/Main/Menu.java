package Main;

import Utils.Inputs;

public class Menu {

    public static void controleMenu() {
        Estoque.inicializaEstoque();
        do {
            mostraMenu();
        } while (switchCase());
    }

    public static void mostraMenu() {
        System.out.println("------------MENU------------");
        System.out.println("1 - MOSTRAR CATALOGO");
        System.out.println("2 - ADICIONAR ITEM AO CARRINHO");
        System.out.println("4 - RETIRAR ITEM DO CARRINHO");
        System.out.println("5 - FINALIZAR PEDIDO");
        System.out.println("0 - ENCERRAR");
    }

    public static boolean switchCase() {
        System.out.println("ESCOLHA UMA OPCAO: ");
        try {
            switch (Inputs.inputInt()) {
                case 1:
                    Estoque.imprimeCatalagoDoEstoque();
                    return true;
                case 2:
                    Pedido.adicionaItem();
                    return true;
                case 3:
                    Pedido.imprimePedido();
                    return true;
                case 4:
                    Pedido.retiraItem();
                    return true;
                case 0:
                    return false;
                default:
                    System.out.println("\nOpcao invalida!!\n");
                    return true;
            }
        } catch (Exception e) {
            System.out.println("\nValor informado nao eh um numero!\n");
            return true;
        }
    }

}
