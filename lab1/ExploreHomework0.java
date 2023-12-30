public class ExploreHomework0 {

    public static int Sum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i = i + 1) {
            sum = sum + a[i];
        }
        return sum;
    }

    public static void Triangle(int dim) {
        if (dim == 0) {
            return;
        }
        Triangle(dim - 1);
        for (int i = 0; i < dim; i++) {
            System.out.print("#");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};

        Triangle(10);
        System.out.println(Sum(numbers));

    }
}
