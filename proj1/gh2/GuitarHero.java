package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;
import java.lang.Math;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHero {
    public static final double CONCERT_A = 440.0;
    public static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);
    public static final int KEYS = 37;
    public static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static GuitarString[] strings = new GuitarString[KEYS];

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */

        for (int i = 0; i < KEYS; i++) {
            double frequency = 440 * Math.pow(2, ((float) (i - 24) / 12));
            strings[i] = new GuitarString(frequency);
        }

        while (true) {
            double sample = 0;
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int indexOfKey = keyboard.indexOf(key);

                /* Key typed not in our keyboard */
                if (indexOfKey != -1) {
                    strings[indexOfKey].pluck();
                }
            }

            /* compute the superposition of samples */
            for (int i = 0; i < KEYS; i++) {
                sample += strings[i].sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int i = 0; i < KEYS; i++) {
                strings[i].tic();
            }
        }
    }
}

