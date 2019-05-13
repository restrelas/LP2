package lab5b;

import java.util.HashMap;

public class SAGA {

	HashMap<String, Cliente> clientes;
	HashMap<String, Fornecedor> fornecedores;
	
	public SAGA() {
		clientes = new HashMap<String, Cliente>();
		fornecedores = new HashMap<String, Fornecedor>();
	}
//	US1
	public String cadastrarCliente(String cpf, String nome, String email, String local) {
		if(cpf.length() != 11) throw new Error("Erro no cadastro do cliente: cpf invalido.");
		if(clientes.containsKey(cpf)) throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		clientes.put(cpf, new Cliente(cpf, nome, email, local));
		return cpf;
	}
	public String exibeCliente(String cpf) {
		if(clientes.containsKey(cpf)) return clientes.get(cpf).toString();
		throw new Error("Erro na exibicao do cliente: cliente nao existe.");
	}
	
	public String exibeClientes() {
		String temp = new String();
		for(Cliente it : clientes.values()) {
			temp += it.toString() + " - ";
		}
		return temp.length() > 2 ? temp.substring(0, temp.length() - 3) : temp;
	}
	public void editaCliente(String cpf, String atributo, String novoValor) {
		if(!clientes.containsKey(cpf)) throw new Error("Erro na edicao do cliente: cliente nao existe.");
		if(atributo.equals("") || atributo == null) throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		if(novoValor.equals("") || novoValor == null) throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		if(atributo.equals("nome")) clientes.get(cpf).setNome(novoValor);
		else if(atributo.equals("cpf")) throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
		else if(atributo.equals("email")) clientes.get(cpf).setEmail(novoValor);
		else if(atributo.equals("localizacao")) clientes.get(cpf).setLocal(novoValor);
		else throw new Error("atributo nao existe.");
	}
	public void removeCliente(String cpf){
		if(clientes.containsKey(cpf)) clientes.remove(cpf);
		else throw new Error("cliente nao existe.");
	}
//	US2
	public String adicionaFornecedor(String nome, String email, String telefone){
		if(nome == null || nome.equals("")) throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		if(email == null || email.equals("")) throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		if(telefone == null || telefone.equals("")) throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo");
		if(fornecedores.containsKey(nome)) throw new Error("fornecedor ja existe.");
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
//	US3
	public void adicionaProduto(String forecedor, String nome, String descricao, double preco){

	}
}
