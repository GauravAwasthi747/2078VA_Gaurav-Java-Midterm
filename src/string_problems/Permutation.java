package string_problems;

public class Permutation {

    /*
    Create a Java program to compute all permutations of any given string

        e.g. -  "ABC" = "ABC" "ACB" "BAC" "BCA" "CAB" "CBA"
     */

    // Implement Here

    // Recursive function to generate all permutations of a string
    void getPermutation(char[] ch, int currentIndex) {
        if (currentIndex == ch.length - 1) {
            System.out.println(String.valueOf(ch));
        }

        //using for loop to iterate through each character array
        for (int i = currentIndex; i < ch.length; i++) {
            swap(ch, currentIndex, i);
            getPermutation(ch, currentIndex + 1);
            swap(ch, currentIndex, i);
        }
    }

    //Swapping the character array to create a new string.
    static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
