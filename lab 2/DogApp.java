//Parth Barot
//6/9/2015
//LAB 2(Computer Science I)

/*
purpose = prompt user for dog names store thease with p in a txt file
input = several strings prompted one after another
Processing = do while loop to accept text until a sentinel value is entered.
output = text file potentially storing many line of text. 
**/

import java.io.*;
import java.util.*;


public class DogApp{

  public static void main (String [] args) throws Exception{
   //Data dictionary
   
   
   String buffer = "";
   
   Scanner kbd = new Scanner (System.in);
   PrintWriter outputFile = new PrintWriter("dogname.txt");
   
      do{
           System.out.print("Enter a dog name: ");
           buffer = kbd.next();
           if( buffer.charAt(0) =='P' || buffer.charAt(0) == 'p');
           outputFile.print(buffer);
      }while(buffer.charAt(0) != '0');
          outputFile.close();
      }
 
 }