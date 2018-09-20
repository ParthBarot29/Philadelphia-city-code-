//Parth Barot
//Chapter 4 lab Bowling assignment
//10/26/2014


import java.util.Scanner;
import java.text.DecimalFormat;

public class BowlingAssignment
{
   public static void main(String[] args)
   {
      double playerTotal = 0; //The total scores for each player
      double teamTotal = 0;   //The total scores for all players and games.
      double score = 0;       //Stores input for scores.
           
    //Scanner object for keyboard.
      Scanner keyboard = new Scanner(System.in);
      //Decimal format object for double number.
      DecimalFormat formatter = new DecimalFormat("#0.00");
           
      for (int player = 1; player<= 5; player++)    //5 loops for each player.
      {
         for (int game = 1; game<= 3; game++)      //3 loops for each game.
         {
            System.out.print("Enter score for player no. "  + player + " In game no. " + game + " : ");
            score = keyboard.nextDouble();
              
            if (score <= -1 || score > 300)
            { 
               System.out.print(" Please enter a number between 0 and 300 , both included. " );
              
               game --;
            }
            else
            {
               playerTotal += score;
            }
         }
         System.out.println(" Average score for player no. " + formatter.format(player) + " is " + formatter.format (playerTotal/3));
         teamTotal += playerTotal;
         playerTotal = 0;
      }
        
      System.out.println("Team's score for all three matches is " + formatter.format (teamTotal ));
        
   }//End of the main mathod
       
}//End of the class
        



