package deque;

import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayDequeTest {

    @Test
    public void returnIndexTest() {
        ArrayDeque deque = new ArrayDeque();

        int mod = 10;

        for (int i = 0; i < 1000; i++) {
            assertEquals(i % mod, deque.returnIndex(i));
        }
    }

    @Test
    public void addRemoveFirst() {
        ArrayDeque deque = new ArrayDeque();

        for (int i = 0; i < 100; i++) {
            deque.addFirst(i);
        }

        for (int i = 99; i >= 0; i--) {
            assertEquals(i, deque.removeFirst());
        }
    }

    @Test
    public void addRemoveLast() {
        ArrayDeque deque = new ArrayDeque();

        for (int i = 0; i < 100; i++) {
            deque.addLast(i);
        }

        for (int i = 99; i >= 0; i--) {
            assertEquals(i, deque.removeLast());
        }
    }
}
