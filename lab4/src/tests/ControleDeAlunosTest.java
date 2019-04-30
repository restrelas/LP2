package tests;
import lab4.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControleDeAlunosTest {

	ControleDeAlunos gerenciador;
	
	@Test
	void testControleDeAlunos() {
		gerenciador = new ControleDeAlunos();
	}

	@BeforeEach
	void setup() {
		gerenciador = new ControleDeAlunos();
	}
	
	@Test
	void testCadastraAluno() {
		gerenciador.cadastraAluno("1234", "wenderglydson", "moda");
		try {
			gerenciador.cadastraAluno("", "sadf", "asdfc");
			fail("aos");
		}catch(IllegalArgumentException e){}
	}
	
	@Test
	void testChecaAlunoCadastrado() {
		gerenciador.cadastraAluno("wenderglydson", "1234", "moda");
		assertEquals(gerenciador.checaAlunoCadastrado("1234"), true);
		assertEquals(gerenciador.checaAlunoCadastrado("23414"), false);
	}
	
	@Test
	void testCadastraGrupo() {
		gerenciador.cadastraGrupo("sla");
		try {
			gerenciador.cadastraGrupo("aloalo");
		}catch(IllegalArgumentException e){
			fail("aos");			
		}
		try {
			gerenciador.cadastraGrupo("");
			fail("aos");
		}catch(IllegalArgumentException e){}
	}


	@Test
	void testChecaGrupoCadastrado() {
		gerenciador.cadastraGrupo("sla");
		assertEquals(gerenciador.checaGrupoCadastrado("sla"), true);
		assertEquals(gerenciador.checaGrupoCadastrado("23414"), false);
	}


	@Test
	void testExibirAluno() {
		gerenciador.cadastraAluno("wenderglydson", "1234", "moda");
		assertEquals(gerenciador.exibirAluno("1234"), "Aluno: 1234 - wenderglydson - moda");
		assertEquals(gerenciador.exibirAluno("213"), "Aluno não cadastrado.");
	}

	@Test
	void testAlocaAluno() {
		gerenciador.cadastraAluno("nome", "maricula", "curso");
		gerenciador.cadastraAluno("wenderglydson", "1234", "moda");
		gerenciador.cadastraGrupo("sla");
		gerenciador.cadastraGrupo("aloalo");
		assertEquals(gerenciador.alocaAluno("1234", "sla"), "Aluno cadastrado.");
		assertEquals(gerenciador.alocaAluno("2341", "sla"), "Aluno não cadastrado.");
		assertEquals(gerenciador.alocaAluno("maricula", "askj"), "Grupo não cadastrado.");
	}

	@Test
	void testImprimirGrupo() {
		gerenciador.cadastraAluno("nome", "maricula", "curso");
		gerenciador.cadastraAluno("wenderglydson", "1234", "moda");
		gerenciador.cadastraGrupo("sla");
		gerenciador.cadastraGrupo("aloalo");
		gerenciador.alocaAluno("1234", "sla");
		assertEquals(gerenciador.imprimirGrupo("sla"), "Alunos do grupo sla:\n* 1234 - wenderglydson - moda\n");
		assertEquals(gerenciador.imprimirGrupo("aloalo"), "Alunos do grupo aloalo:\n");
	}

	@Test
	void testRespondeQuestao() {
		gerenciador.cadastraAluno("nome", "maricula", "curso");
		gerenciador.cadastraAluno("wenderglydson", "1234", "moda");
		assertEquals(gerenciador.respondeQuestao("maricula"), "ALUNO REGISTRADO!");
		assertEquals(gerenciador.respondeQuestao("1234"), "ALUNO REGISTRADO!");
		assertEquals(gerenciador.respondeQuestao("561235"), "Aluno não cadastrado");
	}

	@Test
	void testImprimirRespondeu() {
		gerenciador.cadastraAluno("nome", "maricula", "curso");
		gerenciador.cadastraAluno("wenderglydson", "1234", "moda");
		gerenciador.respondeQuestao("1234");
		gerenciador.respondeQuestao("maricula");
		assertEquals(gerenciador.imprimirRespondeu(), "Alunos:\n1. 1234 - wenderglydson - moda\n2. maricula - nome - curso");
	}

}
