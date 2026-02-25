package List;

public class ListDoublyLinked<T> extends ListAbstract<T> {

    private Node<T> head;
    private Node<T> tail;

    @Override
    public void addLast(T value) {

        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    @Override
    public T removeLast() {

        if (isEmpty()) {
            throw new RuntimeException("Lista vacía");
        }

        T value = tail.value;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return value;
    }

    @Override
    public T getLast() {

        if (isEmpty()) {
            throw new RuntimeException("Lista vacía");
        }

        return tail.value;
    }
}
