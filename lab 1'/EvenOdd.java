/* Parth Barot
6/4/2015
lab 1
**/



/*
Purpose = Check integer as odd or even
Input = the program will accept the integer number from the user.
Processing = use modilis to determine thte statis of integer, use if/else to determine output, and system.out.print to deliver output.
Output = text to console informing user ot even or odd. 

*/
import java.util.*;

public class EvenOdd // Main class  
{
   public static void main(String [] args){
   
      int bufferint; 
      String result;
     
      
      Scanner keyboard = new Scanner(System.in);//creating new scanner object in the main method
      
      System.out.println("Please enter the number to check if number is even or odd");
      bufferint = keyboard.nextInt();
      
      if(bufferint %2 ==0)
         result = "Even";
         
      else
         result = "Odd";
         
         System.out.print(result);// Print the odd and even number into output console
           
   
   }



}