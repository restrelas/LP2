package lab5b;

import java.util.HashMap;

public class ControlerClientes {

	HashMap<String, Cliente> clientes;
	
	public ControlerClientes() {
		clientes = new HashMap<String, Cliente>();
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
		else throw new Error("Erro na edicao do cliente: atributo nao existe.");
	}
	public void removeCliente(String cpf){
		if(clientes.containsKey(cpf)) clientes.remove(cpf);
		else throw new Error("cliente nao existe.");
	}
//	US2

//	US3
	public void adicionaProduto(String forecedor, String nome, String descricao, double preco){

	}
}
