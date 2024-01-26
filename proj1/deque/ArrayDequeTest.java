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

    @Test
    public void equalsTest() {
        ArrayDeque<Integer> arr1 = new ArrayDeque<>();
        ArrayDeque<Integer> arr2 = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            arr1.addLast(i);
        }

        for (int i = 0; i < 10; i++) {
            arr2.addLast(i);
        }
        boolean result = arr1.equals(arr2);
        assertTrue(result);
    }

    @Test
    public void resizeArrayDequeTest() {
        int initialSize = 8;
        ArrayDeque<Integer> arr = new ArrayDeque<>();

        // Fills array with 10 items, resizes array to 16
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        assertEquals(initialSize * 2, arr.capacity());

        // Adds 10 more, now total of 20 items, resizes array to 32
        for (int i = 10; i < 20; i++) {
            arr.addLast(i);
        }

        assertEquals(initialSize * 2 * 2, arr.capacity());

        // Remove 13 items (7 < 32 / 4), resizes array to 16
        for (int i = 0; i < 14; i++) {
            arr.removeLast();
        }

        assertEquals(initialSize * 2 * 2 / 2, arr.capacity());
    }

    // Adopted tests from original test on LinkedListDeque

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigArrayDequeTest() {
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            ad.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) ad.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) ad.removeLast(), 0.0);
        }

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, ad.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, ad.removeLast());
    }

}
