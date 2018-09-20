//Parth Barot
//9-17-14
//Chapter 2 problem # 13

import java.text.DecimalFormat;  //Needed for the Scanner class

import java.util.Scanner;     //Needed for the Scanner class

public class RestaurantBill
{
   public static void main (String[] args)
   {
      double chargeofdinner;     //to hold the restaurant meal bill
      double tax;                // to hold the tax 
      double multiplication;     // to calculate a multiplication        
      double addition;           // to add a two values
      double multiplicationone;  //to calculate a multiplication     
      double tip;                // to hold a tip on meal
      double total;              // to hold restaurent bill
      
               Scanner keyboard = new Scanner(System.in);         //Create a Scanner object to read a input.

      DecimalFormat formatter = new DecimalFormat("#0.00");    // Create a decimalformat 
      
      System.out.println(" what is price of dinner " );  //Get the dinner meal price
      chargeofdinner = keyboard.nextDouble();
      
      System.out.println(" what is the tax ");     //get the tax on meal
      tax = keyboard.nextDouble();
      
      multiplication = chargeofdinner * tax; // Calculate tax and meal price
      
      addition = chargeofdinner + multiplication;  //Calculate mealprice into tax
      
      System.out.println("how many percentage of tip is "); //get the percentages of tip
      tip = keyboard.nextDouble();
      
      multiplicationone = addition * tip;    //Calculate tip into meal price
      
      total =  addition + multiplicationone; //Calculate the final answer by adding tax, tip and mealprice
      
      System.out.println(" Total bill will be $ " +formatter.format(total));
      
      
   } 
}
