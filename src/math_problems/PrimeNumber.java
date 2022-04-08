package math_problems;

public class PrimeNumber {

    /** INSTRUCTIONS
     * Write a method to print a list of all prime numbers from 2 to 1,000,000.
     *  Print out the prime numbers in the given range.
     *
     * BONUS: Figure out how to improve algorithmic efficiency
     */
    public static void main(String[] args) {
        int min_num = 2;
        int max_num = 1000000;

       //Calling the method
        getPrimeNumber(min_num, max_num);
    }

    /**
     * This method will calculate the prime number from 2 to 1 million.
     * @param min: user given input
     * @param max: user given input
     */
    static void getPrimeNumber(int min, int max) {
         for (int i = min; i <= max; i++) { //using for loop to iterate from 1 to 1 million
             int counter = 0;               // setting and resetting the counter for each number for loop move to
            for (int j = i; j >= 1; j--) {  //using another for loop to divide the current number by it-self and by all the numbers before it. So 6 by 6, 5, 4, 3, 2, 1
                if(i%j == 0) {
                    counter = counter + 1;  //increasing the counter every time the reminder is 0
                }
            }
            if (counter == 2) { // a prime number is divisible by itself and 1, so only two times. Hence this condition is true is counter = 2, so the number is prime number.
                System.out.print(i + ", ");
            }
        }
     }
}
