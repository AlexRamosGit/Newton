import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Newton1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton1() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        //Declaring initial variables
        final double e = 0.0001;
        double r = x;

        //calculating initial guess
        double rt = (x / r + r) / 2;

        while ((((rt * rt) - r) / r) > e * e) {
            rt = (r / rt + rt) / 2;
        }

        return rt;
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

        //Ask user if they wish to calculate a square root
        out.print(
                "Do you wish to calculate a square root? Yes(y) No(Any Input) ");
        String userChoice = in.nextLine();
        out.println();

        //Enter loop so user has the option to keep going or quit
        while (userChoice.equals("y")) {
            //Ask user for the number
            out.print("Please pick a number to calculate its square root ");
            double userNum = in.nextDouble();

            //Calculate the square root
            double userSqrt = sqrt(userNum);

            //Output final result to user
            out.println("The approximate square root of " + userNum + " is "
                    + userSqrt + ".");

            //Ask user if he wants to calculate another number
            out.print(
                    "Do you wish to calculate a square root? Yes(y) No(Any Input) ");
            userChoice = in.nextLine();
        }

        //Goodbye!
        out.println();
        out.println("Thank you for using this program");

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
