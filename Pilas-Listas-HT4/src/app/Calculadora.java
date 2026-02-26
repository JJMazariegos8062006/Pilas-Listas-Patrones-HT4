package app;

import stack.Stack;

public class Calculadora {

    private static Calculadora instance;

    private Calculadora() {}

    public static Calculadora getInstance() {
        if (instance == null) {
            instance = new Calculadora();
        }
        return instance;
    }

    public int evaluarPostfix(String expression, Stack<Integer> stack) {

        for (char token : expression.toCharArray()) {

            if (Character.isDigit(token)) {
                stack.push(Character.getNumericValue(token));
            } else {

                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }

        return stack.pop();
    }
}

