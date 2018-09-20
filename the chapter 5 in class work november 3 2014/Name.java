//Parth barot
//11/3/2014
//This is the program to enter the full name using a methos calle smy Name

import java.util.*;

public class Name
{
   public static void main(String[] args)
   {
      System.out.println("This prgoram will call method to ask you to enter your full name and then will");
      System.out.println("print your name in this method");
   
      myName();
   
      System.out.println("Back to the main method");
   }
   
   
   public static void myName()
   {
      String name;//This is the variable that stores the name
   
   
      Scanner keyboard = new Scanner (System.in);
      System.out.println("Now in mtName main method" );
      System.out.print("please enter your full name :  ");
      name = keyboard.nextLine();
   
      System.out.println("Your name is :" + name );
      System.out.println("leaving myName method");
   
   }//end of myname method
         



}//end of the main method.


//
/*
This program will going to work on the main method and then 
it will going to work on the new method which we defined in
our main method and then it will goind to work on our new methode 
and than it will go back to the main method and than it will stop the program.
*/
// 
