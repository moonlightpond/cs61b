public class ArrayDeque<T> {
    private int size;
    private T[] items;
    private int RFACTOR = 2;
    private int initialsize = 8;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[initialsize];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private int length() {
        return items.length;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return items[index];
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i]);
            System.out.print(" ");
        }
    }

    private void resize(int newsize) {
        T[] newitems = (T[]) new Object[newsize];
        System.arraycopy(items,0, newitems,0, size);
        items = newitems;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[size] = item;
        size += 1;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T last = items[size - 1];
        size -= 1;
        if (((double) size / items.length) < 0.25) {
            if ((items.length / RFACTOR) >= initialsize) {
                resize(items.length / RFACTOR);
            }
        }
        return last;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        T[] temp = (T[]) new Object[items.length];
        System.arraycopy(items, 0, temp, 1, size);
        temp[0] = item;
        items = temp;
        size += 1;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T first = items[0];
        T[] temp = (T[]) new Object[items.length];
        System.arraycopy(items, 1, temp, 0, size);
        items = temp;
        if (((double) size / items.length) < 0.25) {
            if ((items.length / RFACTOR) >= initialsize) {
                resize(items.length / RFACTOR);
            }
        }
        return first;
    }
}
