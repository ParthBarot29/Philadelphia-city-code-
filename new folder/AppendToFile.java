//Parth Barot
//Class work 10/22/14
//Demo to show Appending to a file the program write a data to the end of  a file

import java.util.*;  //import needed for scanner class
import java.io.*; // import needed for Filke input and output


public class AppendToFile
{//beginning of class

   public static void main(String[] args) throws IOException
   {//begining of main
      
      int numFriends; // number of friends
      String names;   //names of friends
      String fileName;// name of file to be enbtered by user will write to the file
         
         
         //Create a scanner object to allow input from the keybaord
      Scanner keyboard = new Scanner (System.in);
        
        
        //User must enter number of people to be entered into the file
      System.out.println("Enter the number of friends you would like  add to the file : " );
      numFriends = keyboard.nextInt();
         
         
        //consume the extra new line character
      keyboard.nextLine();
        
        //Create a FileWriter object so that we can opern the file and  add to it
      FileWriter fw = new FileWriter("friends.txt", true);        
        //open the file 
      PrintWriter outputFile = new PrintWriter(fw);
        
        //Enter the name and write to file
        
      for (int i = 1; i <= numFriends; i++){
        //beginning of loop
        
         System.out.print("Enter the name of friends number " + i +" : " );
         names = keyboard.nextLine();
        
        //Write name to file
         outputFile.println(fw);
        
      } //End of the loop 
        
        //Close the file 
      outputFile.close();
      System.out.print("The data has been added to the file and the file has been closed ");
        
   }//end of main
}//end of class
         

