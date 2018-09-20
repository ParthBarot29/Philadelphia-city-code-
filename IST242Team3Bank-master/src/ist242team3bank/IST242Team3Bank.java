package ist242team3bank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IST242Team3Bank {

    public static void main(String[] args) {
        //new user
        User user = new User();
        Helper helper = new Helper();

        Scanner sc = new Scanner(System.in);

        //double inputBalance;
        double savingsBalance;
        double checkingBalance;
        double vacationBalance;

        String firstName;
        String lastName;
        System.out.println("Enter new user");

        user.promptName(); // initiates User class

        firstName = user.getFirstName();
        lastName = user.getLastName();
        helper.inputNonBlankString(firstName, lastName); // inputNonBlankString validates name input

        //boolean promptUser = true;
        System.out.println("Enter balance for your savings account.");
        savingsBalance = helper.inputDecimal(); //inputDecimal validates double input
        user.savingsAccount.setBalance(savingsBalance);

        System.out.println("Enter balance for your checking account.");
        checkingBalance = helper.inputDecimal();
        user.checkingAccount.setBalance(checkingBalance);

        System.out.println("Enter balance for your vacation account.");
        vacationBalance = helper.inputDecimal();
        user.vacationAccount.setBalance(vacationBalance);

        Menu menu = new Menu();// Display menu
        int chooseActivity = -1;//Initiate Choose Activity 

        while (chooseActivity != 0) {
            String lineInput = "";
            double inputAmount = 0;
            chooseActivity = menu.chooseActivity();
            if (chooseActivity == 0) {
                System.out.println("Program has been terminated, have a nice day! ");//Option to quit menu
                break;
            }
            switch (chooseActivity) { // When the user chooses an option display what they choose

                case 1:
                    System.out.println("Activity choice is: Deposit");
                    break;
                case 2:
                    System.out.println("Activity choice is: Withdraw");
                    break;
                case 3:
                    System.out.println("Activity choice is: Check Balance");
                    break;
                case 4:
                    System.out.println("Activity choice is: Transfer");
                    break;
                case 5:
                    System.out.println("Activity choice is: Report Transaction History");
                    break;
            }
            // Start of activities for depositing, withdrawing, checking balance, transfer, transaction, 
            // =======================================================================================
            if (chooseActivity == 1 || chooseActivity == 2 || chooseActivity == 3 || chooseActivity == 4) {
                int accountChoice = menu.chooseAccountTransfer();// Initiate accountChoice
                int accountTransferChoice;
                switch (accountChoice) {// When the user chooses an option display what they choose
                    case 1:
                        System.out.println("Account choice: Checking");
                        if (chooseActivity == 1) {
                            System.out.printf("Checking balance before: $" + "%.2f", user.checkingAccount.getBalance());
                            System.out.println("");
                            System.out.print("Enter amount to deposit to your checking account: $");
                            inputAmount = sc.nextDouble();
                            user.checkingAccount.deposit(inputAmount);
                            System.out.printf("Checking balance after: $" + "%.2f", user.checkingAccount.getBalance());
                            System.out.println("");
                            break;
                        }
                        if (chooseActivity == 2) {
                            System.out.printf("Checking balance before: $" + "%.2f", user.checkingAccount.getBalance());
                            System.out.println("");
                            System.out.print("Enter amount to withdraw from your checking account: $");
                            inputAmount = sc.nextDouble();
                            user.checkingAccount.withdraw(inputAmount);
                            System.out.printf("Checking balance after: $" + "%.2f", user.checkingAccount.getBalance());
                            System.out.println("");
                            break;
                        }
                        if (chooseActivity == 3) {
                            System.out.printf("Balance for checking account currently is: $" + "%.2f", user.checkingAccount.getBalance());
                            System.out.println("");
                            break;
                        }
                        if (chooseActivity == 4) {
                            System.out.println("Transfer from checking to which account?");
                            int chooseAccountTransfer = 0;
                            do {
                                //Display Accounts
                                System.out.println("1. Savings");
                                System.out.println("2. Vacation");
                                System.out.print("Enter your account choice: "); //User Makes Choice
                                lineInput = sc.nextLine();
                                try {
                                    chooseAccountTransfer = Integer.parseInt(lineInput); //Choice is passed to keyboard
                                } catch (NumberFormatException ex) {
                                    System.out.println("Not a number");
                                }
                            } while (!(chooseAccountTransfer >= 1) || !(chooseAccountTransfer <= 2));// Display menu while the user input is not valid
                            accountTransferChoice = chooseAccountTransfer;
                            switch (accountTransferChoice) {
                                case 1:
                                    System.out.println("============================");
                                    System.out.printf("Checking balance before: $" + "%.2f", user.checkingAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Savings balance before: $" + "%.2f", user.savingsAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Vacation balance before: $" + "%.2f", user.vacationAccount.getBalance());
                                    System.out.println("");
                                    System.out.println("============================");
                                    System.out.print("Enter amount to transfer from checking to savings: $");
                                    inputAmount = sc.nextDouble();
                                    user.checkingAccount.transfer(user.checkingAccount, user.savingsAccount, inputAmount);
                                    System.out.println("============================");
                                    System.out.printf("Checking balance before: $" + "%.2f", user.checkingAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Savings balance after: $" + "%.2f", user.savingsAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Vacation balance after: $" + "%.2f", user.vacationAccount.getBalance());
                                    System.out.println("");
                                    System.out.println("============================");
                                    break;
                                case 2:
                                    System.out.println("============================");
                                    System.out.printf("Checking balance before: $" + "%.2f", user.checkingAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Savings balance before: $" + "%.2f", user.savingsAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Vacation balance before: $" + "%.2f", user.vacationAccount.getBalance());
                                    System.out.println("");
                                    System.out.println("============================");
                                    System.out.print("Enter amount to transfer from checking to vacation: $");
                                    inputAmount = sc.nextDouble();
                                    user.checkingAccount.transfer(user.checkingAccount, user.vacationAccount, inputAmount);
                                    System.out.println("============================");
                                    System.out.printf("Checking balance after: $" + "%.2f", user.checkingAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Savings balance after: $" + "%.2f", user.savingsAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Vacation balance after: $" + "%.2f", user.vacationAccount.getBalance());
                                    System.out.println("");
                                    System.out.println("============================");
                                    break;
                            }
                            break;
                        }

                    case 2:
                        System.out.println("Account choice: Savings");
                        if (chooseActivity == 1) {
                            System.out.printf("Savings balance before: $" + "%.2f", user.savingsAccount.getBalance());
                            System.out.println("");
                            System.out.print("Enter amount to deposit to your savings account: $");
                            inputAmount = sc.nextDouble();
                            user.savingsAccount.deposit(inputAmount);
                            System.out.printf("Savings balance after: $" + "%.2f", user.savingsAccount.getBalance());
                            System.out.println("");
                            break;
                        }
                        if (chooseActivity == 2) {
                            System.out.printf("Savings balance before: $" + "%.2f", user.savingsAccount.getBalance());
                            System.out.println("");
                            System.out.print("Enter amount to withdraw from your savings account: $");
                            inputAmount = sc.nextDouble();
                            user.savingsAccount.withdraw(inputAmount);
                            System.out.printf("Savings balance after: $" + "%.2f", user.savingsAccount.getBalance());
                            System.out.println("");
                            break;
                        }
                        if (chooseActivity == 3) {
                            System.out.printf("Balance for savings account currently is: $" + "%.2f", user.savingsAccount.getBalance());
                            System.out.println("");
                            break;
                        }

                        if (chooseActivity == 4) {
                            System.out.println("Transfer from savings to which account?");
                            int chooseAccountTransfer = 0;
                            do {
                                //Display Accounts
                                System.out.println("1. Checking");
                                System.out.println("2. Vacation");
                                System.out.print("Enter your account choice: "); //User Makes Choice
                                lineInput = sc.nextLine();
                                try {
                                    chooseAccountTransfer = Integer.parseInt(lineInput); //Choice is passed to keyboard
                                } catch (NumberFormatException ex) {
                                    System.out.println("Not a number");
                                }
                            } while (!(chooseAccountTransfer >= 1) || !(chooseAccountTransfer <= 2));// Display menu while the user input is not valid
                            accountTransferChoice = chooseAccountTransfer;
                            switch (accountTransferChoice) {
                                case 1:
                                    System.out.println("============================");
                                    System.out.printf("Checking balance before: $" + "%.2f", user.checkingAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Savings balance before: $" + "%.2f", user.savingsAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Vacation balance before: $" + "%.2f", user.vacationAccount.getBalance());
                                    System.out.println("");
                                    System.out.println("============================");
                                    System.out.print("Enter amount to transfer from savings to checking: $");

                                    inputAmount = sc.nextDouble();
                                    user.vacationAccount.transfer(user.vacationAccount, user.savingsAccount, inputAmount);
                                    System.out.println("============================");
                                    System.out.printf("Checking balance after: $" + "%.2f", user.checkingAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Savings balance after: $" + "%.2f", user.savingsAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Vacation balance after: $" + "%.2f", user.vacationAccount.getBalance());
                                    System.out.println("");
                                    System.out.println("============================");
                                    break;
                                case 2:
                                    System.out.println("============================");
                                    System.out.printf("Checking balance before: $" + "%.2f", user.checkingAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Savings balance before: $" + "%.2f", user.savingsAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Vacation balance before: $" + "%.2f", user.vacationAccount.getBalance());
                                    System.out.println("");
                                    System.out.println("============================");
                                    System.out.print("Enter amount to transfer from savings to vacation: $");
                                    inputAmount = sc.nextDouble();
                                    user.vacationAccount.transfer(user.vacationAccount, user.savingsAccount, inputAmount);
                                    System.out.println("============================");
                                    System.out.printf("Checking balance after: $" + "%.2f", user.checkingAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Savings balance after: $" + "%.2f", user.savingsAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Vacation balance after: $" + "%.2f", user.vacationAccount.getBalance());
                                    System.out.println("");
                                    System.out.println("============================");
                                    break;
                            }
                            break;
                        }

                    case 3:
                        System.out.println("Account choice: Vacation");
                        if (chooseActivity == 1) {
                            System.out.printf("Vacation balance before: $" + "%.2f", user.vacationAccount.getBalance());
                            System.out.println("");
                            System.out.print("Enter amount to deposit to your vacation account: $");
                            inputAmount = sc.nextDouble();
                            user.vacationAccount.transfer(user.vacationAccount, user.savingsAccount, inputAmount);
                            System.out.printf("Vacation balance after: $" + "%.2f", user.vacationAccount.getBalance());
                            System.out.println("");
                            break;
                        }
                        if (chooseActivity == 2) {
                            System.out.printf("Vacation balance before: $" + "%.2f", user.vacationAccount.getBalance());
                            System.out.println("");
                            System.out.print("Enter amount to withdraw from your vacation account: $");
                            inputAmount = sc.nextDouble();
                            user.vacationAccount.transfer(user.vacationAccount, user.savingsAccount, inputAmount);
                            System.out.printf("Vacation balance after: $" + "%.2f", user.vacationAccount.getBalance());
                            System.out.println("");
                            break;
                        }
                        if (chooseActivity == 3) {
                            System.out.printf("Balance for vacation account currently is: $" + "%.2f", user.vacationAccount.getBalance());
                            System.out.println("");
                            break;
                        }

                        if (chooseActivity == 4) {
                            System.out.println("Transfer from checking to which account?");
                            int chooseAccountTransfer = 0;
                            do {
                                //Display Accounts
                                System.out.println("1. Checking");
                                System.out.println("2. Savings");
                                System.out.print("Enter your account choice: "); //User Makes Choice
                                lineInput = sc.nextLine();
                                try {
                                    chooseAccountTransfer = Integer.parseInt(lineInput); //Choice is passed to keyboard
                                } catch (NumberFormatException ex) {
                                    System.out.println("Error");
                                }
                            } while (!(chooseAccountTransfer >= 1) || !(chooseAccountTransfer <= 2));// Display menu while the user input is not valid

                            accountTransferChoice = chooseAccountTransfer;

                            switch (accountTransferChoice) {
                                case 1:
                                    System.out.println("============================");
                                    System.out.printf("Checking balance before: $" + "%.2f", user.checkingAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Savings balance before: $" + "%.2f", user.savingsAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Vacation balance before: $" + "%.2f", user.vacationAccount.getBalance());
                                    System.out.println("");
                                    System.out.println("============================");
                                    System.out.print("Enter amount to transfer from vacation to checking: $");
                                    inputAmount = sc.nextDouble();
                                    user.vacationAccount.transfer(user.vacationAccount, user.savingsAccount, inputAmount);
                                    System.out.println("============================");
                                    System.out.printf("Checking balance after: $" + "%.2f", user.checkingAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Savings balance after: $" + "%.2f", user.savingsAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Vacation balance after: $" + "%.2f", user.vacationAccount.getBalance());
                                    System.out.println("");
                                    System.out.println("============================");
                                    break;
                                case 2:
                                    System.out.println("============================");
                                    System.out.printf("Checking balance before: $" + "%.2f", user.checkingAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Savings balance before: $" + "%.2f", user.savingsAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Vacation balance before: $" + "%.2f", user.vacationAccount.getBalance());
                                    System.out.println("");
                                    System.out.println("============================");
                                    System.out.print("Enter amount to transfer from vacation to savings: $");

                                    inputAmount = sc.nextDouble();
                                    user.vacationAccount.transfer(user.vacationAccount, user.savingsAccount, inputAmount);
                                    System.out.println("============================");
                                    System.out.printf("Checking balance after: $" + "%.2f", user.checkingAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Savings balance after: $" + "%.2f", user.savingsAccount.getBalance());
                                    System.out.println("");
                                    System.out.printf("Vacation balance after: $" + "%.2f", user.vacationAccount.getBalance());
                                    System.out.println("");
                                    System.out.println("============================");
                                    break;
                            }
                        }
                }
            }
            /*else if (chooseActivity == 5) {
                System.out.println("Transaction report has been chosen.");
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
            }*/
        }
    }
}
            
