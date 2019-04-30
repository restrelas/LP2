package lab4;

import java.util.Scanner;

public class Main {

	static ControleDeAlunos gerenciador = new ControleDeAlunos();
	static Scanner sc = new Scanner(System.in);

	private static String menu() {
		String menu = "(C)adastrar Aluno\n(E)xibir Aluno\n(N)ovo Grupo" + 
		"\n(A)locar Aluno no Grupo e Imprimir Grupos" +
		"\n(R)egistrar Aluno que Respondeu" +
		"\n(I)mprimir Alunos que Responderam" +
		"\n(O)ra, vamos fechar o programa!\n\nOpção>";
		return menu;
	}


	public static void main(String[] args) {
			
			while(true) {
				System.out.print(menu());
				String opcao = sc.nextLine();
				String matricula, nome, curso, grupo;
				switch(opcao) {
				case "C":
					System.out.println("Matrícula: ");
					matricula = sc.nextLine();
					System.out.println("Nome: ");
					nome = sc.nextLine();
					System.out.println("Curso: ");
					curso = sc.nextLine();
					if(gerenciador.checaAlunoCadastrado(matricula)) System.out.println("MATRÍCULA JÁ CADASTRADA!");
					else{
						gerenciador.cadastraAluno(nome, matricula, curso);
						System.out.println("CADASTRO REALIZADO!");
					}
					break;
				case "E":
					System.out.println("Matrícula: \n");
					matricula = sc.nextLine();
					System.out.println(gerenciador.exibirAluno(matricula));
					break;
				
				case "N":
					System.out.println("Grupo: ");
					String nomeGrupo = sc.nextLine();
					if(gerenciador.checaGrupoCadastrado(nomeGrupo)) System.out.println("GRUPO JÁ CADASTRADO!");
					else {
						gerenciador.cadastraGrupo(nomeGrupo);
						System.out.println("CADASTRO REALIZADO!");
					}
					break;
				case "A":
					System.out.println("(A)locar Aluno ou (I)mprimir Grupo?");
					String escolha = sc.nextLine();
					switch(escolha) {
					case "A":
						System.out.println("Matricula: ");
						matricula = sc.nextLine();
						System.out.println("Grupo: ");
						grupo = sc.nextLine();
						gerenciador.alocaAluno(matricula, grupo);
						System.out.println("Aluno Alocado!");
						break;
					case "I":
						System.out.println("Grupo: ");
						grupo = sc.nextLine();
						System.out.println();
						System.out.println(gerenciador.imprimirGrupo(grupo));
						break;
					default:
						throw new IllegalArgumentException();
					}
					break;
				case "R":
					System.out.println("Matricula: ");
					matricula = sc.nextLine();
					System.out.println(gerenciador.respondeQuestao(matricula));
					break;
				case "I":
					System.out.println(gerenciador.imprimirRespondeu());
					break;
				case "O":
					return;
				default:
					throw new IllegalArgumentException();					
				}
				System.out.println();
				
			}
		}
}
