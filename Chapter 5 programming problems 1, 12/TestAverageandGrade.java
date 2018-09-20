//Parth 2arot
//chapter 5 lab 1ssignment 10
//programming challenges #1
//10/26/2014

/**

This program will going to calculate the five test averages and show it in  the output

**/

import java.util.*;



public class TestAverageandGrade
{
//main method
   public static void main(String [] args )
   {
      double testscore1, testscore2, testscore3, testscore4, testscore5, average; //To hold the object testscore 1, 2, 3, 4, 5, and test average.
      char grade;// to hold alphabetic grade latter.
      String input; // to hold string input.

     //created scanner keyboard object
      Scanner keyboard = new Scanner(System.in);
      
      // Print the status of progam , what this progam will do . 
   System.out.println("This program will going to calculate the five test averages"
                     + " and it will show your grade in  the output.");



   	do{
      System.out.println("Please enter the first test score 1 " );
      input = keyboard.nextLine();
		testscore1 = Integer.parseInt(input);
		}while ((testscore1 <= 0 ) || (testscore1 > 100));

		do{
      System.out.println("Please enter the second test score 2 " );
      input = keyboard.nextLine();
		testscore2 = Integer.parseInt(input);
		}while ((testscore2 <= 0 ) || (testscore2 > 100));


       do{
      System.out.println("Please enter the third test score 3 " );
      input = keyboard.nextLine();
		testscore3 = Integer.parseInt(input);
		}while ((testscore3 <= 0 ) || (testscore3 > 100));


      do{
      System.out.println("Please enter the forth test score 4 " );
      input = keyboard.nextLine();
		testscore4 = Integer.parseInt(input);
		}while ((testscore4 <= 0 ) || (testscore4 > 100));


      do{
      System.out.println("Please enter the fifth test score 5 " );
      input= keyboard.nextLine();
		testscore5 = Integer.parseInt(input);
		}while ((testscore5 <= 0 ) || (testscore5 > 100));

      // Call to method calcAverage and output the 5 test average
      average = calcaverage(testscore1,  testscore2,  testscore3,  testscore4,  testscore5);
      System.out.println("The average of the 5 tests is: " + average);

      //call to the method determineGrade.
      System.out.print("The average grade is: ");
      determineGrade (average);


   }
//created new calcaverage method to calculate the five test score average.
   public static double calcaverage(double testscore1, double testscore2, double testscore3, double testscore4, double testscore5)

   {

//calculate the 5 test scores.
      double average = ((testscore1 + testscore2 + testscore3 +testscore4 + testscore5)/5);
      return average;
   }
   //created determineGrade method to print grade.
      public static double determineGrade(double average)

   {

      char grade;


      if (average>=90)

      { grade = 'A';
      System.out.print(grade + "\n");
       }

        else if (average>=80)

      {grade = 'B';
      System.out.print(grade + "\n");
      }
      else if (average>=70)

      {
      grade = 'C';
      System.out.print(grade + "\n");
      }
       else if (average>=60)

      {
      grade = 'D';
      System.out.print(grade + "\n");
      }
      else if (average<60)
       {
      grade = 'F';
      System.out.print(grade + "\n");
      }
      else
      {
      System.out.println("error\n");

      }
      return 0;

   }
}

























