// Parth Barot
//9/15/14
// Class work

import javax.swing.JOptionPane;


public class NameAndAgeJO
{ 
   public static void main(String[] args)
   {
   
      String name, age;
      int ageNum;
      
      //read name from keyboard input
      name = JOptionPane.showInputDialog("What is your name?");
      
      //read age from keyboard age is a string
      age = JOptionPane.showInputDialog(" Please enter your age "); 
           
      // parse age so that is an integer
      ageNum=Integer.parseInt(age);
      
      //Display the information
      JOptionPane.showMessageDialog (null,"your name is " +name + "and your age" +ageNum + "years old.");     
      
      System.exit(0);
   }
      
}