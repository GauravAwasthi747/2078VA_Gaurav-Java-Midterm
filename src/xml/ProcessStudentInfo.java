package xml;

import java.io.IOException;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


public class ProcessStudentInfo {

    /** INSTRUCTIONS
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
     *
     * Finally, you must store all student data into a database table, called `selenium_students`
     * Use any database (MongoDB, Oracle MySQL, PostgreSQL) to store and retrieve data.
     *
     **/

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

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

        XmlReader objXML = new XmlReader();

        //list for qtp
       ArrayList<Student> myList1 = (ArrayList<Student>) objXML.parseData("id", qtpDocPath);

        //list for selenium
        ArrayList<Student> myList2 = (ArrayList<Student>) objXML.parseData("id", seleniumDocPath);

        System.out.println(myList1);
        System.out.println(myList2);
//
//          ArrayList<Student> myArrayList1 = new ArrayList();
//
//          for (int i = 0; i<(myList1.size()); i++) {
//            String qtpList = String.valueOf(myList1.get(i));
//
//            if (qtpList.contains("(")) {
//                qtpList = qtpList.replace("(", " ");
//            }
//
//            if (qtpList.contains(")")) {
//                qtpList = qtpList.replace(")", "  ");
//            }
//
//            //System.out.println(qtpList);
//
//            String[] qtpListArray = qtpList.split(", ");
//
//            for (int j = 0; j <(qtpListArray.length); j++) {
//               // System.out.println(qtpListArray[j]);
//                myArrayList1.add(qtpListArray);
//            }
//
//            System.out.println(myArrayList1.get(i));
//
//        }
//
        System.out.println();
//
//        List<String> myArrayList2 = new ArrayList();
//        for (int m = 0; m<(myList2.size()); m++) {
//            String seleniumList = String.valueOf(myList2.get(m));
//
//            if (seleniumList.contains("(")) {
//                seleniumList = seleniumList.replace("(", " ");
//            }
//
//            if (seleniumList.contains(")")) {
//                seleniumList = seleniumList.replace(")", "  ");
//            }
//
//            //System.out.println(qtpList);
//
//            String[] seleniumListArray = seleniumList.split(", ");
//
//            for (int n = 0; n <(seleniumListArray.length); n++) {
//                //System.out.println(seleniumListArray[n]);
//                myArrayList2.add(seleniumListArray[n]);
//            }
//
//            System.out.println(myArrayList2.get(m));
//        }



        //joining the list
        Map<String, List<Student>> studentMap = new LinkedHashMap<String, List<Student>>();
        studentMap.put("qtp", myList1);
        studentMap.put("selenium", myList2);

        System.out.println(studentMap.get("qtp"));


        Set<Map.Entry<String, List<Student>>> entrySet = studentMap.entrySet();
        Iterator studentIter = entrySet.iterator();

        while (studentIter.hasNext()) {
            System.out.println(studentIter.next());
        }



    }
}
