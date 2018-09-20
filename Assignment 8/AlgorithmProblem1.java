//Parth Barot
//Chapter 4 Assignment 8 
//Algorithum workbench #1
//10/14/14

import java.util.Scanner;


public class AlgorithmProblem1
{
   public static void main (String [] args)
   {
      
   
      double product = 0, num; //product and number
      
      product = 0.0;
      num = 0.0;
      
      //create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
      
      //Tell user to enter the number.
      System.out.println("Enter the number");
      num = keyboard.nextDouble();
      
      //calculation of number * 10
      product = num*10;
      
      
      
      //validate the number less than 100.         
      while(product <100)
      {
        //calcule the product.
         product = product * 10;
         System.out.println(product);
      
      }//End of the while loop
   }//End of the mathode
    
}//End of the class/