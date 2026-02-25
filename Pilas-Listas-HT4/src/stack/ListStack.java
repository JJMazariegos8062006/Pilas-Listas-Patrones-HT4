package stack;

import List.List;

public class ListStack<T> extends AbstractStack<T> {

    private List<T> list;

    public ListStack(List<T> list) {
        this.list = list;
    }

    @Override
    public void push(T value) {
        list.addLast(value);
        count++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack vacío");
        }
        count--;
        return list.removeLast();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack vacío");
        }
        return list.getLast();
    }
}
