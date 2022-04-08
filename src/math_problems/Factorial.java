package math_problems;

import java.util.Scanner;

public class Factorial {

    /** INSTRUCTIONS
     * Write a method to return the Factorial of any given number using Recursion, as well as iteration.
     * I have not taught you recursion. Your job is to look it up, learn about it, and use it to find a solution.
     *
     * HINT: Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120
     */

    public static void main(String[] args) {

        //Creating a Scanner class
        Scanner objScanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = objScanner.nextInt();

        //Method: 1 --> Iteration
        System.out.println("Getting factorial result via iteration");
        getFactorial(number);

        //Method:2 --> Recursive
        System.out.println("\nGetting factorial result via Recursion");
        System.out.println("Factorial of " + number + "!: " + getFactorialRecursion(number));
    }

    /**
     * This method is using for-loop to find the factorial
     * @param num : it is a parameter whose value changes as per user input
     * return: This method is void in nature, but prints out the final value.
     */
    static void getFactorial(int num) {
        int temp;

        if (num == 0) {
            temp = 0;
        } else {
            temp = 1;
            for (int i = num; i > 0; i--) {
                temp = temp * i ;
            }
        }
        System.out.println("Factorial of " + num + "!: " + temp);
    }


    /**
     * This method returns the factorial of a number using recursion method
     * @param num: it is a parameter whose value changes as per user input
     * @return: this method will return an integer value.
     */
    static int getFactorialRecursion(int num) {
        if (num > 1) {
            return num * getFactorialRecursion(num - 1);
        } else if (num == 1) {
            return 1;
        } else {
            return 0;
        }
    }

}
