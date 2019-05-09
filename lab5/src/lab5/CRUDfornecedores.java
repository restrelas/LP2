package lab5;

import java.util.HashMap;

public class CRUDfornecedores {
	
	private HashMap<String, Fornecedor> fornecedores;
	
	
	public CRUDfornecedores(String nome, String email, String telefone) {
		if(nome == null || nome == null || email == null || telefone == null) throw new NullPointerException();
		if(nome.equals("") || nome.equals("") || email.equals("") || telefone.equals("")) throw new IllegalArgumentException();
		fornecedores.put(nome, new Fornecedor(nome, email, telefone));
	}
	
	public String printFornecedores() {
		String ans = new String();
		for(Fornecedor i : fornecedores.values()) {
			ans += i.toString() + " | ";
		}
		return ans.substring(0, ans.length() - 3);
	}
	public void editarCadastroCliente(String nome, String email, String telefone) {
		Fornecedor temp = fornecedores.get(nome);
		temp.setNome(nome);
		temp.setEmail(email);
		temp.setTelefone(telefone);
	}
	
	public void removerCliente(String nome) {
		fornecedores.remove(nome);
	}
	//CHECA AQUI TBM DESGRAÇA
	String cadastraProdutoFornecedor(String nomeFornecedor, String nome, String descricao, double preco) {
		if(!fornecedores.containsKey(nomeFornecedor)) return "Fornecedor não cadastrado";
		return fornecedores.get(nomeFornecedor).cadastraProduto(nome, descricao, preco) ? "PRODUTO CADASTRADO COM SUCESSO!" : "Produto já cadastrado";
		 
	}
}
