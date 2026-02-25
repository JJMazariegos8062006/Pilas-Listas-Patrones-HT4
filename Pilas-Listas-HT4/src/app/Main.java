package app;

import stack.Stack;
import stack.StackFactory;
import Util.ExpressionConverter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Tipo de Stack (arraylist, vector, lista): ");
        String stackType = scanner.nextLine();

        String listType = "";

        if (stackType.equalsIgnoreCase("lista")) {
            System.out.println("Tipo de Lista (simple, doble): ");
            listType = scanner.nextLine();
        }

        String expression = Files.readString(Paths.get("datos.txt")).trim();

        Stack<Character> stackChar =
                StackFactory.createStack(stackType, listType);

        String postfix =
                ExpressionConverter.infixToPostfix(expression, stackChar);

        System.out.println("Postfix: " + postfix);

        Stack<Integer> stackInt =
                StackFactory.createStack(stackType, listType);

        Calculadora calc = Calculadora.getInstance();

        int result = calc.evaluarPostfix(postfix, stackInt);

        System.out.println("Resultado: " + result);
    }
}