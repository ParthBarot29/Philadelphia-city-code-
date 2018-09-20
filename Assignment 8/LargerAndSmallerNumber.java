//Parth Barot
//Chapter 4 Assignment 8 
//problem challenges  # 10
//10/17/14

import java.util.Scanner;


public class LargerAndSmallerNumber
{
   public static void main(String[] args)
   {
      int number1 = 0;     //declare a number 1 as integer.
      int max = 0;         // declare max number as integer.
      int min = 10000;     //declare min number as integer and it value is 10000.
   
      //Create  a scanner object for keyboard input.
      Scanner keyboard=new Scanner(System.in); 
       
      //Get the series of integer.
      System.out.println("Enter the series of integer"); 
      number1=keyboard.nextInt();
      
      while (number1 != -99)
       
      {
         if (number1> max) 
          
            max = number1;
          
      
         if(number1<min) 
            min = number1; 
         number1=keyboard.nextInt();
                             
      } 
   //Display the Larger and smaller number in output.
      System.out.println("Largest Number is: "+max); 
      System.out.println("Smallest Number is: "+min); 
   } 
}