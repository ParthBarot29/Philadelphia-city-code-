//Parth Barot
//Chapter 4 Assignment 8 
//Sum of Number #1
//10/14/14

import java.util.Scanner;


public class SumofNumbers
{
   public static void main (String [] args)
   {
   
      int number1 ; //number1 as int.
      int sum = 0 ;//the sum of number = 0.
      int num = 0;//the num = 0.
   
      Scanner keyboard = new Scanner(System.in);
   
      System.out.println("Enter a positive number");
      number1 = keyboard.nextInt();
   
      while (num < number1)
      {
         num++;
         
         //calculation of sum.
         sum = sum + num;
         
      }
      //display the result.
      System.out.println(" Sum is " + sum);
      
   }
}
