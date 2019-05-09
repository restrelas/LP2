package lab5;

public class Produto {
	private double preco;
	private String nome;
	private String descricao;
	
	public Produto(String nome, String descricao, double preco){
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return nome + " - " + descricao + " - R$" + String.format("%.2f", preco);
	}
}
