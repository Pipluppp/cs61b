package deque;

import java.lang.reflect.Array;
import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T> {
    private int size;
    private T[] arr;
    private int capacity;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        size = 0;
        capacity = 8;
        arr = (T[]) new Object[8];

        nextFirst = 0;
        nextLast = 1;
    }

    public ArrayDeque(int len) {
        arr = (T[]) new Object[len];
        size = 0;
        capacity = len;

        nextFirst = 0;
        nextLast = 1;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = arr[returnIndex(nextFirst + 1)];
            nextFirst++;
        }
        arr = newArray;
        capacity = newCapacity;
        nextFirst = newCapacity - 1;
        nextLast = size;
    }

    public void addFirst(T item) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        size++;

        arr[nextFirst] = item;
        nextFirst = returnIndex(nextFirst - 1);
    }

    public void addLast(T item) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        size++;

        arr[nextLast] = item;
        nextLast = returnIndex(nextLast + 1);
    }

    public T removeFirst() {
        if (size < capacity / 4) {
            resize(capacity / 2);
        }
        size--;

        int toRemove = returnIndex(nextFirst + 1);
        T removedNode = arr[toRemove];
        arr[toRemove] = null;

        nextFirst = toRemove;
        return removedNode;
    }

    public T removeLast() {
        if (size < capacity / 4) {
            resize(capacity / 2);
        }
        size--;

        int toRemove = returnIndex(nextLast - 1);
        T removedNode = arr[toRemove];
        arr[toRemove] = null;

        nextLast = toRemove;
        return removedNode;
    }

    /** Helper method for circular index */
    public int returnIndex(int index) {
        int newIndex = (capacity + index) % capacity;
        return newIndex;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        int front = returnIndex(nextFirst + 1);

        for (int i = 0; i < size; i++) {
            System.out.print(arr[front] + " ");
            front = returnIndex(front + 1);
        }
        System.out.println();
    }

    // Index is the ith item of the list (0 is front, etc.)
    public T get(int index) {
        if (index < 0 || index >  size) {
            return null;
        }
        int arrIndex = returnIndex(nextFirst + index + 1);
        T node = arr[arrIndex];
        return node;
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int startIndex;
        private int endIndex;

        public ArrayDequeIterator() {
            startIndex = returnIndex(nextFirst + 1);
            endIndex = returnIndex(nextLast - 1);
        }

        public boolean hasNext() {
            return startIndex != endIndex;
        }

        public T next() {
            int index = startIndex;
            startIndex = returnIndex(startIndex + 1);
            return arr[index];
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof ArrayDeque oArrayDeque) {
            if (size == oArrayDeque.size) {
                return true;
            }

            int i = 0;
            for (T x: this) {
                if (x != oArrayDeque.get(i)) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

}
