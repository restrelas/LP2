package lab4;

/**
 * Aluno permite armazenar trẽs strings
 */
public class Aluno {

	/**
	 * Atributos da classe, String nome, String matricula, String curso
	 */
	private String nome;
	private String matricula;
	private String curso;

	/**
	 * Inicializa um novo Aluno atribuindo nome, matricula e curso, e lança um excessão caso algum desses parametros seja invalido
	 * @param nome
	 * @param matricula
	 * @param curso
	 */
	public Aluno(String nome, String matricula, String curso) {
		if(nome == null || matricula == null || curso == null) throw new NullPointerException();
		if(nome.trim().equals("") || matricula.trim().equals("") || curso.trim().equals("")) throw new IllegalArgumentException();
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}

	/**
	 * @return matricula, nome e curso separados por " - "
	 */
	@Override
	public String toString() {
		String temp = matricula +
				" - " + nome + " - " + curso; 
		return temp;
	}
	public String getNome() {
		return this.nome;
	}
	public String getMatricula() {
		return this.matricula;
	}
	public String getCurso() {
		return this.curso;
	}
	
}
