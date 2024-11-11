package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue {
    protected int fillCount;
    protected int capacity;

    public int capacity() {   // return size of the buffer
        return capacity;
    }
    public int fillCount() {  // return number of items currently in the buffer
        return fillCount;
    }
}
