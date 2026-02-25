package List;

public abstract class ListAbstract<T> implements List<T> {

    protected int size = 0;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}