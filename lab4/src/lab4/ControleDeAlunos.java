package lab4;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * O controle de alunos gerencia um HashMap de Aluno e outro de Grupo e um ArrayList de String
 * permitindo alocações, verificações e comparações desses containers
 */
public class ControleDeAlunos {
	/**
	 * Atributos privados de cada ControleDeAlunos, ao qual contem HashMap<String, Aluno>, HashMap<String, Aluno> e ArrayList<String>
	 */
	private HashMap< String, Aluno> alunos;
	private HashMap<String, Grupo> grupos;
	private ArrayList<String> respondeu;

	/**
	 * Construtor principal e padrão que recebe um parametro vazio e atribui estruturas vazias aos atributos da classe
	 */
	public ControleDeAlunos(){
		alunos = new HashMap<String, Aluno>();
		grupos = new HashMap<String, Grupo>();
		respondeu = new ArrayList<String>();
	}

	/**
	 * Busca no HashMap de alunos pela chave matricula
	 * @param matricula
	 * @return true se alunos contem matricula, false caso não
	 */
	public boolean checaAlunoCadastrado(String matricula) {
		return alunos.containsKey(matricula);
	}

	/**
	 * Busca no HashMap de alunos pela chave nomeGrupo
	 * @param nomeGrupo
	 * @return true se alunos contem matricula, false caso não
	 */
	public boolean checaGrupoCadastrado(String nomeGrupo) {
		return grupos.containsKey(nomeGrupo);
	}

	/**
	 * Cria uma nova variável do tipo Aluno e aloca em alunos
	 * @param nome
	 * @param matricula
	 * @param curso
	 */
	public void cadastraAluno(String nome, String matricula, String curso) {
		Aluno temp = new Aluno(nome, matricula, curso);
		alunos.put(matricula, temp);
	}

	/**
	 * Cria uma nova variável do tipo Grupo e aloca em grupos
	 * @param nomeGrupo
	 */
	public void cadastraGrupo(String nomeGrupo) {
		Grupo grupo = new Grupo(nomeGrupo);
		grupos.put(nomeGrupo, grupo);
	}

	/**
	 * @param matricula do aluno que deve ser exibido
	 * @return Dados do aluno caso ele ja esteja cadastrado, caso ele não esteja cadastrado retorna "Aluno não cadastrado."
	 */
	public String exibirAluno(String matricula) {
		if(checaAlunoCadastrado(matricula)) return "Aluno: " + alunos.get(matricula).toString();
		else return "Aluno não cadastrado.";
	}

	/**
	 *
	 * @param matricula do aluno que deve ser alocado
	 * @param grupo que deve receber o aluno
	 * @return "Aluno cadastrado.", "Aluno não cadastrado" caso o aluno não tenha sido cadastrado anteriormente,
	 * "Grupo não cadastrado." caso o grupo não tenha sido cadastrado anteriormente
	 */
	public String alocaAluno(String matricula, String grupo) {
		if(!alunos.containsKey(matricula)) return "Aluno não cadastrado.";
		if(!grupos.containsKey(grupo)) return "Grupo não cadastrado.";
		grupos.get(grupo).cadastraAluno(alunos.get(matricula));
		return "Aluno cadastrado.";
	}

	/**
	 * @param grupo que deve ser imprimido
	 * @return uma lista de alunos contidos no grupo. caso o gruppo não tenha sido cadastrado ele "Grup não cadastrado."
	 */
	public String imprimirGrupo(String grupo) {
		if(!grupos.containsKey(grupo)) return "Grupo não cadastrado.";
		return grupos.get(grupo).toString();
	}

	/**
	 * salva a matricula do aluno que responseu a questão
	 * @param matricula do aluno
	 * @return "ALUNO REGISTRADO!" caso o aluno esteja cadastrado. "Aluno não cadastrado" caso aluno não esteja cadastrado
	 */
	public String respondeQuestao(String matricula) {
		if(!alunos.containsKey(matricula)) return "Aluno não cadastrado";
		respondeu.add(matricula);
		return "ALUNO REGISTRADO!";
	}

	/**
	 * lista todos os alunos que responderam questões
	 * @return String contendo os dados dos alunos que responseram
	 */
	public String imprimirRespondeu() {
		int cont = 0;
		String temp = "Alunos:";
		for(String matricula : respondeu) {
			temp += "\n" + ++cont + ". " + alunos.get(matricula).toString();
		}
		return temp;
	}
}
