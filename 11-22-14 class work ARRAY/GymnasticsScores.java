/*
Parth Barot
11/24/14
Assignment  # 12 chapter 8 arrays
problem 3 

*/

/*
This program will goind ask the user to enter indiviual gymnastics scores and 
calculates the final scores
*/

import java.util.*;
import java.lang.*;

public class GymnasticsScores{

   public static void main (String[]args)
   {
   
   //declare the variables   
      double sum = 0.0;
      double highestScore = 0.0;
      double lowestScore = 10.0;
   
      Scanner keyboard = new Scanner (System.in);
      
      System.out.println("This program will goind ask the user"+
       " to enter indiviual gymnastics scores and" +
       " calculates the final scores ");

   
   //Ask the user to enter the 8 judges scores
      System.out.print("Enter the eight juges scores (separated by commas) : ");
      String[]userInput=keyboard.nextLine().split(",");
   
   
    // put the string of scores into the scores array
    // and get the highest and lowest scores
      double[] scores =new double [userInput.length];
   
      for (int index = 0; index < userInput.length; index++)
      {
         scores[index] = Double.parseDouble(userInput[index]);
         sum += scores[index];
      
         if (scores[index] == 0.0)
         {
         }
         if (scores[index]>highestScore){
            highestScore = scores[index];
         }
         if (scores[index]<lowestScore && scores[index]>0.0){
            lowestScore = scores[index];
         }
      }
      
      //print the final scores
      System.out.println("Highest score: " + highestScore);
      System.out.println("Lowest score : " + lowestScore);
      System.out.println("Final score : "+ (sum - highestScore - lowestScore)); 
      
   }//end of main
}//end of gymnasticsScores class
