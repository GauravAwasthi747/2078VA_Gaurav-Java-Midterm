package string_problems;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DuplicateWord {

    public static void main(String[] args) {

        /*
         Write a java program to find duplicate words and the number of occurrences of those words in the given string.
            Also, find the average length of all the words.
         */

        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";

        // Implement here
        isDuplicateWord(st);
    }

    /**
     * This method will check the duplicate words in the sentence and return their name along with the occurrence number
     * @param sentence: input sentence from user
     * @return: will return true if duplicate words found.
     */
    static boolean isDuplicateWord(String sentence) {
        boolean result = false;
        String repeatedWord = null;
        int n = 0;

        //converting user input sentence to all lower case
        sentence = sentence.toLowerCase();

        //replacing '.' with no space for sentence symmetry
        sentence = sentence.replace(".", "");

        //creating an array of length equal to the space splits of string
        String[] wordArray = sentence.split(" ");

        //creating another array of similar length to store unique duplicate values
        String[] tempArray = new String[wordArray.length];

        //looping with the first word of the sentence
        for (int i = 0; i < (wordArray.length); i++) {
            int wordRepeatCounter = 0;  //initiating and re-initiating the wordRepeaterCounter variable.

            //looping with the second word of the sentence
            for (int j = (i+1); j < (wordArray.length); j++) {
                if ((wordArray[i]).equals(wordArray[j])) { //comparing each words
                    wordRepeatCounter++;    //if matched increasing the counter value by 1
                    repeatedWord = wordArray[i];    // storing the word in a variable
                }
            }
            //checking here if any duplicate words has been found.
            if (wordRepeatCounter > 0) {
                int counter = 0;

                //checking an existing array to make sure repeated word has not use in the past.
                for (int m = 0; m < (tempArray.length); m++){
                    if((repeatedWord).equals(tempArray[m])) {
                        counter++;
                        break;
                    }
                }
                //checking if recently caught word has not been used in the past then putting it in the array and printing out the value.
                if (counter == 0) {
                    tempArray[n] = repeatedWord;
                    System.out.println("\nDuplicate word: " + repeatedWord);
                    System.out.println("Occurance: " + (wordRepeatCounter+1) + " times.");
                    result = true;
                    n++;
                }
            }
        }
        return result;
    }
}
