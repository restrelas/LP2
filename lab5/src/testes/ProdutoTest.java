package testes;

import lab5.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProdutoTest {

	@Test
	void test() {
		Produto produto = new Produto("asdjflkaj", "adas", 1234.2341);
		double x = 1234.2341;
		System.out.println(String.format("%.2f", x));
	}

}
