//Parth Barot
// 9 11 14
//Programming Challenges problem 1.

import java.util.Scanner;

public class Variable
{
   public static void main(String[]args)
   {
      String name;
      int age;
      double annualpay;
      
      Scanner keyboard = new Scanner(System.in);
      
      System.out.print("what is your name : ");
      name = keyboard.nextLine();
      
      System.out.print("what is your age: ");
      age = keyboard.nextInt();
      
      System.out.print ("what will be your future earning peryear: ");
      annualpay = keyboard.nextDouble();
      
      System.out.println(" My name is " + name + " , my age is " + age + " and I hope to earn $ " + annualpay + " per year . ");
        
   }
     
}
    
