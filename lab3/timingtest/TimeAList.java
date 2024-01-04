package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> List = new AList<>();

        // Timing results
        AList<Integer> N = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> ops = new AList<>();

        Stopwatch sw = new Stopwatch();
        double timeSeconds = 0;

        for (int i = 0, tableSize = 0; i < 128000; i++) {
            List.addLast(i);

            // Note results when at the desired iteration
            if ((i == 1000 * (1 << tableSize))) {
                N.addLast(i);
                times.addLast(sw.elapsedTime());
                ops.addLast(i);
                tableSize++;
            }
        }

        printTimingTable(N, times, ops);
    }
}
