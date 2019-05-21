package lab5b;

import java.util.ArrayList;

public class Combo {

    private String nome;
    private String descricao;
    private double fator;
    private double preco;

    public Combo(String nome, String descricao, double fator, double preco){
        this.nome = nome;
        this.descricao = descricao;
        this.fator = fator;
        this.preco = preco;
    }

    @Override
    public String toString(){
        return nome + " - " + descricao + " - " + "R$" + String.format("%.2f", preco).replace('.', ',');
    }
}
