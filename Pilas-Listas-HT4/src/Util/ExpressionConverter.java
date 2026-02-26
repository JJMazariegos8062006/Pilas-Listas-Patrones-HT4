package Util;

import stack.Stack;

public class ExpressionConverter {

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    public static String infixToPostfix(String expression, Stack<Character> stack) {

        StringBuilder output = new StringBuilder();
        StringBuilder numberBuffer = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {

            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                numberBuffer.append(c);
            } else {

                if (numberBuffer.length() > 0) {
                    output.append(numberBuffer);
                    numberBuffer.setLength(0);
                }

                if (c == '(') {
                    stack.push(c);
                }

                else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        output.append(stack.pop());
                    }
                    stack.pop();
                }

                else if (c == '+' || c == '-' || c == '*' || c == '/') {

                    while (!stack.isEmpty() &&
                            precedence(c) <= precedence(stack.peek())) {

                        output.append(stack.pop());
                    }

                    stack.push(c);
                }
            }
        }

        if (numberBuffer.length() > 0) {
            output.append(numberBuffer);
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        return output.toString();
    }
}
