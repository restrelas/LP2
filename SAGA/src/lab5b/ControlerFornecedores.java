package lab5b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Gerencia as operacoes feitas com Fornecedores e Produtos, e armazena os fornecedores
 */
public class ControlerFornecedores {
    /**
     * Atrubuto privado que guarda os Fornecedores e os referencia pelo nome
     */
    HashMap<String, Fornecedor> fornecedores;

    /**
     * Inicializa um ControlerFornecedores com um HashMap de fornecedores vazio
     */
    public ControlerFornecedores() {
        fornecedores = new HashMap<String, Fornecedor>();
    }

    /**
     * Cria e armazena um novo fornecedor
     * @param nome
     * @param email
     * @param telefone
     * @return nome do fornecedor
     */
    public String adicionaFornecedor(String nome, String email, String telefone){
        if(fornecedores.containsKey(nome)) throw new Error("Erro no cadastro de fornecedor: fornecedor ja existe.");
        fornecedores.put(nome, new Fornecedor(nome, email, telefone));
        return nome;
    }

    /**
     * Verifica se o fornecedor existe e retorna uma String
     * @param nome
     * @return Representação textual do fornecedor especificado
     */
    public String exibeFornecedor(String nome){
        if(!fornecedores.containsKey(nome)) throw new Error("Erro na exibicao do fornecedor: fornecedor nao existe.");
        return fornecedores.get(nome).toString();
    }

    /**
     * Exibe todos os fornecedores já registrados
     * @return Representação textual de todos os fornecedores separados por " - "
     */
    public String exibeFornecedores(){
        NomeComparator comparator = new NomeComparator();
        String temp = new String();
        ArrayList<Fornecedor> c = new ArrayList<Fornecedor>();
        for(String it : fornecedores.keySet()){
            c.add(fornecedores.get(it));
        }
        Collections.sort(c, comparator);
        for(Fornecedor it : c){
            temp += it.toString() + " | ";
        }
        return temp.length() > 2 ? temp.substring(0, temp.length() -3) : temp;
    }

    /**
     * edita um atributo do fornecedor comforme o especificado
     * @param nome nome do fornecedor a ser editado
     * @param atributo Atributo do Fornededor que deve ser editado
     *        Parametros aceitados: nome, email, telefone.
     * @param novoValor novo valor a ser atribuito ao atributo especificado
     */
    public void editaFornecedor(String nome, String atributo, String novoValor){
        if(nome == null || nome.equals("")) throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
        if(atributo == null || atributo.equals("")) throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        if(novoValor == null || novoValor.equals("")) throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        if(atributo.equals("nome")) throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
        if(!fornecedores.containsKey(nome)) throw new Error("Erro na edicao do fornecedor: fornecedor nao existe.");
        else if(atributo.equals("email")) fornecedores.get(nome).setEmail(novoValor);
        else if(atributo.equals("telefone")) fornecedores.get(nome).setTelefone(novoValor);
        else throw new Error("Erro na edicao do fornecedor: atributo nao existe.");
    }

    /**
     * Remove um fornecedor anteriormente adicionado
     * @param nome nome do forncededor a ser removido
     */
    public void removeFornecedor(String nome){
        if(nome == null || nome.equals("")) throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
        if(!fornecedores.containsKey(nome)) throw new Error("Erro na remocao do fornecedor: fornecedor nao existe.");
        fornecedores.remove(nome);
    }
    //US3

    /**
     * Adiciona um produto a um fornecedor, portanto que o fornecedor esteja registrado e o produto ainda não pertença ao fornecedor
     * obs:
     *  preço do produto deve ser >= 0
     *  e nenhum parametro pode ser vazio ou nulo
     * @param fornecedor
     * @param nome
     * @param descricao descricao atrubuida
     * @param preco
     */
    public void adicionaProduto(String fornecedor, String nome, String descricao, double preco){
        if(fornecedor == null || fornecedor.equals("")) throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        if(!fornecedores.containsKey(fornecedor)) throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
        fornecedores.get(fornecedor).adicionaProduto(nome, descricao, preco);
    }

    /**
     * Exibe um a representação textual de um produto
     * obs:
     *   O fornecedor deve estar cadastrado
     *   O produto deve pertencer ao fornecedor
     *   Nenhum dos parametros pode ser vazio ou nulo
     * @param nome nome do produto a ser exibido
     * @param descricao descricao do produto a ser exibido
     * @param fornecedor nome do fornecedor
     * @return Representação textual do produto especificado
     */
    public String exibeProduto(String nome, String descricao, String fornecedor){
        if(fornecedor == null || fornecedor.equals("")) throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        if(!fornecedores.containsKey(fornecedor)) throw new Error("Erro na exibicao de produto: fornecedor nao existe.");
        return fornecedores.get(fornecedor).exibeProduto(nome, descricao);
    }

    /**
     * Ordena os fornecedores pelo nome, e lista todos os produtos de cada fornecedor, pela ordem de inserção dos produtos
     * @return Representacao textual de todos os produtos de todos os fornecedores ja registrados
     */
    public String exibeProdutos(){
        NomeComparator comparator = new NomeComparator();
        String temp = new String();
        ArrayList<Fornecedor> c = new ArrayList<Fornecedor>();
        for(String it : fornecedores.keySet()){
            c.add(fornecedores.get(it));
        }
        Collections.sort(c, comparator);
        for(Fornecedor it : c){
            temp += it.exibeProdutos() + " | ";
        }
        return temp.length() > 2 ? temp.substring(0, temp.length() -3) : temp;
    }

    /**
     * Exibe todos os produtos do fornecedor
     * @param nomeFornecedor Nome do fornecedor que deve ter os produtos imprimidos
     * @return Representacao textual de todos os produtos de um fornecedor
     */
    public String exibeProdutosFornecedor(String nomeFornecedor){
        if(nomeFornecedor == null || nomeFornecedor.equals("")) throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        if(!fornecedores.containsKey(nomeFornecedor)) throw new Error("Erro na exibicao de produto: fornecedor nao existe.");
        return fornecedores.get(nomeFornecedor).exibeProdutos();
    }
    /**
     * Modifica o preco de um produto
     * obs:
     *   O fornecedor deve estar cadastrado
     *   O produto deve pertencer ao fornecedor
     *   Nenhum dos parametros pode ser vazio ou nulo
     * @param nome nome do produto a ser exibido
     * @param descricao descricao do produto a ser exibido
     * @param fornecedor nome do fornecedor
     * @param preco novo preco do produto
     * @return Nova representação textual do produto após sua alteração
     */
    public String editaProduto(String nome, String descricao, String fornecedor, double preco){
        if(fornecedor == null || fornecedor.equals("")) throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        if(!fornecedores.containsKey(fornecedor)) throw new Error("Erro na edicao de produto: fornecedor nao existe.");
        return fornecedores.get(fornecedor).editaProduto(nome, descricao, preco);
    }

    /**
     * Deleta um produto do fornecedor
     * @param nome nome do produto
     * @param descricao descricao do produto
     * @param fornecedor nome do fornecedor
     */
    public void removeProduto(String nome, String descricao, String fornecedor){
        if(fornecedor == null || fornecedor.equals("")) throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        if(!fornecedores.containsKey(fornecedor)) throw new Error("Erro na remocao de produto: fornecedor nao existe.");
        fornecedores.get(fornecedor).removeProduto(nome, descricao);
    }
    //US4

    public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos){
        if(fornecedor == null || fornecedor.equals("")) throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
        if(nome == null || nome.equals("")) throw new IllegalArgumentException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
        if(descricao == null || descricao.equals("")) throw new IllegalArgumentException("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
        if(produtos == null || produtos.equals("")) throw new IllegalArgumentException("Erro no cadastro de combo: combo deve ter produtos.");
        if(!fornecedores.containsKey(fornecedor)) throw new Error("Erro no cadastro de combo: fornecedor nao existe.");
        if(fator <= 0 || fator >= 1) throw new ArithmeticException("Erro no cadastro de combo: fator invalido.");
        fornecedores.get(fornecedor).adicionaCombo(nome, descricao, fator, produtos);
    }
    public void editaCombo(String nome, String descricao, String fornecedor, double novoFator){
        if(fornecedor == null || fornecedor.equals("")) throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
        if(nome == null || nome.equals("")) throw new IllegalArgumentException("Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
        if(descricao == null || descricao.equals("")) throw new IllegalArgumentException("Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
        if(!fornecedores.containsKey(fornecedor)) throw new Error("Erro na edicao de combo: fornecedor nao existe.");
        if(novoFator <= 0 || novoFator >= 1) throw new ArithmeticException("Erro na edicao de combo: fator invalido.");
        fornecedores.get(fornecedor).editaCombo(nome, descricao, novoFator);
    }
    //US6
    public Produto getProduto(String fornecedor, String nome, String descricao){
        if(!fornecedores.containsKey(fornecedor)) throw new Error("Erro ao cadastrar compra: fornecedor nao existe.");
        return fornecedores.get(fornecedor).getProduto(nome, descricao);
    }
    public boolean checkFornecedor(String fornecedor){
        return fornecedores.containsKey(fornecedor);
    }
}
