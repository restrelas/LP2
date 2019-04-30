package tests;

import lab4.Grupo;
import lab4.Aluno;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrupoTest {

	Grupo grupo1, grupo2;
	Aluno aluno1;
	
	@Test
	/**
	 * Inicializa Grupo para as possiveis entradas e checa as devidas excessões
	 */
	void testGrupo() {
		try{
			grupo1 = new Grupo(null);
			fail("NOP");
		}catch(NullPointerException e){}
		try {
			grupo1 = new Grupo("");
			fail("a ads");
		}catch(IllegalArgumentException e) {}
		try {
			grupo1 = new Grupo("alsdjlaks");
		}catch(Exception e) {
			fail("sad");
		}
	}

	/**
	 * Cria um novo Grupo e Aluno
	 */
	@BeforeEach
	void setup() {
		grupo2 = new Grupo("colegas");
		aluno1 = new Aluno("casa", "123", "odontologia");
	}

	/**
	 * Cadastra aluno
	 */
	@Test
	void testCadastraAluno() {
		grupo2.cadastraAluno(aluno1);
	}

	/**
	 * verifica se o aluno foi cadastrado corretamente e o retorno do toString ocorre como esperado
	 */
	@Test
	void testToString() {
		assertEquals(grupo2.toString(),"Alunos do grupo colegas:\n");
	}

}
