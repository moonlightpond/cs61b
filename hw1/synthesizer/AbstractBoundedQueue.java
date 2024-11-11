package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;

    @Override
    public int capacity() {   // return size of the buffer
        return capacity;
    }

    @Override
    public int fillCount() {  // return number of items currently in the buffer
        return fillCount;
    }
}
