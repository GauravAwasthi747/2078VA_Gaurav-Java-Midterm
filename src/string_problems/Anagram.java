package string_problems;

import json.util.JsonReaderUtil;

import java.util.Scanner;

public class Anagram {

    /*
    Write a Java Program, `isAnagram`, to check if any two strings are anagrams

    An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all of the
    original letters exactly once.

        Ex: "CAT" & "ACT",
            "ARMY" & "MARY",
            "FART" & "RAFT"
    */

    /**
     * This method will check if the entered words are anagram of each other. If yes, it will return true, if not it will return false.
     * @param word1: user input for 1st word.
     * @param word2: user input for 2nd word.
     * @return
     */
    boolean isAnagram(String word1, String word2) {
        //initializing and getting length of each word entered.
        int len1 = word1.length();
        int len2 = word2.length();

        //declaring and initializing variable of boolean data-type.
        boolean result = false;

        //Checking if length of both entered words are same to proceed further.
        if (len1 == len2) {
            //Declaring and initializing variables of Char data-type that has same length as length of words entered by user.
            Character[] letter1 = new Character[len1];
            Character[] letter2 = new Character[len2];

            //initializing counter to check how many same characters has been found in both words.
            int counter = 0 ;

            //Starting loop for first word
            for (int i = 0; i < len1; i++) {
                letter1[i] = word1.toLowerCase().charAt(i); //making first word lower case and then finding each character by their index value.
                //System.out.println("Character at position " + i + " of word \""  + word1 + "\" is: " + letter1[i]);

                //Starting loop for the second word
                for (int j = 0; j < len2; j++) {
                    letter2[j] = word2.toLowerCase().charAt(j); //making second word lower case and then finding each character by their index value.
                    //System.out.println("\t\tCharacter at position " + j + " of word \"" + word2+ "\" is: " + letter2[j]);

                    //comparing if character found in both words are same or not. If same, increasing the counter value by 1
                    if (letter1[i] == letter2[j]) {
                        counter = counter + 1;
                        System.out.println("Character matched in both Strings: " + letter1[i]);
                        break;
                    }
                }
                //checking if final counter value is same as of the length of the word.
                if (counter == len1) {
                    System.out.println("Both Words are anagram");
                    result = true;
                }
            }
        }
        return result;
    }
}
