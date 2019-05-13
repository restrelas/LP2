package lab5b;

public class Cliente {
	private String cpf;
	private String nome;
	private String local;
	private String email;
	
	public Cliente(String cpf, String nome, String email, String local) {
		if(nome == null || nome.equals("")) throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		if(local == null || local.equals("")) throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		if(email == null || email.equals("")) throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		this.cpf = cpf;
		this.nome = nome;
		this.local = local;
		this.email = email;
	}
	
	public String toString() {
		return nome + " - " + local + " - " + email;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
