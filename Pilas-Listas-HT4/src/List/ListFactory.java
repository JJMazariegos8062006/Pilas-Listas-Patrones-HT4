package List;

public class ListFactory {

    public static <T> ListAbstract createList(String type) {

        switch (type.toLowerCase()) {

            case "1":
            case "simple":
            case "singly":
                return new ListSinglyLinked<>();

            case "2":
            case "doble":
            case "doblemente":
            case "double":
                return new ListDoublyLinked<>();

            default:
                throw new IllegalArgumentException("Tipo de lista inválido: " + type);
        }
    }
}