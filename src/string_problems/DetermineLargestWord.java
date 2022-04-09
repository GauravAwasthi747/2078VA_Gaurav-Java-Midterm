package string_problems;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DetermineLargestWord {

    public static void main(String[] args) {
        /*
         Implement a solution to find the length of the longest word in the given sentence below
         Your solution should return a map containing the length of the word as the key & the word itself as the value
            "10: biological"
         */
        String s = "Human brain is a biological learning machine";
        Map<Integer, String> wordNLength = findTheLargestWord(s);
    }

    public static Map<Integer, String> findTheLargestWord(String wordGiven) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        String st = "";

        // Implement here

        //Checking if Hash-map is empty
        boolean isEmpty = map.isEmpty();
        System.out.println("Is initial created Hash-Map empty: " + isEmpty);

        String[] myArray = wordGiven.split(" ");
        int temp = 0, wordLength = 0;
        String biggestWord = null;

       for (String a : myArray) {
           wordLength = a.length();

           if(wordLength >= temp) {
               temp = wordLength;
               biggestWord = a;
           }
        }

        map.put(temp,  biggestWord);
        System.out.println("Hash-Map for biggest word as key : word is: " + map);

        return map;
    }
}
