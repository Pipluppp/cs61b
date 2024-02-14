package deque;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {
    @Test
    public void IntComparatorTest() {
        MaxArrayDeque<Integer> mad = new MaxArrayDeque<>(MaxArrayDeque.getIntComparator());

        int max = 99;
        for (int i = 0; i < 100; i++) {
            mad.addLast(i);
        }

        assertEquals(max, (int) mad.max());

    }

    @Test
    public void DigitSumComparatorTest() {
        MaxArrayDeque<Integer> mad = new MaxArrayDeque<>(MaxArrayDeque.getDigitSumComparator());

        int expectedMax = 99;
        for (int i = 0; i < 100; i++) {
            mad.addLast(i);
        }

        assertEquals(expectedMax, (int) mad.max());
    }
}
