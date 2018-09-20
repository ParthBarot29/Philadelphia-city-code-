/*
Parth barot
Chapter 8 program 10 (Array operation)
12/3/14
**/

import java.util.Scanner;
import java.io.*;

public class Chapter8Question10
{
   public static void main(String[] args)
   
   {
      int number1=0;//declare the number1 as int
      
         //Created scanner object to accept the keyboard input.
         Scanner keyboard = new Scanner (System.in);

      System.out.println("This program will going to display the total, average, highernumbers and"
                           +"the lower numbers of the value entered by user.");
      System.out.println();
      
      System.out.println(" How many test scores do you want to enter?");
      number1 = keyboard.nextInt();
      
      double[]numbers = new double[number1];
   
      for (int index=0; index<numbers.length;index++)
      {
         System.out.println("Enter numbers " + (index+1)+ ":");
         numbers[index] = keyboard.nextDouble();
         
      }
   
            
      
      double sum =getTotal(numbers);//method call of getTotal
      double average =  getAverage(numbers);// method call of getAverage
      double high = getHighest(numbers);//method call of getHighest
      double low = getLowest(numbers);//method call of getLowest.
   }
   
   
    
   //get total method
   public static double getTotal(double[] x)
   {
      double total = 0;
      for (int index=0; index<x.length; index++)
      {
         total += x [index];
      }
      System.out.println("The total is " +total);
      return total;
         
   }
     //Get average method    
   public static double getAverage(double[]x)
   {
      int total = 0;
      for (int index = 0; index < x.length; index++)
      {
         total += x[index];
      }
      double average =(total /x.length);
      System.out.println("The Average= " + average);
      return average;
         
   }
   //get Highest method.
   public static double getHighest(double[]x)
   {
      double highest=x[0];
      for (int index=1; index <x.length; index++)
      {
         if (x[index]>highest)
            highest=x[index];
      }
      System.out.println ("The highest value is " + highest);
      return highest;
   }
      //get Lowest method  
   public static double getLowest(double[]x)
   {
      double lowest = x[0];
      for (int index = 1; index< x.length; index++)
      {
         if (x[index]<lowest)
            lowest =x[index];
      }
      System.out.println("The lowest value is " + lowest);
      return lowest;
      
   }//End of class.
  }//End of main method.

         
         
