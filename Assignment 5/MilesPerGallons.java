//PARTH BAROt
// 9 17 14
// Class work
//Chapter 2 problem 9

import java.util.Scanner;

import java.text.DecimalFormat;

public class MilesPerGallons

{
   public static void main(String [] args)
   {
      double miles;  //Miles driven
      double gallons;   //Gallons used
      double mpg;       //Miles-per-gallon
      
      //Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner (System.in);
      DecimalFormat formatter = new DecimalFormat("#0.00");
      
      //prompt the user to eaner miles drive.
      System.out.println (" Enter the miles driven :" );
      miles = keyboard.nextDouble();
      
      //prompt the user to enter the gallons used.
      System.out.println (" Enter the gallons used:");
      gallons = keyboard.nextDouble();
      
      //Calculate mile-per-gallon.
      mpg = miles/ gallons;
      
      //Display the output
      System.out.println(" The MPG is " +formatter.format(mpg));
   }
}
