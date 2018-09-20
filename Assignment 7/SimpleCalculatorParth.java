//Parth Barot
//9/24/2014 
// Assignment simple calculatorprogram

import java.util.*;
import java.math.*;
import java.lang.*;

public class SimpleCalculatorParth
{
   public static void main(String[] args)
   {
   
      int number1,number2;                   //declare an int variable number 1 and number 2
      String numberone, numbertwo,operator;  //declare string variable numberone , numbertwo, operator.
      char mathsigns;                        //declare character variable for nathsigns.
      double number1d, number2d, result = 0.0; //declare double variable for number1d, number2d and result.  
   
   //created a scanner object to read input.
      Scanner input = new Scanner (System.in);  
   
   //Get the user to enter a first number.
      System.out.println("Enter number 1. :");
      number1=input.nextInt();
   
   //Get the user to enter a second number.
      System.out.println("Enter number 2. :");
      number2 =input.nextInt();
   
      numberone = " ";
   //Switch statement for first number to translate from integer to string.
      
      switch (number1){
         case 0 : numberone = "Zero";
            break;
         case 1 : numberone = "One";
            break;
         case 2 : numberone = "Two";
            break;
         case 3 : numberone = "Three";
            break;
         case 4 : numberone = "Four";
            break;
         case 5 : numberone = "Five";
            break;
         case 6 : numberone = "Six";
            break;
         case 7 : numberone = "Seven";
            break;
         case 8 : numberone = "Eight";
            break;
         case 9 : numberone = "Nine";
            break;
         default:
            System.out.println ("The first number need to be between 0  to 9 ");
      }
   
      numbertwo = " ";
      
   //Switch statement second number to translate from integer to string.
      switch (number2){
         case 0 :  numbertwo = "Zero";
            break;
         case 1 :  numbertwo = "One";
            break;
         case 2 :  numbertwo = "Two";
            break;
         case 3 :  numbertwo = "Three";
            break;
         case 4 :  numbertwo = "Four";
            break;
         case 5 :  numbertwo = "Five";
            break;
         case 6 :  numbertwo = "Six";
            break;
         case 7 :  numbertwo = "Seven";
            break;
         case 8 :  numbertwo = "Eight";
            break;
         case 9 :  numbertwo = "Nine";
            break;
         default:
            System.out.println ("The second number need to be between 0  to 9 ");
      }
     
    // The user can only enter a number between 1 to 9.
      if (number1 <0 || number1 >9 || number2 < 0 || number2 > 9)
         System.out.println (" The number needs to be between 1 to 9");
      if (number1>0 && number1<9 && number2>0 && number2<9)
      
      {//Output statement for operator which will be entered by user.
         System.out.println("Choose your operator:+,-,*,/,^");
         operator=input.nextLine();
         operator=input.nextLine();
      
         mathsigns = operator.charAt(0);
      
      //Switch statement for math calculation.   
         switch(mathsigns){
            case '+' :
               { operator = "plus";
                  result = number1 + number2;
                  System.out.println( numberone + " " + operator + " " + numbertwo + " is " + result);
                  break;}
            case '-' :
               { operator = "minus";
                  result = number1 - number2;
                  System.out.println( numberone + " " + operator + " " + numbertwo + " is " + result);
               
                  break;}
            case '*' :
               { operator = "multiplied by";
                  result = number1 * number2;
                  System.out.println( numberone + " " + operator + " " + numbertwo + " is " + result);
               
                  break;}
            case '/' : operator = "divided by";
               if (number2 != 0) 
               {result = number1 / number2;
                  System.out.println( numberone + " " + operator + " " + numbertwo + " is " + result);}
               else
                  System.out.println ("number can't be divided by zero so please plug number between 1 to 9");
               break;
            case '^' :
               { operator = "the power of";
                  number1d = (double)number1;
                  number2d = (double)number2;
                  result = Math.pow ( number1d , number2d);
                  System.out.println( numberone + " " + operator + " " + numbertwo + " is " + result);
               
                  break;}
            default:
               System.out.println("operator is unidentify please enter the +,-,*,/,^");
            
               System.out.println("you entered a wrong number so this is an invalid operation ");}
      
      
      }   //end of switch statement.                   
       
   }//End of main method.
 
}//End of class.
 

