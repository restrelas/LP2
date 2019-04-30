package lab4;

import java.util.HashSet;

/**
 * Armazena o nome
 * e os alunos de Grupo
 */
public class Grupo {

	/**
	 * Atributos String nome, e um HashSet contendo um conjunto de Aluno
	 */
	private String nomeGrupo;
	private HashSet <Aluno> alunos;

	/**
	 * Inicializa um novo Grupo com nome e um conjunto vazio de alunos
	 * @param nomeGrupo - o nome do grupo a ser criado
	 */
	public Grupo(String nomeGrupo) {
		if(nomeGrupo == null) throw new NullPointerException();
		if(nomeGrupo.trim().equals("")) throw new IllegalArgumentException();
		this.nomeGrupo = nomeGrupo;
		this.alunos = new HashSet <Aluno>();
	}

	/**
	 * Armazena o aluno passado como parametro
	 * @param aluno - o aluno a ser cadastrado
	 */
	public void cadastraAluno(Aluno aluno) {
		alunos.add(aluno);
	}

	/**
	 * @return lista com o nome do grupo e os dados dos alunos contidos nesse Grupo
	 */
	@Override
	public String toString() {
		String temp = "Alunos do grupo " + nomeGrupo + ":\n";
		for(Aluno aluno : alunos) {
			temp += "* "+ aluno.toString() + "\n";
		}
		return temp;
	}
}
