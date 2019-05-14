package lab5b;

import java.text.NumberFormat;
import java.util.Objects;

/**
 * Classe que representa produto
 */
public class Produto {
    /**
     * Atributos privados que armazenam nome, descricao e preco
     */
    public String nome;
    public String descricao;
    public double preco;

    /**
     * Inicializa um nova variavel do tipo Produto
     * @param nome nome do produto
     * @param descricao descricao do produto
     * @param preco valor atribuido ao produto
     */
    public Produto(String nome, String descricao, double preco){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    /**
     * modifica o preço do produto
     * @param preco
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString(){
        return nome + " - " + descricao + " - " + "R$" + String.format("%.2f", preco).replace('.', ',');

    }

    /**
     * Compara dois produtos a partir de nome e descricao
     * @param o
     * @return Hashcode atribuido ao objeto
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome) &&
                Objects.equals(descricao, produto.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }
}
