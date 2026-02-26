package app;

import org.junit.jupiter.api.Test;
import stack.Stack;
import stack.StackFactory;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    @Test
    void evaluaPostfix() {

        Calculadora calc = Calculadora.getInstance();
        Stack<Integer> stack = StackFactory.createStack(3,0);

        int result = calc.evaluarPostfix("23+", stack);

        assertEquals(5, result);
    }

    @Test
    void evaluaExpresionCompleja() {

        Calculadora calc = Calculadora.getInstance();
        Stack<Integer> stack = StackFactory.createStack(3,0);

        int result = calc.evaluarPostfix("234*+", stack);

        assertEquals(14, result);
    }
}
