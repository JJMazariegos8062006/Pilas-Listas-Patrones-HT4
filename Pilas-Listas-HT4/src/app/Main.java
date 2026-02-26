package app;

import stack.Stack;
import stack.StackFactory;
import Util.ExpressionConverter;

import java.util.Scanner;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Tipo de Stack");
        System.out.println("1.) Lista");
        System.out.println("2.) Vector");
        System.out.println("3.) ArrayList");

        String stackType = String.valueOf(scanner.nextInt());
        int listType = 0;

        switch (stackType) {

            case "1":
                System.out.println("Tipo de lista:");
                System.out.println("1.) Simple");
                System.out.println("2.) Encadenada");
                System.out.println("3.) Doblemente encadenada");

                listType = scanner.nextInt();
                break;

            case "2":
                System.out.println("Usando Stack con Vector");
                break;

            case "3":
                System.out.println("Usando Stack con ArrayList");
                break;

            default:
                System.out.println("Opción inválida");
                return;
        }

        InputStream is = Main.class.getResourceAsStream("/datos.txt");

        if (is == null) {
            System.out.println("No se encontró datos.txt dentro de src");
            return;
        }

        String expression = new String(is.readAllBytes()).trim();

        Stack<Character> stackChar =
                StackFactory.createStack(Integer.parseInt(stackType), listType);

        String postfix =
                ExpressionConverter.infixToPostfix(expression, stackChar);

        System.out.println("Postfix: " + postfix);

        Stack<Integer> stackInt =
                StackFactory.createStack(Integer.parseInt(stackType), listType);

        Calculadora calc = Calculadora.getInstance();

        int result = calc.evaluarPostfix(postfix, stackInt);

        System.out.println("Resultado: " + result);
    }
}