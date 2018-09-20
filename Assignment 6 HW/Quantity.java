//Parth Barot
//9/24/2014 
// Assignment 6 # 3 B

import java.util.Scanner;
 
public class Quantity
{
   public static void main(String[] args)
   {
      double quantity = 0 ;      // The number of Quantity
      double price = 99;         //The price
      double discount = 0;       // The discount
      double total= 0;           //the total
      double discountamount;     //the answer of discount amount
                            
       //Create a scanner object     
      Scanner keyboard = new Scanner(System.in);
            
       //Get the package purchase     
      System.out.print("Enter the number of packages purchased :");
      quantity = keyboard.nextDouble();
            
      if (quantity < 10)
      {  
         discount = 0.20;
      }  
      else if (quantity < 20)
      {
         discount = 0.30; 
      }
      else if (quantity < 50)
      {
         discount = 0.40;
      }        
      else if(quantity < 100)
      {
         discount =  0.50;
      }  
       
       //calculate PRICE * DISCOUNT * QUANTITY        
      discountamount = 99 * quantity * discount;
      
      //Calculate QUATITY * PRICE - DISCOUNT
      total = quantity * 99 - discountamount ;
              
       //DISPLAY DISCOUNT AND TOTAL                     
      System.out.println("The discount is " + discountamount + " and your total after a discount is $ " + total + " . " ); 
      
   }

}