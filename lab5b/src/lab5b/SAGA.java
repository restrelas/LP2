package lab5b;

import java.util.HashMap;

public class SAGA {

	HashMap<String, Cliente> clientes;
	
	
	public SAGA() {
		clientes = new HashMap<String, Cliente>();
	}
	
	public String cadastrarCliente(String cpf, String nome, String email, String local) {
		if(cpf.length() != 11) throw new Error("Erro no cadastro do cliente: cpf invalido.");
		if(clientes.containsKey(cpf)) throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		Cliente temp = new Cliente(cpf, nome, email, local);
		clientes.put(cpf, temp);
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
		if(!clientes.containsKey(cpf)) throw new Error("cliente nao existe.");
		if(atributo.equals("") || atributo == null) throw new IllegalArgumentException("atributo nao pode ser vazio ou nulo.");
		if(novoValor.equals("") || novoValor == null) throw new IllegalArgumentException("novo valor nao pode ser vazio ou nulo.");
		if(atributo.equals("nome")) clientes.get(cpf).setNome(novoValor);
		else if(atributo.equals("email")) clientes.get(cpf).setEmail(novoValor);
		else if(atributo.equals("localizacao")) clientes.get(cpf).setLocal(novoValor);
		else throw new Error("atributo nao existe.");
	}
	public void removeCliente(String cpf){
		if(clientes.containsKey(cpf)) clientes.remove(cpf);
		else throw new Error("cliente nao existe.");
	}
}
