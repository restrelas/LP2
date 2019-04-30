package lab4;

public class Aluno {
	private String nome;
	private String matricula;
	private String curso;
	
	public Aluno(String nome, String matricula, String curso) {
		if(nome == null || matricula == null || curso == null) throw new NullPointerException();
		if(nome.trim().equals("") || matricula.trim().equals("") || curso.trim().equals("")) throw new IllegalArgumentException();
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}
	
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
