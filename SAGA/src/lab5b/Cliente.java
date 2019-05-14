package lab5b;

/**
 * Classe que representa Cliete
 */
public class Cliente implements Comparable{
	/**
	 * Atributos privados, 4 Strings representando, cpf, nome, local e email do Cliente
	 */
	private String cpf;
	private String nome;
	private String local;
	private String email;

	/**
	 * Inicializa uma nova variavel do tipo Cliente
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param local
	 */
	public Cliente(String cpf, String nome, String email, String local) {
		if(nome == null || nome.equals("")) throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		if(local == null || local.equals("")) throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		if(email == null || email.equals("")) throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		this.cpf = cpf;
		this.nome = nome;
		this.local = local;
		this.email = email;
	}


	/**
	 * @return Representação textual do Cliente, nome, local e email separados por " - "
	 */
	public String toString() {
		return nome + " - " + local + " - " + email;
	}

	/**
	 * Altera o nome do Cliente
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Altera a localização do Cliente
	 * @param local
	 */
	public void setLocal(String local) {
		this.local = local;
	}

	/**
	 * Altera o email do Cliente
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome(){ return this.nome;}

	@Override
	public int compareTo(Object o) {
		return nome.compareTo(((Cliente)o).getNome());
	}
}
