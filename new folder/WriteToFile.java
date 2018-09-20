//Parth Barot
//Class work 10/22/14
//Demo to show creating a file the program write a data to a file

import java.util.*;  //import needed for scanner class
import java.io.*; // import needed for Filke input and output


public class WriteToFile
{//beginning of class

   public static void main(String[] args) throws IOException
   {//begining of main
      
      int numFriends; // number of friends
      String names;   //names of friends
      String fileName;// name of file to be enbtered by user will write to the file
         
         
         //Create a scanner object to allow input from the keybaord
      Scanner keyboard = new Scanner (System.in);
        
        
        //User must enter number of people to be entered into the file
      System.out.println("Enter the number of friends you would like to enter : " );
      numFriends = keyboard.nextInt();
         
         
        //consume the extra new line character
      keyboard.nextLine();
        
        //Ask user for file name
      System.out.print("please enter the name of file to be created to hold friends name: ");
      fileName = keyboard.nextLine();
        
        
        //open the file 
      PrintWriter outputFile = new PrintWriter(fileName);
        
        //Enter the name and write to file
        
      for (int i = 1; i <= numFriends; i++){
        //beginning of loop
        
         System.out.print("Enter the name of friends number " + i +" : " );
         names = keyboard.nextLine();
        
        //Write name to file
         outputFile.println(names);
        
      } //End of the loop 
        
        //Close the file 
      outputFile.close();
      System.out.print("The data has been written to the file and the file has been closed ");
        
   }//end of main
}//end of class
         

