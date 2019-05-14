package lab5b;

import java.util.Objects;

/**
 * Classe usada para identificar produtos atravéz do seu nome e descricao
 */
public class IdProduto {
    /**
     * Atributos privados, duas Strings que armazenam nome e descricao
     */
    String nome;
    String descricao;

    /**
     * Inicializa uma nova variavel IdProduto
     * @param nome
     * @param descricao
     */
    public IdProduto(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }

    /**
     * @return nome do produto
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * @return descricao do produto
     */
    public String getDescricao(){
        return this.descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdProduto idProduto = (IdProduto) o;
        return Objects.equals(nome, idProduto.nome) &&
                Objects.equals(descricao, idProduto.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }
}
