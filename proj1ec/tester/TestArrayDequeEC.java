package tester;

import static org.junit.Assert.*;
import org.junit.Test;
import student.StudentArrayDeque;
import edu.princeton.cs.introcs.StdRandom;

public class TestArrayDequeEC {

    @Test
    public void test() {
        StudentArrayDeque<Integer> sadStudent = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sadSolution = new ArrayDequeSolution<>();

        for (int i = 0; i < 100; i++) {
            double rand = StdRandom.uniform();

            if (rand < 0.25) {
                sadStudent.addFirst(i);
                sadSolution.addFirst(i);
            }
            else if (rand < 0.5) {
                sadStudent.addLast(i);
                sadSolution.addLast(i);
            }
            else if (rand < 0.75 && !sadStudent.isEmpty()) {
                Integer expected = sadSolution.removeFirst();
                Integer actual = sadStudent.removeFirst();

                assertEquals("removeFirst()", expected, actual);
            }
            else if (!sadStudent.isEmpty()) {
                Integer expected = sadSolution.removeLast();
                Integer actual = sadStudent.removeLast();

                assertEquals("removeLast()", expected, actual);
            }
        }
        System.out.println("The Array Deque, student implementation:");
        sadStudent.printDeque();

        assertEquals(sadSolution.size(), sadStudent.size());

        for (int i = 0; i < sadSolution.size(); i++) {
            Integer expected = sadSolution.get(i);
            Integer actual = sadStudent.get(i);
            assertEquals("Unequal elements at index " + i + " Have: " + expected + "instead of " + actual, expected, actual);
        }
    }
}
