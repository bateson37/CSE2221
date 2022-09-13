import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Compute the square root of a users input using Newton iteration.
 *
 * @author Nick Bateson
 *
 */
public final class Newton2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton2() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        /*
         * Put your code for sqrt here
         */
        if (x < 0) {
            return Double.NaN;
        }
        if (x == 0) {
            return 0;
        }
        double r = x;
        final double epsilon = 0.0001;

        while (Math.abs(r - x / r) > epsilon * r) {
            r = (x / r + r) / 2.0;
        }
        return r;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        String answer = "y";
        while (answer.equals("y")) {
            out.println("Would you like to compute a square root? (y/n): ");
            answer = in.nextLine();
            if (answer.equals("y")) {
                out.println("Insert a positive double: ");
                double userInput = in.nextDouble();
                double squareRoot = sqrt(userInput);
                out.println("Square Root: " + squareRoot);
            }
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
