//Parth  Barot
//09/30/2014
//Assignment 7 #3 B

import java.util.Scanner;     //Needed for Scanner class

public class BankCharges
{
   public static void main (String[] args)
   {
      double charges = 0;     // to hold a number for charges
      int checks;             //to hold a checks number
      double answer;          //to hold a calculation for written month.
   
   
   //Create a scanner object
      Scanner keyboard = new Scanner(System.in);
   
   //Get the number of checks written in month
      System.out.println("Enter the number of checks"
                       + "written for the month");
      checks = keyboard.nextInt();
         
      if (checks <20)
      {
         charges = 0.10;
      }
      else if (checks < 39)
      {
         charges = 0.08;
      }
      else if (checks <59)
      {
         charges = 0.06;
      }
      else if (checks >= 60)
      {
         charges = 0.04;
      }
    //Calculate the monthly bank service fees
      answer = ((checks * charges)+ 10);
   
    //Display the bank service for the month.
      System.out.println (" The bank service fees for month $ " + answer + ".");
    
   }
}