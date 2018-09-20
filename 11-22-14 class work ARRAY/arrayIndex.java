//parth barot
//Assignment 12 chapter 8 array
//11/19/2014



/* 
This program will going to do the square of first 1 to 25 numbers and it will going to cube the 26 to the 49 numberes.
*/
import java.util.*;

public class arrayIndex
{//begining of the class
   public static void main(String[] args)
   {//beging of the main method
   
   System.out.println(" This program will going to print square and cube of the numbers");
   
      double[]alpha; //This will hold the object of alpha
      alpha =  new double[50];//This will define the 50 location in alpha
      int index;//This will going to hold the index
      
      //count until the 24 and multiply the size declaration to size declaration
      for ( index = 0; index<25 ; index++)
         alpha[index]=index*index;
      
      //Accept the 49 location and multiply size declaration with 3
      for ( index = 25; index<50; index++)
      {
         alpha[index]=index*3;     
      }
      //print the statement with the comma.
      for (index = 0 ;index<alpha.length;index++){
      
         System.out.print(alpha[index] + " , ");
         
         if ((index<48 )&& (alpha[index+1]%10==0))
            System.out.print("\n");
      }
   }
}
      

      

            


















