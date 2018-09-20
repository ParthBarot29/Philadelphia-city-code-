//
//November 12, 2014
//Group assignment: #11 fracPart


import java.math.*;
import java.util.*;
import java.text.DecimalFormat;
public class GroupAssignment
{
   public static void main(String[] args)
   {
      int intPart = 0;
      double fracPart = 0.0;
      double num, fraction;
      System.out.println("This program will ask you to enter a number including a decimal value between 1.0 and 1000.0, the program will then display the two parts of the number: before and after the decimal.");
      
      Scanner keyboard = new Scanner(System.in);
      
      System.out.print("Please enter a decimal number between 1.0 and 1000.0: ");
      num = keyboard.nextDouble();
     
      while(num<1.0||num>1000.0)
      {
         System.out.println("That is an incorrect number, please re-enter the number correctly.");
         System.out.print("Please enter a decimal number between 1.0 and 1000.0: ");
         num = keyboard.nextDouble();
      }
   
   fraction = fracPart(num);
   
   }
   public static double fracPart(double num)
   {
      int number2;
      double number3;

      number2 = intPart(num);
      number3 = num-number2;
      DecimalFormat formatter = new DecimalFormat("#.#############");
      
      System.out.print("Decimal value: " + formatter.format(number3));
      return number3;
   }
   public static int intPart(double num)
   {
      int number;
      number = (int)num;
      
      
      DecimalFormat formatter = new DecimalFormat("#0");
      formatter.setRoundingMode(RoundingMode.DOWN);
      System.out.println("Whole number: " + formatter.format(num));
      return number;
   }
}