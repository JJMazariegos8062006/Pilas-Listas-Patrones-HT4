package stack;

import List.List;
import List.ListFactory;

public class StackFactory {

    public static <T> Stack<T> createStack(int type, int listType) {

        switch (type) {

            case 1:
                String listTypeString;

                if (listType == 1) {
                    listTypeString = "simple";
                } else if (listType == 2) {
                    listTypeString = "double";
                } else {
                    throw new IllegalArgumentException(
                            "Tipo de lista inválido: " + listType +
                                    ". Use 1 (simple) o 2 (doble).");
                }

                List<T> list = ListFactory.createList(listTypeString);
                return new ListStack<T>(list);

            case 2:
                return new StackVector<>();

            case 3:
                return new ArrayListStack<>();

            default:
                throw new IllegalArgumentException("Tipo de stack inválido");
        }
    }
}