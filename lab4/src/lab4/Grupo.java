package lab4;

import java.util.HashSet;

public class Grupo {

	private String nomeGrupo;
	private HashSet <Aluno> alunos;

	public Grupo(String nomeGrupo) {
		if(nomeGrupo == null) throw new NullPointerException();
		if(nomeGrupo.trim().equals("")) throw new IllegalArgumentException();
		this.nomeGrupo = nomeGrupo;
		this.alunos = new HashSet <Aluno>();
	}
	
	public void cadastraAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	@Override
	public String toString() {
		String temp = "Alunos do grupo " + nomeGrupo + ":\n";
		for(Aluno aluno : alunos) {
			temp += "* "+ aluno.toString() + "\n";
		}
		return temp;
	}
}
