//parth barot
//Assignment 12 chapter 8 array
//11/19/2014



/* 
This program will going to do the square of first 1 to 25 numbers and it will going to cube the 26 to the 49 numberes.
*/
import java.util.*;

public class arrayIndex
{
   public static void main(String[] args)
   {
      double[]alpha; 
      alpha =  new double[50];
      int index;
      
      for ( index = 0; index<25 ; index++)
         alpha[index]=index*index;
      
      
      for ( index = 25; index<50; index++)
      {
         alpha[index]=index*index*index;     
      }
      for (index = 0 ;index<=49;index++){
         System.out.print(alpha[index] + " , ");
         if (alpha[index]%10==0)
            System.out.print("\n");
      }
   }
}
      

      

            


















