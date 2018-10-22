/**
 * CounterDemo is a simple wrapper class that only contains the main method
 * as seen in the original Counter.java.
 */
public class CounterDemo {

    public static void main(String args[]) {
        // Create variables that can reference two Counters.
        Counter c1, c2;

        c1 = new Counter(5); // wraps at 5
        c2 = new Counter(); // wraps at 12

        final int TIMES = 50;

        System.out.println("c1\tc2\tsum");
        // Show lots of Counter values.
        for (int i = 0; i < TIMES; i++) {
            System.out.println(c1 + "\t" + c2 + "\t"
                    + (c1.getValue() + c2.getValue()));

            // Tick both Counters.
            c1.tick();
            c2.tick();
        }

        c1.reset();
        c2.reset();
        System.out.println("After reset:\t" + c1 + "\t" + c2);
        c1.set(4);
        c2.set(10);
        System.out.println("After set:\t" + c1 + "\t" + c2);
        c1.set(5);
        c2.set(-1);
        System.out.println("After invalid:\t" + c1 + "\t" + c2);
    }
    
}
