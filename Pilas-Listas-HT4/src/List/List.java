package List;

public interface List<T> {

    void addLast(T value);

    T removeLast();

    T getLast();

    boolean isEmpty();
}