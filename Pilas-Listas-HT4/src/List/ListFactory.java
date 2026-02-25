package List;

public class ListFactory {

    public static <T> List<T> createList(String type) {

        switch (type.toLowerCase()) {

            case "simple":
                return new ListSinglyLinked<T>();

            case "doble":
                return new ListDoublyLinked<T>();

            default:
                throw new IllegalArgumentException("Tipo de lista inválido");
        }
    }
}