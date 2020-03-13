import java.util.*;
public class StaffIncomeReport
{
   public static void main(String[]args)
   {
   Scanner in = new Scanner(System.in);
   
   String name, ID, incomeType;
   double incomeAmount, incomeTax;
   
   System.out.println("Please Enter Staff Name: ");
      name = in.next();
   System.out.println("Please Enter Staff ID: ");
      ID = in.next();
   System.out.println("Please Enter Staff Income Type: ");
      incomeType = in.next();
   System.out.println("Please Enter Staff Income Amount: ");
      incomeAmount = in.nextDouble();
   System.out.println("Please Enter Staff Income Tax Percentage: ");
      incomeTax = in.nextDouble();
      
      System.out.println("");
      Income income = new Income(incomeType, incomeAmount, incomeTax);
      Staff info = new Staff(name, ID, income);
      
    System.out.println("====== Staff Personal Information ======");
      info.displayStaffInfo();
      System.out.println("");
      
    System.out.println("====== Staff Income Information ======");
      info.displayIncomeInfo();
      System.out.println("");
    }
}

   class Income {
      private String incomeType;
      private double incomeAmount, incomeTax, totalTax;
      
   
      Income(String incomeType, double incomeAmount, double incomeTax) {
         this.incomeType = incomeType;
         this.incomeAmount = incomeAmount;
         this.incomeTax = incomeTax;
      }
      
      String getincomeType() {
         return incomeType;
      }
      
      double getincomeAmount() {
         return incomeAmount;
      }
      
      double getincomeTax() {
         return incomeTax;
      }
      
      double getTotalTax() {
         totalTax = (incomeTax/100) * incomeAmount;
         return totalTax;
      }
  }
      
    class Staff {
      private String name, ID;
      private Income income;
      private double netincome;
      
    
      Staff(String name, String ID, Income income) {
         this.name = name;
         this.ID = ID;
         this.income = income;
      }
      
      String getName() {
         return name;
      }
      
      String getID() {
         return ID;
      }
      
      double calculateNetIncome() {
         netincome = (income.getincomeAmount() - income.getincomeTax());
         return netincome;
      }
      
      void displayStaffInfo() {
         System.out.println("Staff Name: " + name);
         System.out.println("Staff ID: " + ID);
      }
      
      void displayIncomeInfo() {
         System.out.println("Staff Income Type: " + income.getincomeType());
         System.out.println("Staff Income Amount: " + "RM" + income.getincomeAmount());
         System.out.println("Staff Income Tax Percentage: " + income.getincomeTax() + "%");
         System.out.println("Staff Income Total Tax: " + "RM" + income.getTotalTax());
         System.out.println("Staff Net Income: " + "RM" + calculateNetIncome());
       }
   }