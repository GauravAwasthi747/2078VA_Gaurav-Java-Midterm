package company_app_design;


public abstract class EmployeeData implements Employee {

   String isTrainingReq, hasMedicalInsurance;

   abstract void isTrainingReq();

   void hasMedicalInsurance() {
       System.out.println("Full Time Employees has Medical Insurance.");
   }

}
