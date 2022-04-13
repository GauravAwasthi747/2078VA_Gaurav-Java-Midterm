package data_structures;

import databases.SharedStepsDatabase;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UseQueue {

    public static void main(String[] args) throws SQLException {
        /*
         * Demonstrate how to use Queue that includes add, peek, remove & poll elements.
         * Use For-Each loop and While-Loop with Iterator to retrieve data_structures.data.
         *
         * Store and retrieve data_structures.data from/to a database table.
         */

            Queue<Integer> myQueue = new LinkedList<>(); {

            //Checking on empty queue
            System.out.println("Is Initial queue full: " + myQueue.peek());

            //adding elements in queue
            myQueue.add(23);
            myQueue.add(500);
            myQueue.add(45);
            myQueue.add(99);
            myQueue.add(100);
            myQueue.add(245);
            myQueue.add(908);

            //checking newly created queue
            System.out.println("\nQueue: " + myQueue);

            //poll
            System.out.println("\npoll: " + myQueue.poll());

            //remove
            System.out.println("\nremove: " + myQueue.remove());

            //peek
            System.out.println("\npeek: " + myQueue.peek());


            //Adding to Data-base
            System.out.println("\nAdding to Data-Base");
            SharedStepsDatabase ssdb = new SharedStepsDatabase();

            String tableName = "queue_table";

            ssdb.insertQueue(tableName, myQueue);


            System.out.println("\nRetrieving from Data-base");
            List<String> query = ssdb.executeQueryReadAllSingleColumn("SELECT * FROM " + tableName.toUpperCase(), "key");

            for (String x : query) {
                System.out.println(x);
            }

        }


    }

}
