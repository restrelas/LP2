package tests;
import lab4.Aluno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoTest {

	Aluno aluno1;
	/**
	 * Inicializa Aluno para as possiveis entradas e checa as devidas excessões
	 */
	@Test
	void testAluno() {
		try{
			aluno1 = new Aluno(null, null, null);
			fail("não lancou exceção");
		} catch(NullPointerException e) {}
		try{
			aluno1 = new Aluno("", "", "");
			fail("não lancou exceção");
		} catch(IllegalArgumentException e) {}
		try {
			aluno1 = new Aluno("1231", "1sadd", "sadf");
		} catch(Exception e) {
			fail("yo");
		}
	}

	/**
	 * Inicializa um novo Aluno
	 */
	@BeforeEach
	void setup() {
		aluno1 = new Aluno("casa", "123", "ciencia");
	}

	/**
	 * Verifica se o retorno do metodo toString ocorre de maneira esperada
	 */
	@Test
	void testToString() {
		assertEquals(aluno1.toString(), "123 - casa - ciencia");
	}

	/**
	 * Verifica se o retorno do metodo getNome ocorre de maneira esperada
	 */
	@Test
	void testGetNome() {
		assertEquals(aluno1.getNome(), "casa");
	}

	/**
	 * Verifica se o retorno do metodo getMatricula ocorre de maneira esperada
	 */
	@Test
	void testGetMatricula() {
		assertEquals(aluno1.getMatricula(), "123");
	}

	/**
	 * Verifica se o retorno do metodo getCurso ocorre de maneira esperada
	 */
	@Test
	void testGetCurso() {
		assertEquals(aluno1.getCurso(), "ciencia");
	}

}
