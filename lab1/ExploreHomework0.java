public class ExploreHomework0 {
    public static void windowPosSum(int[] a, int n) {
        int arrayLength = a.length;

        for (int i = 0; i < arrayLength; i++) {
            int j = i + 1;

            if (a[i] < 0) {
                System.out.println(a[i]);
                continue;
            }

            while (j - i < n + 1 && j < arrayLength) {
                a[i] += a[j];
                j++;
            }
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {

        int[] numbers = new int[]{1, 2, -3, 4, 5, 4};
        windowPosSum(numbers, 3);

    }
}
