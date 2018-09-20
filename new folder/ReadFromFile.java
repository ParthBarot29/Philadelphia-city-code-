//Parth Barot
//Class work 10/22/14
//Demo to show reading from  a file.

import java.util.*;  //import needed for scanner class
import java.io.*; // import needed for Filke input and output


public class ReadFromFile
{//beginning of class

   public static void main(String[] args) throws IOException
      {//begining of main
      
         String line;    //first line to be read from file
         String names;   //names of friends
         String fileName;// name of file to be enbtered by user will write to the file
         
         
         //Create a scanner object to allow input from the keybaord
                
        
               
        //open the file
         File fn = new File("friends.txt");
         Scanner inputFile = new Scanner (fn);
         
         
                 
        //read first line from the file
        line = inputFile.nextLine();
        
        //display lines read from file
        System.out.print("The first line in the file is : ");
        System.out.print(line); 
        
        
        //Enter the name and write to file
        
                //Close the file 
        inputFile.close();
                
        }//end of main
      }//end of class
         

