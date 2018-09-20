//Parth Barot
//Chapter 4 Assignment 8 
//Algorithum workbench #1
//10/14/14

import java.util.Scanner;


public class AlgorithumSeconProblem
{
   public static void main (String [] args)
   {
      
   
      double addition, num1 , num2; //product and number
      String answer;
      char repeat;
      
      //create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
      
      //Tell user to enter the number.
               
      do
      {
         System.out.println("Enter the first number");
         num1 = keyboard.nextDouble();
      
      
         System.out.println("Enter the second number");
         num2 = keyboard.nextDouble();
      
         addition = num1 + num2;
         System.out.println(" The sum of the number is " + addition);
         
      
      
         System.out.println(" Would you like to perform a operation again ?");
         System.out.println("Enter Y for yes or N for no: " );
         keyboard.nextLine();
         
         answer =keyboard.next();
         repeat = answer.charAt(0);
      
                  
      }while (repeat == 'Y' || repeat == 'y');
       
 
   }
}
      
      
      
