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
public final class Newton3 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton3() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%. If
     * x = 0, then root = 0, no calculation done.
     *
     * @param x
     *            positive number to compute square root of
     * @param e
     *            user-defined relative error
     * @return estimate of square root
     */
    private static double sqrt(double x, double e) {
        //Declaring initial variables
        double r = x;
        double rt;

        //checking if x = 0
        if (x != 0) {
            //calculating initial guess
            rt = (x / r + r) / 2;

            while ((((rt * rt) - r) / r) > e * e) {
                rt = (r / rt + rt) / 2;
            }

        } else {
            rt = 0;
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
        //Ask user for relative error
        out.print("What is your desired relative error?");
        double e = in.nextDouble();

        //Enter loop so user has the option to keep going or quit
        while (userChoice.equals("y")) {
            //Ask user for the number
            out.print("Please pick a number to calculate its square root ");
            double userNum = in.nextDouble();

            //Calculate the square root
            double userSqrt = sqrt(userNum, e);

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
