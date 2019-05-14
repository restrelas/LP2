package tests;

import static org.junit.jupiter.api.Assertions.*;

import lab5b.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {

	Cliente c1;
	Cliente c2;
	
	@BeforeEach
	void setup(){
	}
	@Test
	void testCliente() {
		assertDoesNotThrow(() -> new Cliente("123411234", "sadjkfhaksl", "dhasfhask", "asasdpewrqo"));
		assertThrows(IllegalArgumentException.class, () -> new Cliente("saf", "", "dsaf", "asdf"));
		assertThrows(IllegalArgumentException.class, () -> new Cliente("asldhfa", "asdfhl", "", "dasfads"));
		assertThrows(IllegalArgumentException.class, () -> new Cliente("asldhfa", "asdfhl", "asdfasfas", ""));
	}

	@Test
	void testToString() {
		c1 = new Cliente("12341231", "caju", "azedo", "ali");
		assertEquals("caju - ali - azedo", c1.toString());
	}

	@Test
	void testSetNome() {
		c1 = new Cliente("12341231", "caju", "azedo", "ali");
		c1.setNome("casa");
		assertEquals("casa - ali - azedo", c1.toString());
	}

	@Test
	void testSetLocal() {
		c1 = new Cliente("12341231", "caju", "azedo", "ali");
		c1.setLocal("casa");
		assertEquals("caju - casa - azedo", c1.toString());
	}

	@Test
	void testSetEmail() {
		c1 = new Cliente("12341231", "caju", "azedo", "ali");
		c1.setEmail("casa");
		assertEquals("caju - ali - casa", c1.toString());
	}

}
