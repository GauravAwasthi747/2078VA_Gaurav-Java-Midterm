package databases;

import java.util.List;

public class UnitTestConnectDB {

    /**
     * Use this class to unit test the SharedStepsDatabase class
     */

    public static void main(String[] args) throws Exception {

        // region readAllTest
        SharedStepsDatabase ssdb = new SharedStepsDatabase();
        String query = "SELECT * FROM DATA_READER";

        List<List<String>> data = ssdb.executeQueryReadAll(query);

        if (data != null) {
            for (List<String> row : data) {
                for (String cell : row) {
                    System.out.print(cell + "\t\t\t\t");
                }
                System.out.println();
            }
        }

        // endregion
    }
}
