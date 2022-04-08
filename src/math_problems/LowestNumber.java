package math_problems;

public class LowestNumber {

    /** INSTRUCTIONS
     * Write a method to find the lowest number from this array.
     */

    public static void main(String[] args) {

        int[] array = new int[] {211, 110, 99, 34, 67, 89, 67, 456, 321, 456, 78, 90, 45, 32, 56, 78, 90, 54, 32, 123,
                67, 5, 679, 54, 32, 65};

        //Calling the method
        getLowestNumber(array);
    }

    /**
     * This method will take an array, sort it out without using sort function and then find the minimum value at the lowest index i.e. 0
     * @param myArray: this is the input array from user.
     */
    static void getLowestNumber(int[] myArray) {
        int temp;
        for (int i = 0; i < (myArray.length); i++) {
            for (int j = (i+1); j < (myArray.length); j++) {
                if (myArray[i] > myArray[j]) {
                    temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }
        System.out.println("lowest number from this array is: " + myArray[0]);
    }
}
