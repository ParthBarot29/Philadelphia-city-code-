//Parth Barot
//Class work 10/22/14
//Demo to show reading from  a file.

import java.util.*;  //import needed for scanner class
import java.io.*; // import needed for Filke input and output


public class ReadFromFile2
{//beginning of class

   public static void main(String[] args) throws IOException
   {//begining of main
      
      String names;   //names of friends
      String fileName;// name of file to be enbtered by user will write to the file
         
         
         //Create a scanner object to allow input from the keybaord
                
      Scanner keyboard = new Scanner(System.in);
        
        //Ask the user to enter the file name
      System.out.print("Enter the name of file you would like to read data from:" );
      fileName = keyboard.nextLine();
               
        //open the file
      File fn = new File (fileName);
      Scanner inputFile = new Scanner (fn);
         
         
                 
        //read  alllines from the file
      while (inputFile.hasNext())
      {//beginning of loop
        
        //read the next name from the file
         names = inputFile.nextLine();
        
        //display lines read from file
         System.out.print(names);
      }//end of loop 
        
        
       
        
         //Close the file 
      inputFile.close();
                
   }//end of main
}//end of class
         

