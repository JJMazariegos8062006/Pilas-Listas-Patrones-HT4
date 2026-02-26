package List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListFactoryTest {

    @Test
    void creaListaSimple() {
        List<Integer> list = ListFactory.createList(String.valueOf(1));
        assertTrue(list instanceof ListSinglyLinked);
    }

    @Test
    void creaListaDoblementeEncadenada() {
        List<Integer> list = ListFactory.createList(String.valueOf(2));
        assertTrue(list instanceof ListDoublyLinked);
    }

    @Test
    void tipoInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
                ListFactory.createList(String.valueOf(99)));
    }
}

