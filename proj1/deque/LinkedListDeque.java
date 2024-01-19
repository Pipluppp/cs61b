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
    }

/*    public void addFirst(T item) {
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
    }*/

    public void addFirst(T item) {
        Node node = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;
    }

    public boolean isEmpty() {
        return sentinel.next == null;
    }
}
