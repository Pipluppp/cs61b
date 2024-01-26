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

        String errorMessage = "";

        for (int i = 0; i < 100; i++) {
            double rand = StdRandom.uniform();

            if (rand < 0.25) {
                sadStudent.addFirst(i);
                sadSolution.addFirst(i);

                Integer expected = sadSolution.get(0);
                Integer actual = sadStudent.get(0);

                errorMessage += "addFirst(" + actual + ")\n";
                assertEquals(errorMessage, expected, actual);
            }
            else if (rand < 0.5) {
                sadStudent.addLast(i);
                sadSolution.addLast(i);

                Integer expected = sadSolution.get(sadSolution.size() - 1);
                Integer actual = sadStudent.get(sadStudent.size() - 1);

                errorMessage += "addLast(" + actual + ")\n";
                assertEquals(errorMessage, expected, actual);
            }
            else if (rand < 0.75 && !sadStudent.isEmpty()) {
                Integer expected = sadSolution.removeFirst();
                Integer actual = sadStudent.removeFirst();

                errorMessage += "removeFirst()\n";
                assertEquals(errorMessage, expected, actual);
            }
            else if (!sadStudent.isEmpty()) {
                Integer expected = sadSolution.removeLast();
                Integer actual = sadStudent.removeLast();

                errorMessage += "removeLast()\n";
                assertEquals(errorMessage, expected, actual);
            }
        }
    }
}
