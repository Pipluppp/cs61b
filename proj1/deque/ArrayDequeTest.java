package deque;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Iterator;

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
    public void addRemoveFirstTest() {
        ArrayDeque deque = new ArrayDeque();

        for (int i = 0; i < 100; i++) {
            deque.addFirst(i);
        }

        for (int i = 99; i >= 0; i--) {
            assertEquals(i, deque.removeFirst());
        }
    }

    @Test
    public void addRemoveLastTest() {
        ArrayDeque deque = new ArrayDeque();

        for (int i = 0; i < 100; i++) {
            deque.addLast(i);
        }

        for (int i = 99; i >= 0; i--) {
            assertEquals(i, deque.removeLast());
        }
    }

    @Test
    public void printDequeTest() {
        ArrayDeque deque = new ArrayDeque();

        // 0, 1, 2, 3, ...
        for (int i = 0; i < 50; i++) {
            deque.addLast(i);
        }

        // 99, 98, 97, ..., 50, 0, 1, 2, ...
        for (int i = 50; i < 100; i++) {
            deque.addFirst(i);
        }

        deque.printDeque();
    }

    @Test
    public void getDequeTest() {
        ArrayDeque deque = new ArrayDeque();

        // 0, 1, 2, 3, ...
        for (int i = 0; i < 50; i++) {
            deque.addLast(i);
        }

        for (int i = 50; i >= 0; i--) {
            System.out.println(deque.get(i));
        }
    }

    @Test
    public void iteratorArrayDequeTest() {
        ArrayDeque<Integer> ADeque = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            ADeque.addFirst(i);
        }

        Iterator<Integer> ADequeSeer = ADeque.iterator();

        for (int i: ADeque) {
            System.out.println(i);
        }
    }
}
