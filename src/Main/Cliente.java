package Main;

import java.util.ArrayList;

public class Cliente {

    private int cpf;
    private String nome;
    private static ArrayList<Item> itens = new ArrayList<>();
    private String formaDePagamento="";

    public Cliente(int id, String nome) {
        this.cpf = id;
        this.nome = nome;
    }

    public  ArrayList<Item> getItens() {
        return itens;
    }

    public  void setItens(ArrayList<Item> itens) {
        Cliente.itens = itens;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public int getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }
}
