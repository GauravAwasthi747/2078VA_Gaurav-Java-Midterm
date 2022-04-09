package string_problems;

public class Palindrome {

    /*
      A palindrome is a word that can be reversed, and still remain the same.
      Example: MOM, DAD, MADAM, RACECAR

      Create a method to check if any given String is a palindrome or not.
     */

    // Implement here

    /**
     * This method will check if the entered word is a Palindrome or not
     * @param word: user input
     * @return: will return true if the entered word is a Palindrome, false if not.
     */
    Boolean isPalindrome(String word) {
        boolean result = false;
        String reverseWord = "";
        int wordLength = word.length(); //getting the length of user word

        //looping through the length of the word entered by user and then adding it in a string in reverse order.
        for (int i = 0; i < wordLength; i++) {
           char letter = word.toUpperCase().charAt(i);
           reverseWord = letter+reverseWord;
        }

        //comparing if the entered word and the reverse words are equal in content, if yes printing it put and returning the value of true.
        if ((word.toUpperCase()).equals(reverseWord)) {
            System.out.println((word.toUpperCase()) + " is a Palindrome.");
            result = true;
        } else {
            System.out.println((word.toUpperCase()) + " is NOT a Palindrome.");
        }
        return result;
    }
}
