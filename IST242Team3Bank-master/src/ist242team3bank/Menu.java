/*
Author DJP5566
 */
package ist242team3bank;

import java.util.Scanner;

public class Menu {

    Scanner _keyboard = new Scanner(System.in);

    public static void main(String[] args) {
    } 
    //Choose Activity Method
    public int chooseActivity() {
        int chooseActivity = 0;
        do {
            //Display Menu
            System.out.println("============================");
            System.out.println("0. Quit");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check balance");
            System.out.println("4. Transfer");
            System.out.println("5. Report Transaction History");
            System.out.print("Enter your activity choice: "); //User makes Choice
            String lineInput = _keyboard.nextLine();
            chooseActivity = Integer.parseInt(lineInput); // Choice is passed to keyboard
        } while (!(chooseActivity >= 0) || !(chooseActivity <= 5)); // Display menu while the user input is not valid
        return chooseActivity; // Choice is returned
    }

    // Choose account method
    public int chooseAccountTransfer() {
        int chooseAccountTransfer = 0;
        do {
            //Display Accounts
            System.out.println("============================");
            System.out.println("1. Checking");
            System.out.println("2. Savings");
            System.out.println("3. Vacation");
            System.out.print("Enter your account choice: "); //User Makes Choice
            String lineInput = _keyboard.nextLine();
            chooseAccountTransfer = Integer.parseInt(lineInput); //Choice is passed to keyboard
        } while (!(chooseAccountTransfer >= 1) || !(chooseAccountTransfer <= 5));// Display menu while the user input is not valid
        return chooseAccountTransfer; // Choice is returned
    }

}

