package math_problems;

import sorting.Sorting;

public class UnitTestingMath {

    /**
     * Use this class to unit test all of the class within this package
     */

    public static void main(String[] args) {
        //Factorial
        System.out.println("Factorial");
        Factorial.getFactorial(10);
        System.out.println("Factorial of 10!: " + Factorial.getFactorialRecursion(10));

        //Fibonacci
        System.out.println("\nFibonacci");
        Fibonacci.getFibonacciNumber(10);

        //FindLowestDifference
        int[] array1 = {30, 12, 5, 9, 2, 20, 33, 1, -15};
        int[] array2 = {18, 25, 41, 47, 17, 36, 14, 19, -15};
        System.out.println("\n\nFindLowestDifference");
        System.out.println("\nlowest number that is not shared is: " + FindLowestDifference.getLowestNumber(array1, array2));

        //FindMissingNumber
        int[] array = new int[] {10, 2, 1, 4, 5, 3, 7, 8, 6};
        System.out.println("\nFindMissingNumber");
        FindMissingNumber.getMissingNumber(array);

        //LowestNumber
        int[] array_LN = new int[] {211, 110, 99, 34, 67, 89, 67, 456, 321, 456, 78, 90, 45, 32, 56, 78, 90, 54, 32, 123, 67, 5, 679, 54, 32, 65};
        System.out.println("\nLowestNumber");
        LowestNumber.getLowestNumber(array_LN);

        //Pattern
        System.out.println("\nPattern");
        Pattern.getPattern();

        //PrimeNumber
        int min_num = 2;
        int max_num = 1000000;
        System.out.println("\nPrimeNumber");
        PrimeNumber.getPrimeNumber(min_num, max_num);

    }
}
