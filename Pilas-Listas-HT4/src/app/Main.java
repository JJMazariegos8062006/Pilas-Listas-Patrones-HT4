package app;

import stack.Stack;
import stack.StackFactory;
import Util.ExpressionConverter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Tipo de Stack");
        System.out.println("1.) lista");
        System.out.println("2.) vector");
        System.out.println("3.) arraylist");
        int stackType = scanner.nextInt();

        switch (stackType) {
            case 1: System.out.println("tipo de lista");
                    System.out.println("1.) simple");
                    System.out.println("2.) encadenada");
                    System.out.println("2.) doblemente encadenada");
                    int listType = scanner.nextInt();

                    switch (listType) {

                        case 1:

                        case 2:

                        case 3:

                        default:
                    }

            case 2: System.out.println("tipo de arraylist a escoger");

            case 3: System.out.println("tipo de stack a escoger");


            default:
        }
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