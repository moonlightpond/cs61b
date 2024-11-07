public class LinkedListDeque<T> {
    private class NodeList {
        T item;
        NodeList next;
        NodeList prev;
        public NodeList(T x, NodeList y, NodeList z) {
            item = x;
            next = z;
            prev = y;
        }

        public T getRecursiveHelper(int index) {
            if (index == 0) {
                return item;
            }
            if (next == tail) {
                return null;
            }
            return next.getRecursiveHelper(index - 1);
        }
    }

    // head -> first -> other -> last -> tail
    private int size;
    private NodeList first;
    private NodeList last;
    private NodeList head;
    private NodeList tail;

    public LinkedListDeque() {
        size = 0;
        first = head;
        last = tail;
    }
    /*
    public LinkedListDeque(T x) {
        size = 1;
        first = new NodeList(x, head, tail);
        last = new NodeList(x, head, tail);
    }
    */

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T item) {
        size += 1;
        if (size == 1) {
            first = new NodeList(item, head, tail);
            last = first;
        } else if (size == 2) {
            first = new NodeList(item, head, last);
            last.prev = first;
        } else {
            first = new NodeList(item, head, first);
            first.next.prev = first;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            size -= 1;
            T result = first.item;
            if (size == 0) {
                first = head;
                last = tail;
            } else {
                first = first.next;
                first.prev = head;
            }
            return result;
        }
    }

    public void addLast(T item) {
        size += 1;
        if (size == 1) {
            last = new NodeList(item, head, tail);
            first = last;
        } else if (size == 2) {
            last = new NodeList(item, first, tail);
            first.next = last;
        } else {
            last = new NodeList(item, last, tail);
            last.prev.next = last;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            size -= 1;
            T result = last.item;
            if (size == 0) {
                first = head;
                last = tail;
            } else {
                last = last.prev;
                last.next = tail;
            }
            return result;
        }
    }

    public void printDeque() {
        NodeList index = first;
        while (index != tail) {
            System.out.print(index.item);
            System.out.print(" ");
            index = index.next;
        }
    }

    public T get(int index) {
        NodeList p = first;
        while (index != 0) {
            p = p.next;
            index -= 1;
            if (p == tail) {
                return null;
            }
        }
        return p.item;
    }

    public T getRecursive(int index) {
        return first.getRecursiveHelper(index);
    }
}