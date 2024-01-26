package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> cmp;

    public MaxArrayDeque(Comparator<T> c) {
        cmp = c;
    }

    public T max() {
        return max(cmp);
    }

    public T max(Comparator<T> c) {

        int maxIndex = 0;
        for (int i = 1; i < size(); i++) {
            if (c.compare(get(maxIndex), get(i)) < 0) {
                maxIndex = i;
            }
        }
        return get(maxIndex);
    }

    private static class IntComparator implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static IntComparator getIntComparator() {
        return new IntComparator();
    }
}
