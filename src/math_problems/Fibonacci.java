package math_problems;

import javax.security.sasl.SaslClient;
import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Fibonacci {

    /** INSTRUCTIONS
     * Write a method that will print or return at least 40 Fibonacci numbers
     *
     * e.g. - 0,1,1,2,3,5,8,13
     **/

    public static void main(String[] args) {

        //Creating a scanner class
        Scanner objScanner = new Scanner(System.in);

        System.out.print("How many Fibonacci numbers do you want to create: ");
        int number = objScanner.nextInt();
        objScanner.close();

        //Calling the method.
        getFibonacciNumber(number);

    }

    /**
     * getFibonacciNumber: this method will print out the fibonacci number/s based on user input.
     * @param num: it is the number input by user.
     */
    static void getFibonacciNumber(int num) {
        int sum = 1;
        if (num == 0) {
            System.out.println("You have entered 0. So, no Fibonacci number will be created.");
        } else {
            int[] myArray = new int[num];
            for (int i = 1; i <= num; i++) {
                if (i == 1) {
                    myArray[i-1] = sum - 1;
                }else if(i == 2) {
                    myArray[i-1] = myArray[i-2] + sum;
                } else {
                    myArray[i-1] = myArray[i-2] + myArray[i-3];
                }
                System.out.print(myArray[i-1] + "\t");
            }
        }

    }
}
