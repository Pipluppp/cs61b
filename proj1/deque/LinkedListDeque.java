package deque;
public class LinkedListDeque<T> {
    // Node class
    private class Node {
        public T item;
        public Node next;
        public Node prev;

        public Node (Node prev, T item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    // Points to first node, in circular list: first node's prev points to last and last node's next points to first
    private Node sentinel;
    private int size;

    // Constructor empty list
    public LinkedListDeque() {
        sentinel = new Node(null,null, null);
        sentinel.prev = sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node node = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;

        size += 1;
    }

    public void addLast(T item) {
        Node node = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;

        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node node = sentinel;

        for (int i = 0; i < size; i++) {
            node = node.next;
            System.out.print(node.item + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node node = sentinel.next;
        Node newFirst = sentinel.next.next;

        newFirst.prev = sentinel;
        sentinel.next = newFirst;
        size -= 1;

        return node.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node node = sentinel.prev;
        Node newLast = sentinel.prev.prev;

        newLast.next = sentinel;
        sentinel.prev = newLast;
        size -= 1;

        return node.item;
    }

    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }

        Node node = sentinel.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.item;
    }

    public T getRecursive(int index) {
        Node node = sentinel;
        node = walkNodes(index, node);

        return node.item;
    }

    /** Walk the nodes for the getRecursive */
    public Node walkNodes(int index, Node node) {
        if (index == 0) {
            return node;
        }
        node = node.next;

        return walkNodes(index - 1, node);
    }
}
