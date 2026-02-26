package Util;

import org.junit.jupiter.api.Test;
import stack.Stack;
import stack.StackFactory;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionConverterTest {

    @Test
    void convierteExpresionSimple() {

        Stack<Character> stack = StackFactory.createStack(3,0);

        String result =
                ExpressionConverter.infixToPostfix("2+3", stack);

        assertEquals("23+", result);
    }

    @Test
    void respetaPrecedencia() {

        Stack<Character> stack = StackFactory.createStack(3,0);

        String result =
                ExpressionConverter.infixToPostfix("2+3*4", stack);

        assertEquals("234*+", result);
    }

    @Test
    void manejaParentesis() {

        Stack<Character> stack = StackFactory.createStack(3,0);

        String result =
                ExpressionConverter.infixToPostfix("(2+3)*4", stack);

        assertEquals("23+4*", result);
    }
}