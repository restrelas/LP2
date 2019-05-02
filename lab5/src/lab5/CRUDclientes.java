package lab5;

import java.util.HashMap;

public class CRUDclientes {
	private HashMap<String, Cliente> clientes;
	
	
	public CRUDclientes() {
		clientes = new HashMap<String, Cliente>();
	}
	
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		if(cpf == null || nome == null || email == null || localizacao == null) throw new NullPointerException();
		if(cpf.equals("") || nome.equals("") || email.equals("") || localizacao.equals("")) throw new IllegalArgumentException();
		Cliente temp = new Cliente(cpf, nome, email, localizacao);
		clientes.put(cpf, temp);
		return cpf;	
	}
	public String getCliente(String cpf) {
		return clientes.get(cpf).toString();
	}
	public String printClientes() {
		String ans = new String();
		for(Cliente i : clientes.values()) {
			ans += i.toString() + " | ";
		}
		return ans.substring(0, ans.length() - 3);
	}
	
	public void removerCliente(String cpf) {
		clientes.remove(cpf);
	}
	
	public void editarCadastroCliente(String cpf, String nome, String email, String localizacao) {
		Cliente temp = clientes.get(cpf);
		temp.setNome(nome);
		temp.setEmail(email);
		temp.setLocalizacao(localizacao);
		
	}
}
