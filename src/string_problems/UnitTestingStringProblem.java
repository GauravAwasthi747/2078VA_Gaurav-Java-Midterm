package string_problems;

import java.util.Map;
import java.util.Scanner;

public class UnitTestingStringProblem {

    /*
     Use this class to unit test all of the classes contained within this package
     */

    public static void main(String[] args) {
        //Implement Here

        //Creating Scanner object.
        Scanner objScanner = new Scanner(System.in);

        //Calling Anagram function
        System.out.println("Anagram");
        System.out.print("Enter the Word: ");
        String word1 = objScanner.nextLine();

        System.out.print("Enter Anagram word: ");
        String word2 = objScanner.nextLine();

        //Creating object for Anagram class.
        Anagram objAnagram = new Anagram();
        objAnagram.isAnagram(word1, word2); //calling isAnagram method with arguments.


        //DetermineLargestWord
        System.out.println("\nDetermineLargestWord");
        String s = "Human brain is a biological learning machine";
        DetermineLargestWord.findTheLargestWord(s);


        //DuplicateWord
        System.out.println("\nDuplicateWord");
        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
        DuplicateWord.isDuplicateWord(st);


        //Palindrome
        System.out.println("\nPalindrome");
        System.out.print("Enter a Word to check if it is Palindrome or not: ");
        String wordPalindrome = objScanner.nextLine();

        Palindrome objPalindrome = new Palindrome();
        objPalindrome.isPalindrome(wordPalindrome);

        //Permutation
        System.out.println("\nPermutation");
        System.out.print("Enter a word to get all the associated Permutation: ");
        String wordPermutation = objScanner.nextLine();
        objScanner.close();

        Permutation objPermutation = new Permutation();
        objPermutation.getPermutation(wordPermutation.toCharArray(), 0);

    }
}
