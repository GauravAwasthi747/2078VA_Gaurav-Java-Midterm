package company_app_design;

import java.io.IOException;
import java.util.Scanner;

import static company_app_design.EmployeeInfo.salary;

public class CompanyEmployee {

    /** INSTRUCTIONS
     *  This class has a main method where you will be able to create instances of the EmployeeInfo class in order
     *  to use attributes and methods.
     *
     *  Demonstrate as many methods as possible here. Feel free to show off what you've learned so far.
     *
     *  The goal of this application is to provide basic employee information services
     *  Try to think like a Software Developer
     */
    public static void main(String[] args) {
        int salary = 0;
        try {
            Scanner objScanner = new Scanner(System.in);
            System.out.print("Enter the Employee Salary: ");
            salary = objScanner.nextInt();
        } catch (IllegalArgumentException iAE) {
            System.out.println("Please enter salary in numbers as int not as String");
        }

        EmployeeInfo objEmployee1 = new EmployeeInfo("Mark", 1234);

        System.out.println("\nEmployee Name is: " + objEmployee1.employeeName());
        System.out.println("Employee-ID is: " + objEmployee1.employeeId());


        EmployeeInfo objEmployee2 = new EmployeeInfo("Josh", 789, "IT", "Full-Time", salary, "yes");
        System.out.println("\nEmployee Name is: " + objEmployee2.employeeName());
        System.out.println("Employee-ID is: " + objEmployee2.employeeId());
        objEmployee2.assignDepartment();
        objEmployee2.getEmployeeJobStatus();
        System.out.println("Employee current salary is: " + objEmployee2.calculateSalary());
        objEmployee2.benefits();

        System.out.println("\nCalculation the Bonus based on Performance grade");
        System.out.println("Annual Bonus is: " + EmployeeInfo.calculateAnnualBonus(salary, 8));

        System.out.println("\nCalculating the Employee Pension based on the number of year they worked");
        System.out.println("Employee Pension: " + EmployeeInfo.calculateEmployeePension());



    }

}
