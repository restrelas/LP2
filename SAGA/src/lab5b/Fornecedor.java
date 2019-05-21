package lab5b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Classe que representa um fornecedor e armazena o conjunto de produtos daquele fornecedor
 */
public class Fornecedor implements Nomeavel{

    /**
     * Atributos privados, 3 Strings representando nome, email e telefone e um HashMap de Produtos identificados atravéz de IdProduto
     */
    private String nome;
    private String email;
    private String telefone;
    private HashMap<IdProduto, Produto> produtos;
    private HashMap<IdProduto, Combo> combos;

    /**
     * Inicializa uma nova variável do tipo Fornecedor, assim como um HashSet vazio
     * @param nome nome do fornecedor
     * @param email email do fornecedor
     * @param telefone telefone do fornecedor
     */
    public Fornecedor(String nome, String email, String telefone){
        if(nome == null || nome.equals("")) throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        if(email == null || email.equals("")) throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        if(telefone == null || telefone.equals("")) throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo");
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        produtos = new HashMap<IdProduto, Produto>();
        combos = new HashMap<IdProduto, Combo>();
    }

    /**
     * @return Representação textual do Fornecedor, nome, email e telefone separados por " - "
     */
    public String toString(){
        return nome + " - " + email + " - " + telefone;
    }

    /**
     * Altera o Email do Fornecedor
     * @param email novo email
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * Altera o telefone do fornecedor
     * @param telefone novo telefone
     */
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    /**
     * Adiciona um novo produto ao Fornecedor
     * Obs:
     *  O produto não pode existir
     *  Preco deve ser >= 0
     *  nenhum parametro pode ser vazio ou nulo
     * @param nome
     * @param descricao
     * @param preco
     */
    public void adicionaProduto(String nome, String descricao, double preco){
        if(nome == null || nome.equals("")) throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        if(descricao == null || descricao.equals("")) throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        if(preco < 0) throw new ArithmeticException("Erro no cadastro de produto: preco invalido.");
        IdProduto temp = new IdProduto(nome, descricao);
        if(produtos.containsKey(temp)) throw new Error("Erro no cadastro de produto: produto ja existe.");
        produtos.put(temp, new Produto(nome, descricao, preco));
    }

    /**
     * Representa um produto expecifico identificado pelo seu nome e descriçao
     * @param nome
     * @param descricao
     * @return Representação textual do produto
     */
    public String exibeProduto(String nome, String descricao){
        if(nome == null || nome.equals("")) throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        if(descricao == null || descricao.equals("")) throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        if(!produtos.containsKey(new IdProduto(nome, descricao))) throw new Error("Erro na exibicao de produto: produto nao existe.");
        return produtos.get(new IdProduto(nome, descricao)).toString();
    }

    /**
     * Edita o preço de um Produto especifico
     * @param nome nome do produto
     * @param descricao descricao do produto
     * @param preco novo preco a ser atrubuido ao produto
     * @return Nova representação textual do produto
     */
    public String editaProduto(String nome, String descricao, double preco){
        if(descricao == null || descricao.equals("")) throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        if(nome == null || nome.equals("")) throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        if(preco < 0) throw new ArithmeticException("Erro na edicao de produto: preco invalido.");
        IdProduto temp = new IdProduto(nome, descricao);
        if(!produtos.containsKey(temp)) throw new Error("Erro na edicao de produto: produto nao cadastrado.");
        produtos.get(temp).setPreco(preco);
        return produtos.get(temp).toString();
    }

    /**
     * lista todos os produtos do fornecedor
     * @return Representacao textual de todos os produtos do fornecedor separados por " - "
     */
    public String exibeProdutos(){
        NomeComparator comparator = new NomeComparator();
        String ans  = "";
        ArrayList<Produto> temp = new ArrayList<Produto>();
        for(Produto it : produtos.values()){
            temp.add(it);
        }
        Collections.sort(temp, comparator);
        for(Produto it : temp){
            ans += nome + " - " + it.toString() + " | ";
        }
        return ans.length() > 2 ? ans.substring(0, ans.length() -3) : nome + " -";
    }

    /**
     * Remove um produto do Fornecedor
     * Obs:
     *  O Produto deve existir
     *  Nenhum parametro pode ser vazio ou nulo
     * @param nome
     * @param descricao
     */
    public void removeProduto(String nome, String descricao){
        if(nome == null || nome.equals("")) throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        if(descricao == null || descricao.equals("")) throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        IdProduto temp = new IdProduto(nome, descricao);
        if(!produtos.containsKey(temp)) throw new Error("Erro na remocao de produto: produto nao existe.");
        produtos.remove(temp);
    }

    @Override
    public String getNome() {
        return this.nome;
    }
    //US4
    public void adicionaCombo(String nome, String descricao, double fator, String itens){
        if(combos.containsKey(nome)) throw new Error("Erro no cadastro de combo: combo ja existe.");
        double preco = 0;
        String[] temp = itens.split(", ");
        for(String it : temp){
            String[] sep = it.split(" - ");
            IdProduto p = new IdProduto(sep[0], sep[1]);
            if(combos.containsKey(sep[0]) || combos.containsKey(sep[1])) throw new Error("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
            if(!produtos.containsKey(p)) throw new Error("Erro no cadastro de combo: produto nao existe.");
            preco += produtos.get(p).getPreco();
        }
        preco *= (1.0 - fator);
        combos.put(new IdProduto(nome, descricao), new Combo(nome, descricao, fator, preco));
    }
}
