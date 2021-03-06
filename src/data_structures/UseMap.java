package data_structures;

import databases.SharedStepsDatabase;

import java.util.*;

public class UseMap {

    public static void main(String[] args) throws Exception {
        /*
         * Implement code to demonstrate how to interact with a database connection, using a Map
         * You must insert the map into a table, and then you must submit & execute a query to retrieve
         * all the data_structures.data (retrieval does not need to be stored as a map)
         *
         * Use For-Each loop and While-loop with Iterator to retrieve data_structures.data.
         *
         * Store and retrieve data_structures.data from/to a database table.
         */

        Map<Object, Object> map = new HashMap<>();
        map.put(8454, "lamia");
        map.put(4567, "azar");
        map.put(7898, "rahim");

        // Retrieving "Keys" & "Values" using an Iterator
        Iterator<Object> mapIter = map.keySet().iterator();
        Object key;
        while (mapIter.hasNext()) {
            key = mapIter.next();
            System.out.println("KEY: " + key);
            System.out.println("VALUE: " + map.get(key));
        }

        System.out.println("\nAdding to Data-base");
        String tableName = "test_hash_map";
        SharedStepsDatabase ssdb = new SharedStepsDatabase();
        ssdb.insertMap(tableName,map);

        System.out.println("\nRetrieving from Data-base");
        //System.out.println(ssdb.executeQueryReadAll("SELECT * FROM " + tableName.toUpperCase()));
        List<List<String>> query = ssdb.executeQueryReadAll("SELECT * FROM " + tableName.toUpperCase());
        for (List<String> x : query) {
            System.out.println(x);
        }
    }
}
