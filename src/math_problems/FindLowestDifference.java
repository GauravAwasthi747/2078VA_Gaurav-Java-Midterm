package math_problems;

public class FindLowestDifference {

    /** INSTRUCTIONS
     * Write a method to return the lowest number, that is not shared between the 2 arrays
     * HINT: The lowest number that isn't shared between these arrays is 1
     */

    public static void main(String[] args) {
        int[] array1 = {30, 12, 5, 9, 2, 20, 33, 1, -15};
        int[] array2 = {18, 25, 41, 47, 17, 36, 14, 19, -15};

        System.out.println("\nlowest number that is not shared is: " + getLowestNumber(array1, array2));
    }


    /**
     * This method will sort both arrays in ascending order, then it will compare the lowest index of both arrays, if same value is found, it will move to next index and compares again.
     * @param array_1: First array
     * @param array_2: Second array
     * @return: will return the lowest number that is not shared in both arrays.
     */
    static int getLowestNumber(int[] array_1, int[] array_2) {
        //Sorting array1
        int temp1;
        for (int i = 0; i < (array_1.length); i++) {
            for (int j = (i+1); j < (array_1.length); j++) {
                if (array_1[i] > array_1[j]) {
                  temp1 = array_1[i];
                  array_1[i] = array_1[j];
                  array_1[j] = temp1;
                }
            }
            System.out.print("\t" + array_1[i]);
        }

        System.out.println("\n");

        //Sorting array2
        int temp2;
        for (int i = 0; i < (array_2.length); i++) {
            for (int j = (i+1); j < (array_2.length); j++) {
                if (array_2[i] > array_2[j]) {
                    temp2 = array_2[i];
                    array_2[i] = array_2[j];
                    array_2[j] = temp2;
                }
            }
            System.out.print("\t" + array_2[i]);
        }

        //Comparing Array1 and Array2
        int result = 0;
        for (int i = 0; i < array_1.length; i++) {
            if (array_1[i] < array_2[i]) {
                result = array_1[i];
                break;
            } else if (array_2[i] < array_1[i]) {
                result =  array_2[i];
                break;
            } else {
                System.out.println("\nSame elements found at index[" + i + "] moving to index[" + (i+1) + "]");
            }

        }
       return result;
    }

}