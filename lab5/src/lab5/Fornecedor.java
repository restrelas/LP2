package lab5;

import java.util.TreeSet;

public class Fornecedor {
	
	private String nome;
	private String email;
	private String telefone;
	private TreeSet <Produto> produtos;
	
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashSet<Produto>();
	}
	
	@Override
	public String toString() {
		return nome + " - " + email + " - " + telefone;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
//	DEVO FAZER: checar se o retorno é falso para prdutos com nome e descricao iguais, porém preco diferentes; 
	public boolean cadastraProduto(String nome, String descricao, double preco) {
		Produto temp = new Produto(nome, descricao, preco);
		
		return produtos.add(temp);
	}
}
