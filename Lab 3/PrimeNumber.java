//Parth Barot
//6/16/15
// lab 3 


//purpose: build a formulae function method.
//input:  input the numbers of whether or not if the numbers are prime numbers.
//processing:  calculate the number of being prime or not prime.
//output: display the output numbers of the integers by using the Println output file.




import java.util.*;

public class PrimeNumber{

   public static void main (String []args){
   //data dictionary
      Scanner kbd = new Scanner(System.in);
      int buffer = 0;
      System.out.println("This program is a number convertor");
      System.out.println("input integer greater than or equal to 1 ");
      System.out.println("Enter -1 to quit");
   
      do{
         System.out.println(" Enter a nmumber to test for printing");
         buffer =kbd.nextInt();
         if (isPrime(buffer))  {
            System.out.println( buffer + " is prime");
         }
         else {
            System.out.println(buffer + "is not a prime");
         }
      }while(buffer != -1);
   
   }
   
   public static boolean isPrime(int i){
      if(i ==1 ) 
         return true;
      if (i==2) 
         return true;
      if (i % 2==0)
         return false;
      for( int j= 3;j < i ; j = j+2){
         if(i % j == 0)  {
            return false;
         }
      }
      return true;
   }
}