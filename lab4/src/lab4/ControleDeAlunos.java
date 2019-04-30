package lab4;

import java.util.HashMap;
import java.util.ArrayList;

public class ControleDeAlunos {
	private HashMap< String, Aluno> alunos;	
	private HashMap<String, Grupo> grupos;
	private ArrayList<String> respondeu;
	
	public ControleDeAlunos(){
		alunos = new HashMap<String, Aluno>();
		grupos = new HashMap<String, Grupo>();
		respondeu = new ArrayList<String>();
	}
	
	
	
	public boolean checaAlunoCadastrado(String matricula) {
		return alunos.containsKey(matricula);
	}
	public boolean checaGrupoCadastrado(String nomeGrupo) {
		return grupos.containsKey(nomeGrupo);
	}
	
	public void cadastraAluno(String nome, String matricula, String curso) {
		Aluno temp = new Aluno(nome, matricula, curso);
		alunos.put(matricula, temp);
	}
	public void cadastraGrupo(String nomeGrupo) {
		Grupo grupo = new Grupo(nomeGrupo);
		grupos.put(nomeGrupo, grupo);
	}
	public String exibirAluno(String matricula) {
		if(checaAlunoCadastrado(matricula)) return "Aluno: " + alunos.get(matricula).toString();
		else return "Aluno não cadastrado.";
	}
	public String alocaAluno(String matricula, String grupo) {
		if(!alunos.containsKey(matricula)) return "Aluno não cadastrado.";
		if(!grupos.containsKey(grupo)) return "Grupo não cadastrado.";
		grupos.get(grupo).cadastraAluno(alunos.get(matricula));
		return "Aluno cadastrado.";
	}
	public String imprimirGrupo(String grupo) {
		if(!grupos.containsKey(grupo)) return "Grupo não cadastrado.";
		return grupos.get(grupo).toString();
	}
	public String respondeQuestao(String matricula) {
		if(!alunos.containsKey(matricula)) return "Aluno não cadastrado";
		respondeu.add(matricula);
		return "ALUNO REGISTRADO!";
	}
	public String imprimirRespondeu() {
		int cont = 0;
		String temp = "Alunos:";
		for(String matricula : respondeu) {
			temp += "\n" + ++cont + ". " + alunos.get(matricula).toString();
		}
		return temp;
	}
}
