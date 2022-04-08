package math_problems;

import java.util.Arrays;

public class FindMissingNumber {

    /** INSTRUCTIONS
     * Write a method to find the missing number from the array.
     */

    public static void main(String[] args) {
        int[] array = new int[] {10, 2, 1, 4, 5, 3, 7, 8, 6};

        //Calling the method.
        getMissingNumber(array);
    }

    /**
     * THis method will sort the given array in ascending order and then use some condition
     * in for loop to check the missing number
     * @param array: input array --> given by the user
     */
    static void getMissingNumber(int[] array) {
        //Sorting the given array using sort method
        Arrays.sort(array);

        //Getting the minimum number in the array
        int min_value = array[0]-1;

        //using for loop to check if the iterator count match with the index value.
        //If not then it will display the missing number and breaks the loop.
        for (int i = 0; i < (array.length); i++) {
            min_value = min_value+1;
            if((min_value) != array[i]) {
                System.out.println("Missing number from array is: " + min_value);
                i--;
            }
        }
    }
}
