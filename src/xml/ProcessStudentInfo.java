package xml;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;

import databases.SharedStepsDatabase;
import org.xml.sax.SAXException;


public class ProcessStudentInfo {

    /**
     * INSTRUCTIONS
     * Take a look at the XmlReader class, found within this package. Try to understand what the parseData() method
     * is doing. This is essential to figuring out how to implement the remainder of this exercise.
     *
     * In that XmlReader class, you need to implement the method called "convertIntToChar()" which should convert the
     * student number scores into corresponding letter grades:
     * 90 - 100 = 'A'
     * 80 - 89  = 'B'
     * 70 - 79  = 'C'
     *
     * Here, in the main method, extend the code that is written and meant to get you started. You must parse the
     * students' information contained within the XML files into 2 separate ArrayList's (One for Selenium students and
     * the other for QTP Students) and then store those lists into the provided HashMap
     *
     * Then, you must use a combination of an iterator and a while-loop to print out the stored data.
     * Your output should be formatted EXACTLY like the example below:
     * ......................................................
     * Student ID: 1
     * First Name: Ibrahim
     * Last Name:  Khan
     * GRADE:      B
     *
     * Student ID: 2
     * First Name: Asif
     * Last Name:  Roni
     * GRADE:      A
     *
     * Student ID: 3
     * First Name: Asif
     * Last Name:  Roni
     * GRADE:      C
     * ......................................................
     * <p>
     * Finally, you must store all student data into a database table, called `selenium_students`
     * Use any database (MongoDB, Oracle MySQL, PostgreSQL) to store and retrieve data.
     **/

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, SQLException {

        // To get you started, your system's abs path has been initialized and some add'l variables have been declared
        String systemPath = System.getProperty("user.dir");
        String seleniumDocRelativePath = "\\src\\xml\\data\\selenium.xml";
        String qtpDocRelativePath = "\\src\\xml\\data\\qtp.xml";
        String seleniumDocPath = systemPath + seleniumDocRelativePath;
        String qtpDocPath = systemPath + qtpDocRelativePath;
        String tag = "id";

        /*
         Here is a map that you'll be using to store 2 lists. One will contain Selenium students, the other will
         contain QTP students
         */

       // public static void printStudentInfo () throws ParserConfigurationException, IOException, SAXException {

            XmlReader objXML = new XmlReader();

            //list for qtp
            ArrayList<Student> myList1;
            myList1 = (ArrayList<Student>) objXML.parseData("id", qtpDocPath);
            System.out.println("QTP Student List: " + myList1);

            //list for selenium
            ArrayList<Student> myList2;
            myList2 = (ArrayList<Student>) objXML.parseData("id", seleniumDocPath);
            System.out.println("\nSelenium Student List: " + myList2);
       // }

       // public static void studentIretration (ArrayList < Student > list) throws ParserConfigurationException, IOException, SAXException {

        List<Student> myList = new ArrayList<>();

        myList.addAll(myList1);
        myList.addAll(myList2);

        System.out.println(myList);

        Map<String, List<Student>> studentMap = new LinkedHashMap<String, List<Student>>();

        int i = 0;
        while (i < myList.size()) {
            studentMap.put("Student Id: " + String.valueOf(myList.get(i).getId()), myList);
            studentMap.put("First Name: " + String.valueOf(myList.get(i).getFirstName()), myList);
            studentMap.put("Last Name: " + String.valueOf(myList.get(i).getLastName()), myList);
            studentMap.put("Grade: " + String.valueOf(myList.get(i).getScore()), myList);
            i++;
        }

        //Iterator
        Iterator studentIterator = studentMap.keySet().iterator();

        //While Loop
        while (studentIterator.hasNext()) {
            System.out.println(studentIterator.next());
        }


        SharedStepsDatabase ssdb = new SharedStepsDatabase();
        //ssdb.insertMap("selenium_students",List<String,List<String>>studentMap);  --can't fix this issue

        // Retrieve all elements from the newly created table
        String student_query = "SELECT * FROM SELENIUM_STUDENTS";
        List<List<String>> students = ssdb.executeQueryReadAll(student_query);
        System.out.println(students);

    }
}


















//        Iterator studentIterator = studentMap.entrySet().iterator();
//
//        while (studentIterator.hasNext()) {
//            System.out.println(studentIterator.next());
//        }




//        int i = 0;
//        while (i < myList.size()) {
//
//            System.out.println("Student ID: " + myList.get(i).getId());
//            System.out.println("First Name: " + myList.get(i).getFirstName());
//            System.out.println("Last Name:  " + myList.get(i).getLastName());
//            System.out.println("Grade:  " + myList.get(i).getScore());
//            System.out.println();
//            i++;
//        }


       // }

//
//    }
//}
