//Parth  Barot
//9/29/2014
//Assignment 7 #3 A

import java.util.Scanner;     //Needed for Scanner class.

public class RomanNumerals
{
   public static void main (String [] args)
   {
      int number;
      String romannumerals;
      
   //Create a scanner object for keyboard input
      Scanner keyboard = new Scanner (System.in);

      
   //Get the number from the user
      System.out.println("Enter a number in the " +
                     "range of 1-10: " );
   //user input number
       number = keyboard.nextInt();

   
     
          

         switch (number)
          {
            case 1:
               System.out.println( "When you enter the number = 1 , you will get roman numeral = I");
               break;

            case 2:
               System.out.println( "When you enter the number = 2 , you will get roman numeral = II");
               break;

            case 3:
               System.out.println( "When you enter the number = 3 , you will get roman numeral =III ");
              break;

            case 4:
               System.out.println( "When you enter the number = 4 , you will get roman numeral = IV");
               break;
               
            case 5:
               System.out.println( "When you enter the number = 5 , you will get roman numeral = V");
               break;
               
            case 6:
               System.out.println( "When you enter the number = 6 , you will get roman numeral = VI");
               break;
            case 7:
               System.out.println( "When you enter the number = 7 , you will get roman numeral = VII");
               break;
               
            case 8:
               System.out.println( "When you enter the number = 8 , you will get roman numeral = VIII");
               break;
               
            case 9:
               System.out.println( "When you enter the number = 9 , you will get roman numeral = IX");
              break;

            case 10:
               System.out.println( "When you enter the number = 10 , you will get roman numeral = X");
               break;
               
            default:
               System.out.println( "When you enter the number > 10 , you will get roman numeral = Invalid number.");
               break;
         }
      }
   }
