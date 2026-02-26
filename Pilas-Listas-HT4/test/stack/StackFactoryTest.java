package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackFactoryTest {

    @Test
     void creaStackArrayList() {
        Stack<Integer> stack = StackFactory.createStack(3, 0);
        assertTrue(stack instanceof ArrayListStack);
    }

    @Test
    void creaStackVector() {
        Stack<Integer> stack = StackFactory.createStack(2, 0);
        assertTrue(stack instanceof StackVector);
    }

    @Test
    void creaStackLista() {
        Stack<Integer> stack = StackFactory.createStack(1, 1);
        assertTrue(stack instanceof ListStack);
    }

    @Test
    void tipoInvalidoLanzaError() {
        assertThrows(IllegalArgumentException.class, () ->
                StackFactory.createStack(99, 0));
    }
}