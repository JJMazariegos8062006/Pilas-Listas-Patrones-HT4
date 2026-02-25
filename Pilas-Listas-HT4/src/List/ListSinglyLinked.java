package List;

public class ListSinglyLinked<T> extends ListAbstract<T> {

    private Node<T> head;

    @Override
    public void addLast(T value) {

        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        size++;
    }

    @Override
    public T removeLast() {

        if (isEmpty()) {
            throw new RuntimeException("Lista vacía");
        }

        if (head.next == null) {
            T value = head.value;
            head = null;
            size--;
            return value;
        }

        Node<T> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        T value = temp.next.value;
        temp.next = null;
        size--;
        return value;
    }

    @Override
    public T getLast() {

        if (isEmpty()) {
            throw new RuntimeException("Lista vacía");
        }

        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        return temp.value;
    }
}