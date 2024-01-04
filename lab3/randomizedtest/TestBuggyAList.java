package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> Good = new AListNoResizing<>();
        BuggyAList<Integer> Bad = new BuggyAList<>();

        for (int i = 0; i < 3; i++) {
            Good.addLast(i + 4);
            Bad.addLast(i + 4);
        }
        assertEquals(Good.size(), Bad.size());
        assertEquals(Good.removeLast(), Bad.removeLast());
        assertEquals(Good.removeLast(), Bad.removeLast());
        assertEquals(Good.removeLast(), Bad.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> Lbug = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                Lbug.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int Bsize = Lbug.size();
                assertEquals(size, Bsize);
            } else if (L.size() > 0 && operationNumber == 2) {
                int last = L.getLast();
                L.removeLast();

                int bLast = Lbug.getLast();
                Lbug.removeLast();
                assertEquals(last, bLast);
            }
        }
    }
}
