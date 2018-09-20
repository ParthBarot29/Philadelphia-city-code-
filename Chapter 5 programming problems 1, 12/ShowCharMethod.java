//Parth Barot
//11/8/2014
//Chapter 5 Programming Challenges # 1

//
/*
 this program methodshowChar is accepting two arguments
" String and int ". The int arguments going to display the 
character position of the string argument.
*/
//
import java.util.*;

public class ShowCharMethod
{
// main method
public static void main(String [] args)
   {
      //String data tyoe to hold the city name object.
      String city;
      int number = 0 ;
      int stringSize;
      
      
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println (" this program methodshowChar is accepting two arguments"
                           + " String and int . The int arguments going to display the" 
                             +" character position of the string argument.");

      System.out.println("Plese enter   name " );
      city = keyboard.nextLine();
      stringSize = city.length();
      System.out.println(stringSize);
      System.out.println(" Plese enter the position value ");
      number = keyboard.nextInt(); 
      
      while(number <1 || number >stringSize)
     { System.out.print("The number need to be between 1 and " + stringSize + " Please enter it again" );
       number = keyboard.nextInt();
         }   
      //Call to  methodshowchar .
      methodshowChar(city, number);
   
 
     }//end of the main method
  
  //methodshowchar method.
   public static void methodshowChar(String city, int num)
   {
      char letter =city.charAt(num-1);
      System.out.println("The character is in position " + num + " of the string " + city + " would be " + letter);
   
   }//end of the method showchar.
   
   }
    