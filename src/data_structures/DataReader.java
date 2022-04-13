package data_structures;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import databases.SharedStepsDatabase;
import java.sql.SQLException;

public class DataReader {

    /**
     * Create an API to read the .txt file and print it to the console.
     *      HINT: Use BufferedReader class
     * Use try-catch block to handle any exceptions
     *
     * Store and retrieve the file to/from a database table.
     *
     * After reading from file using BufferedReader API, store each word, first into a LinkedList. Each word
     * should construct a node in LinkedList. Second, do the same, but with a Stack.
     * Finally, traverse through the list\stack & retrieve each item in `FIFO` order and `FILO` order, respectively
     *
     * Demonstrate how to use a stack using push, peek, search & pop methods.
     * Use For-Each & While-loop with Iterator to retrieve/print data.
     **/

    static FileInputStream fIS;
    static InputStreamReader iSR;
    static BufferedReader bR;

    public static void main(String[] args) {
        String textFilePath = System.getProperty("user.dir") + "\\src\\data_structures\\data\\self-driving-car.txt";
        System.out.println(textFilePath);

        //Creating file object to read a .txt file
        File objFile = new File(textFilePath);

        //Creating LinkList object
        LinkedList<String> objLinkedList = new LinkedList<>();

        //Creating Stack object
        Stack<String> objStack = new Stack<>();

        //Checking if file exist to work with
        boolean doesFileExist = objFile.exists();

        //using try-catch-finally block to work with
        try {
            fIS = new FileInputStream(objFile);
            iSR = new InputStreamReader(fIS);
            bR = new BufferedReader(iSR);

            //Declaring String variable to read the text file.
            //String inputLine = null;
            String line;
            String tableName = "data_reader";

            SharedStepsDatabase ssdb = new SharedStepsDatabase();

            while ((line = bR.readLine()) != null) {
                System.out.println(line);

                //Store the file in the database table.
                ssdb.insertString(tableName, "text", line);

                if (line != "") {
                    //creating string array to split the text in order to save them in Link-list.
                    String[] linkedListArray;
                    linkedListArray = line.split(" ");

                    //storing each word in likedList
                    for (int i = 0; i < linkedListArray.length; i++) {
                        objLinkedList.add(linkedListArray[i]);  //this method add the elements in list like in queue.
                    }

                    //creating Stack array to split the text file content inorder to put in the stack
                    String[] stackArray;
                    stackArray = line.split(" ");

                    //storing each word in the stack
                    for (int j = 0; j < stackArray.length; j++) {
                        objStack.push(stackArray[j]);   //this method will add the elements one over another in stack, like a stack of books.
                    }
                }
            }

            //retrieving items from List
            System.out.println("\nList elements: ");
            for (String s: objLinkedList) {
                System.out.print(s + " ");
            }

            //FIFO methods
            //peek() - This method retrieves but does not remove, the head (first element) of this list.
            System.out.println("\nList peek: " + objLinkedList.peek());

            //poll() - This method retrieves and removes the head (first element) of this list.
            System.out.println("List poll: " + objLinkedList.poll());

            //retrieving items from stack
            System.out.print("\nStack Elements: ");
            for (String s : objStack) {
                System.out.print(s + " ");
            }

            // FILO - methods
            //peek method
            System.out.println("\nStack peek: " + objStack.peek());    //returns the top element of the stack

            // search method
            System.out.println("Stack search on index: " + objStack.search("Tesla"));

            //pop method
            System.out.println("Stack pop: " + objStack.pop()); //it will pop the top element of the stack


            //Database output
            System.out.println("\n\nFetching Data from the Data table");
            List<List<String>> query = ssdb.executeQueryReadAll("SELECT * FROM DATA_READER");
            for (List<String> x : query) {
                System.out.println(x);
            }

        }catch (FileNotFoundException fNFE) {
            System.out.println("File doesn't exist." + fNFE.getCause());
        } catch (IOException iOE) {
            System.out.println("Couldn't Read from the file. Check for corrupted file");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                fIS.close();
                iSR.close();
                bR.close();
            }catch (IOException iOE) {
                iOE.printStackTrace();
            }
        }
    }
}
