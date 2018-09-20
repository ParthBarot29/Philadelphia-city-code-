/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driverclass;

/**
 *
 * @author barot
 */
public class DriverClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        User us=new  User("JOHN", " CENA ",new CheckingAccount());
		    System.out.println(us);
		    
		    User us2=new  User("riley", " rossow ",new VacationAccount());
		    System.out.println(us2);
		    
		    
		    User us3=new  User("cristiano", " Ronaldo  ",new SavingAccount());
		    System.out.println(us3);
    }
    
}
