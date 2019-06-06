package teste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prova.Controller;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    public Controller c;

    @BeforeEach
    public void setup(){
        c = new Controller();
    }
    @Test
    public void cadastrarAnimalTest(){
        c.cadastrarCachorroFilhote();
        c.cadastrarElefanteFilhote();
        c.cadastrarMorcegoFilhote();
    }
    @Test
    public void exibirAnimalTest(){
        c.cadastrarCachorroFilhote();
        c.cadastrarElefanteFilhote();
        c.cadastrarMorcegoFilhote();
        assertEquals("CAO 1 - 0.4 kg - 0 - P", c.exibirAnimal(1));
        assertEquals("FANTE 2 - 120.0 kg - 0 - G", c.exibirAnimal(2));
        assertEquals("BAT 3 - 0.002 kg - 0 - P", c.exibirAnimal(3));
    }
    @Test
    public void configurarRemocaoTest(){
        assertThrows(IllegalArgumentException.class, () -> c.configurarRemocao(""));
        assertThrows(IllegalArgumentException.class, () -> c.configurarRemocao(null));
        assertThrows(IllegalArgumentException.class, () -> c.configurarRemocao("abacaba"));
        assertDoesNotThrow(() -> c.configurarRemocao("PESO"));
        assertDoesNotThrow(() -> c.configurarRemocao("IDADE"));
    }
    @Test
    /**
     * checa o retorno sendo 0, caso nao haja animais cadastrados
     * checa o retorno sendo 1, quando a animais para serem removidos
     * e verifica se o animal é removido corretamente
     */
    public void removerTest(){
        assertThrows(RuntimeException.class, () -> c.remover());
        c.configurarRemocao("PESO");
        assertEquals(0, c.remover());
        c.cadastrarMorcegoFilhote();
        c.cadastrarElefanteFilhote();
        c.cadastrarCachorroFilhote();
        assertDoesNotThrow(()->c.exibirAnimal(2));
        assertEquals(2, c.remover());
        assertThrows(IllegalArgumentException.class, ()->c.exibirAnimal(2));
        c.configurarRemocao("IDADE");
        c.crescer(1);
        assertDoesNotThrow(()->c.exibirAnimal(1));
        assertEquals(1, c.remover());
        assertThrows(IllegalArgumentException.class, ()->c.exibirAnimal(2));
    }

}