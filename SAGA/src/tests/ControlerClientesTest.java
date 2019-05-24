package tests;

import static org.junit.jupiter.api.Assertions.*;

import lab5b.Cliente;
import lab5b.ControlerClientes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControlerClientesTest {

	ControlerClientes c1;

	@Test
	void testControlerClientes() {
		assertDoesNotThrow(() -> new ControlerClientes());
	}

	@BeforeEach
	void setup(){
		c1 = new ControlerClientes();
	}

	@Test
	void testCadastrarCliente() {
		assertThrows(Error.class, () -> c1.adicionaCliente("1234567891", "asldj", "alsdasd", "alsdkjal"));
		assertDoesNotThrow(() -> new Cliente("12345678910", "sadjkfhaksl", "dhasfhask", "asasdpewrqo"));
		assertThrows(IllegalArgumentException.class, () -> c1.adicionaCliente("12345678910", "", "dsaf", "asdf"));
		assertThrows(IllegalArgumentException.class, () -> c1.adicionaCliente("12345678910", "asdfhl", "", "dasfads"));
		assertThrows(IllegalArgumentException.class, () -> c1.adicionaCliente("12345678910", "asdfhl", "asdfasfas", ""));

	}

	@Test
	void testExibeCliente() {
		c1.adicionaCliente("12345678901", "l", "l", "o");
		assertEquals("l - o - l", c1.exibeCliente("12345678901"));
		assertThrows(Error.class, () -> c1.exibeCliente("12345678910"));
	}

	@Test
	void testEditaCliente() {
		c1.adicionaCliente("12345678901", "l", "l", "o");
		c1.editaCliente("12345678901", "nome", "d");
		assertEquals("d - o - l", c1.exibeCliente("12345678901"));
		assertThrows(IllegalArgumentException.class, () -> c1.editaCliente("12345678901", "cpf", "d"));
		assertThrows(IllegalArgumentException.class, () -> c1.editaCliente("12345678901", "", "d"));
		assertThrows(IllegalArgumentException.class, () -> c1.editaCliente("12345678901", "localizacao", ""));
		assertThrows(IllegalArgumentException.class, () -> c1.editaCliente("12345678901", "email", ""));
		assertThrows(IllegalArgumentException.class, () -> c1.editaCliente("12345678901", "nome", ""));
		assertThrows(Error.class, () -> c1.editaCliente("12345678901", "asdfas", "asdfa"));
		assertThrows(Error.class, () -> c1.editaCliente("1234678901", "email", "sadfa"));

	}

	@Test
	void testRemoveCliente(){
		c1.adicionaCliente("12345678901", "l", "l", "o");
		assertDoesNotThrow(() ->c1.removeCliente("12345678901"));
		assertThrows(Error.class, () ->c1.removeCliente("12345678901"));
		assertThrows(Error.class, () ->c1.removeCliente("901"));
	}

}
