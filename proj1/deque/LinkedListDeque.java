package deque;
public class LinkedListDeque<T> {
    // Node class
    private class Node {
        public T item;
        public Node next;
        public Node prev;

        public Node (T x, Node n) {
            prev = null;
            item = x;
            next = n;
        }
    }

    // Points to first node, in circular list: first node's prev points to last and last node's next points to first
    private Node sentinel;
    private int size;

    // Constructor empty list
    public LinkedListDeque() {
        sentinel = new Node(null, null);
    }

    // Constructor list one node
    public LinkedListDeque(T x) {
        sentinel = new Node(null, null);
        Node firstNode = new Node(x, null);
        sentinel.next = firstNode;
        firstNode.next = firstNode;
        firstNode.prev = firstNode;
        size = 1;
    }

    public void addFirst(T item) {
        if (isEmpty()) {
            sentinel.next = new Node(item, null);
            sentinel.next.next = sentinel.next;
            sentinel.next.prev = sentinel.next;
        }
        else {
            Node prevFirstNode = sentinel.next;
            Node last = prevFirstNode.prev;

            // Connect pointers of new first node
            sentinel.next = new Node(item, sentinel.next);
            prevFirstNode.prev = sentinel.next;

            // Connect pointers of last node to new first node
            sentinel.next.prev = last;
            last.next = sentinel.next;
        }
    }

    public boolean isEmpty() {
        return sentinel.next == null;
    }
}
