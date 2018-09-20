//PARTH BAROt
// 9 17 14
// Class work
//Chapter 2 problem 10

import javax.swing.JOptionPane;

public class TestAverage
{
   public static void main(String[] args)
   {
   
      String firsttest, secondtest, thirdtest;
      double firsttestone; //first test
      double secondtestone;   //secondtest
      double thirdtestone;    //third test
      double score;
   
   //Get the first test
      firsttest = JOptionPane.showInputDialog ("What is your first test score ");
   
   //Get the second test
      secondtest = JOptionPane.showInputDialog ("What is your second test score ");
   
   //Get the third test 
      thirdtest = JOptionPane.showInputDialog ("What is your third test score ");
      
   //conver the input to a double.
      firsttestone = Double.parseDouble(firsttest);
      secondtestone = Double.parseDouble(secondtest);
      thirdtestone = Double.parseDouble (thirdtest);
      
   //calculate the test score
      score = (int) ((firsttestone+secondtestone+thirdtestone)/3); 
   
   //Display the results.
      JOptionPane.showMessageDialog(null, " Test scores average = "  +  score); 
   
   //end of the program.
      System.exit(0);
   
   }
}