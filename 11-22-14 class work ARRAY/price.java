//Parth Barot
//Assignment 12 chapter 8 arrays
//problem #4


import java.util.*;
import java.io.*;

public class price
{//begining of main class
   public static void main(String[] args)
   {//beigining of the main method.
            
            
      int[]amount=new int[10]; //This will going to hold the object amount and hold 10 arrays
      double[]price=new double [10];//This will going to hold the object amount and hold 10 arrays values
       double[]total=new double[10];//This will going to hold the object total and hold 10 arrays values

      //Created a scanner object for keyboard object
      Scanner keyboard = new Scanner(System.in);

       //This is will print the guidline of the program               
      System.out.println("program that specifies three dimensional arrays");
                        
       //Get the total amount and price from the user     
      for (int i=0; i <amount.length; i++)
      {
      System.out.print("Enter score #" + (i+1)+ " : ");
      amount[i] = keyboard.nextInt();
      System.out.print("Enter the price " + (i+1) + " : ");
         price[i] = keyboard.nextDouble();

        total[i] = price[i]*amount[i];
        
       }  
        //This will going to print  total, amount and price in output.
        System.out.println(" "+ " Total  Amount   price");
         System.out.println(""+" =====   =====    ======");
        
         //Print out the total, amount and price in the output.
         for(int i=0; i<price.length;i++)
         {
                  
         System.out.printf("%5.2f" ,total[i]);
         System.out.printf( "%7d" ,amount[i]);
         System.out.printf("%11.2f" , price [i]);
         System.out.println();
         }      
        
         
                  
         }//end of main method
         }//end of class