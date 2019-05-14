package tests;

import static org.junit.jupiter.api.Assertions.*;

import lab5b.Fornecedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FornecedorTest {

	Fornecedor c1;

	@Test
	void testFornecedor() {
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("", "asd", "asdfa"));
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("asdfasdf", "", "asdfa"));
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("asdfasfda", "asd", ""));
		assertDoesNotThrow(() -> new Fornecedor("alksjd", "ajsdlkfj", "klasjd"));
	}

	@BeforeEach
	void setup(){
		c1 = new Fornecedor("joao", "gmail.com", "234");
	}
	@Test
	void testToString() {
		assertEquals("joao - gmail.com - 234", c1.toString());
	}

	@Test
	void testSetEmail() {
		c1.setEmail("casa");
		assertEquals("joao - casa - 234", c1.toString());
	}

	@Test
	void testSetTelefone() {
		c1.setTelefone("casa");
		assertEquals("joao - gmail.com - casa", c1.toString());
	}

	@Test
	void testAdicionaProduto() {
		assertThrows(IllegalArgumentException.class, () -> c1.adicionaProduto("", "asd", 1234.1));
		assertThrows(IllegalArgumentException.class, () -> c1.adicionaProduto("asdfasdf", "", 0));
		assertThrows(ArithmeticException.class, () -> c1.adicionaProduto("asdfasdf", "asdf", -23));
		assertDoesNotThrow(() -> c1.adicionaProduto("do", "e", 0));
		assertThrows(Error.class, () -> c1.adicionaProduto("do", "e", 0));

	}

	@Test
	void testExibeProduto() {
		assertThrows(IllegalArgumentException.class, () -> c1.exibeProduto("", "asdj"));
		assertThrows(IllegalArgumentException.class, () -> c1.exibeProduto("asdaa", ""));
		assertThrows(Error.class, () -> c1.exibeProduto("asdaa", "asdf"));
		c1.adicionaProduto("do", "e", 0);
		assertDoesNotThrow(() -> c1.exibeProduto("do", "e"));
		assertEquals("do - e - R$0,00", c1.exibeProduto("do", "e"));
	}

	@Test
	void testEditaProduto() {
		assertThrows(IllegalArgumentException.class, () -> c1.editaProduto("", "asdj", 91));
		assertThrows(IllegalArgumentException.class, () -> c1.editaProduto("asdaa", "", 91));
		assertThrows(ArithmeticException.class, () -> c1.editaProduto("asdaa", "asdf", -1));
		assertThrows(Error.class, () -> c1.editaProduto("casa", "aarela", 50));
		c1.adicionaProduto("do", "e", 0);
		assertDoesNotThrow(() -> c1.editaProduto("do", "e", 21));
		assertEquals("do - e - R$21,00", c1.exibeProduto("do", "e"));
	}

	@Test
	void testRemoveProduto() {
		assertThrows(IllegalArgumentException.class, () -> c1.removeProduto("", "asdj"));
		assertThrows(IllegalArgumentException.class, () -> c1.removeProduto("asdaa", ""));
		assertThrows(Error.class, () -> c1.removeProduto("casa", "aarela"));
		assertThrows(Error.class, () -> c1.removeProduto("do", "e"));
		c1.adicionaProduto("do", "e", 0);
		assertDoesNotThrow(() -> c1.removeProduto("do", "e"));
		assertThrows(Error.class, () -> c1.removeProduto("do", "e"));
	}

}
