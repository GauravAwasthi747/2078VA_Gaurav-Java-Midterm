package math_problems;

public class Pattern {

    /** INSTRUCTIONS
     * Read the numbers below, identify the pattern, and then implement the logic from this pattern.
     * Once done, you should test to see if you get the same output as below:
     *
     * 100,99,98,97,96,95,94,93,92,91,90,88,86,84,82,80,78,76,74,72,70,67,64,61,58,55,52,49,46,43,40,36,32...
     *
     */

    public static void main(String[] args) {

        //calling method
        getPattern();
    }

    /**
     * This method will follow the pattern as given in the output.
     */
    static void getPattern() {
        for (int i = 100; i >= 0;) {
            System.out.print(i +", ");

            if ((i <= 100) && (i >= 91) ) {
                i--;
            }else if ((i <= 90) && (i >= 71)) {
                i = i-2;
            }else if ((i <= 70) && (i >= 41)) {
                i = i-3;
            } else {
                i = i - 4;
            }
        }
    }

}
