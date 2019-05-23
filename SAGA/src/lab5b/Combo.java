package lab5b;

import java.util.ArrayList;

public class Combo extends Produto {

    private double fator;
    private double precoatual;

    public Combo(String nome, String descricao, double fator, double preco, double precoatual){
        super(nome, descricao, preco);
        this.fator = fator;
        this.precoatual = precoatual;
    }

    @Override
    public String toString(){
        return nome + " - " + descricao + " - " + "R$" + String.format("%.2f", preco).replace('.', ',');
    }
    public void setFator(double novoFator){
        fator = novoFator;
        preco = precoatual * (1.0 - fator);
    }
}
