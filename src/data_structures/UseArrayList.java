package data_structures;

import databases.SharedStepsDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class UseArrayList {

    public static void main(String[] args) throws SQLException {
        /*
         * Demonstrate how to use ArrayList that includes using the add, peek, remove & retrieve methods.
         * Use For-Each loop and While-loop with Iterator to retrieve data.
         *
         * Store and retrieve data from/to a database table.
         */

        List<Object> myList = new ArrayList();

        //using add() method
        myList.add(0,"BMW");
        myList.add(0,"Audi");
        myList.add(0,"Subaru");
        myList.add(0, "Toyota");

        System.out.println("ArrayList is: " + myList);

        //using remove() method
        myList.remove("Audi");
        System.out.println("ArrayList after removing Audi: " + myList);

        //finding size of ArrayList
        System.out.println("\nSize of ArrayList is: " + myList.size());

        //using for-each loop to retrieve the data
        System.out.println("\nArrayList using for-each loop");

        for (Object s : myList) {
            System.out.println(s);
        }

        System.out.println("\nArrayList - using while loop");
        int count = 0;
        while (myList.size() > count) {
            System.out.println(myList.get(count));
            count++;
        }

        //Adding ArrayList to DataTable
        System.out.println("\nAdding to Data-base");

        SharedStepsDatabase ssdb = new SharedStepsDatabase();
        String tableName = "cars";

        ssdb.insertArrayList(tableName, myList);

        //Retrieving data from Datatable
        System.out.println("\nRetrieving from Data-base");
        List<List<String>> query = ssdb.executeQueryReadAll("SELECT * FROM " + tableName.toUpperCase());
        for (List<String> x : query) {
            System.out.println(x);
        }
    }
}
