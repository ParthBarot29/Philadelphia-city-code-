package ist242team3bank;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

//Author jvf5264
public class User {

    private String _firstName;
    private String _lastName;
    private int id;
    private Account typeReference;
    public Account checkingAccount, savingsAccount, vacationAccount;
    //Transaction trans = new Transaction();

    public static void main(String[] args) {
        User user = new User("Jahura", "Ferdous");
        System.out.println("The user: " + user.output());

        System.out.println("Balances");
        System.out.println("Checking: $" + user.getChecking().getBalance());
        System.out.println("Savings: $" + user.getSavings().getBalance());
        System.out.println("Vacation: $" + user.getVacation().getBalance());
    }

    //Simple constructor
    public User() {
        checkingAccount = new Account();
        savingsAccount = new Account();
        vacationAccount = new Account();
    }

    //Constructor that takes initialize first name, last name
    public User(String firstName, String lastName) {
        firstName = firstName;
        lastName = lastName;
        checkingAccount = new Account();
        savingsAccount = new Account();
        vacationAccount = new Account();
    }

    //Constructor that takes initialize first name, last name and typeReference
    public User(String firstName, String lastName, Account ac) {
        firstName = firstName;
        lastName = lastName;
        typeReference = ac;

        checkingAccount = new Account();
        savingsAccount = new Account();
        vacationAccount = new Account();

        //Set id to a random number from 1 to 1000
        id = (int) (Math.random() * 10000 + 1);
    }

    public String getFirstName() {
        return _firstName;
    }

    public Account getChecking() {
        return checkingAccount;
    }

    public Account getSavings() {
        return savingsAccount;
    }

    public Account getVacation() {
        return vacationAccount;
    }

    public void setFirstName(String firstName) {
        this._firstName = firstName;
    }

    public Account GetType() //public string caused error here so i changed it to account
    {
        return typeReference;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        this._lastName = lastName;
    }

    public String toString() {
        return "\nFirstName =" + _firstName + "\nLastName=" + _lastName + "\nID=" + Integer.toString(id);
    }

    public String output() {
        return _firstName + " " + _lastName + " [" + id + "]";
    }

    public void promptName() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        _firstName = keyboard.nextLine();
        System.out.print("Enter your last name: ");
        _lastName = keyboard.nextLine();
    }
}
/*
 public void promptLastName() {    
 Scanner keyboard = new Scanner(System.in);
 System.out.print("Enter your last name: ");
 lastName = keyboard.nextLine();
 }*/
