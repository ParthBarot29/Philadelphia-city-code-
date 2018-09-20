//Parth Barot
//Lab 4
//6/18/2015

import java.util.*;

public class Pet{

   public static void main(String [] args){
   //Data Dictionary
   
   Pet1 myPet = new Pet1();
   int buffer =0; //decalring buffer as integer.
   String buffer1= "";
   String menu = "(-1) quit, (1) setName , (2)setAnimal, (3)setAge";
   
   menu += "\n (4) getName , (5) getAnimal (6) gerAge : ";   
      Scanner kbd = new Scanner(System.in);// Creating new scanner object into main meathod.
   
      do{
      System.out.print(menu);
      buffer =kbd.nextInt();
      if(buffer == -1)break;
     
      if (buffer ==1)   {
         
         System.out.print("Enter the pet name : ");
         myPet.setName(kbd.next());
       }
       
       if(buffer == 2){
         System.out.println("Enter  set Animal type : ");
         myPet.setAnimal(kbd.next());
       
       }
       if (buffer == 3) {
         System.out.print("Enter the pet age : ");
         myPet.setAge(kbd.nextShort());
       
       }
      if (buffer == 4){
         System.out.println(myPet.getName());
      }
      
      if(buffer == 5) {
         System.out.println(myPet.getAnimal());
      }  
      if (buffer == 6) {
         System.out.println(myPet.getAge());
      
      }
         
      
      
      }while(buffer != -1);
   }
}
class Pet1{ //Creating new pet1 class to set name , animal, age
   
  private String name = "";
  private String animal = "";
  private short age = 0;


   public void setName(String n){
      name = n;
      
   }
   public void setAnimal(String n){
      animal = n;
   
   }
   public void setAge(short i){
      age = i;
   }
   
  public String getName(){
      return name;
 } 
 
  
  public String getAnimal(){
      return animal;
 }
 
 public short getAge(){
      return age;
 }
   
  
   
}