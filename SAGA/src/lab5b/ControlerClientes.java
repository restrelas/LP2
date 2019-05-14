package lab5b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Classe responsável por gerencia as operações de Clientes e Armazenalos
 */
public class ControlerClientes {

	/**
	 * Atrubuto privado que armazena um HashMap de Clientes, cada um representado pelo seu nome
	 */
	HashMap<String, Cliente> clientes;

	/**
	 * Inicializa um novo ControlerClientes, que começa com um HashSet vazio
	 */
	public ControlerClientes() {
		clientes = new HashMap<String, Cliente>();
	}
//	US1

	/**
	 * Cadastra um novo Cliente
	 * Obs:
 *      O Cliente não pode existir ainda
	 *  Nenhum dos parametros pode ser vazio ou nulo
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param local
	 * @return
	 */
	public String cadastrarCliente(String cpf, String nome, String email, String local) {
		if(cpf.length() != 11) throw new Error("Erro no cadastro do cliente: cpf invalido.");
		if(clientes.containsKey(cpf)) throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		clientes.put(cpf, new Cliente(cpf, nome, email, local));
		return cpf;
	}

	/**
	 * Exibe um cliente já cadastrado, apenas especificando o seu cpf
	 * @param cpf
	 * @return Representação textual do Cliente
	 */
	public String exibeCliente(String cpf) {
		if(clientes.containsKey(cpf)) return clientes.get(cpf).toString();
		throw new Error("Erro na exibicao do cliente: cliente nao existe.");
}

	/**
	 * Exibe todos os clientes ja registrados
	 * @return Representação textual de todos os clientes separados por " - "
	 */
	public String exibeClientes() {
		String temp = new String();
		List<Cliente> aux = new ArrayList<>();

		for(String c: this.clientes.keySet()){
			aux.add(this.clientes.get(c));
		}
		Collections.sort(aux);
		for(Cliente it : aux) {
			temp += it.toString() + " | ";
		}
		return temp.length() > 2 ? temp.substring(0, temp.length() - 3) : temp;
	}

	/**
	 * Edita um atributo especifico do cliente
	 * Obs:
	 *   O Cliente deve existir
	 *   Nenhum atributo pode ser vazio ou nulo
	 *   O atributo a ser alterado deve ser nome, email ou localizacao
	 * @param cpf
	 * @param atributo
	 * @param novoValor
	 */
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

	/**
	 * remove um Cliente já adicionado, atravéz do seu cpf
	 * @param cpf
	 */
	public void removeCliente(String cpf){
		if(clientes.containsKey(cpf)) clientes.remove(cpf);
		else throw new Error("cliente nao existe.");
	}
}
