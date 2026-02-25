package stack;

import List.List;
import List.ListFactory;

public class StackFactory {

    public static <T> Stack<T> createStack(String type, String listType) {

        switch (type.toLowerCase()) {

            case "arraylist":
                return new ArrayListStack<>();

            case "vector":
                return new StackVector<>();

            case "lista":
                List<T> list = ListFactory.<T>createList(listType);
                return new ListStack<T>(list);

            default:
                throw new IllegalArgumentException("Tipo de stack inválido");
        }
    }
}