package lab5b;

import java.util.HashMap;

public class ControlerFornecedores {

    HashMap<String, Fornecedor> fornecedores;

    public ControlerFornecedores() {
        fornecedores = new HashMap<String, Fornecedor>();
    }

    public String adicionaFornecedor(String nome, String email, String telefone){
        if(nome == null || nome.equals("")) throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        if(email == null || email.equals("")) throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        if(telefone == null || telefone.equals("")) throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo");
        if(fornecedores.containsKey(nome)) throw new Error("Erro no cadastro de fornecedor: fornecedor ja existe.");
        fornecedores.put(nome, new Fornecedor(nome, email, telefone));
        return nome;
    }
    public String exibeFornecedor(String nome){
        if(!fornecedores.containsKey(nome)) throw new Error("Erro na exibicao do fornecedor: fornecedor nao existe.");
        return fornecedores.get(nome).toString();
    }
    public String exibeFornecedores(){
        String temp = new String();
        for(Fornecedor it : fornecedores.values()){
            temp += it.toString() + " - ";
        }
        return temp.length() > 2 ? temp.substring(0, temp.length() -3) : temp;
    }
    public void editaFornecedor(String nome, String atributo, String novoValor){
        if(!fornecedores.containsKey(nome)) throw new Error("Erro na edicao do fornecedor: fornecedor nao existe.");
        if(atributo.equals("") || atributo == null) throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        if(novoValor.equals("") || novoValor == null) throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        if(atributo.equals("nome")) throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
        else if(atributo.equals("email")) fornecedores.get(nome).setEmail(novoValor);
        else if(atributo.equals("telefone")) fornecedores.get(nome).setTelefone(novoValor);
        else throw new Error("Erro na edicao do fornecedor: atributo nao existe.");
    }
    public void removeFornecedor(String nome){
        if(nome.equals("") || nome == null) throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
        if(!fornecedores.containsKey(nome)) throw new Error("Erro na remocao do fornecedor: fornecedor nao existe.");
        fornecedores.remove(nome);
    }
}
