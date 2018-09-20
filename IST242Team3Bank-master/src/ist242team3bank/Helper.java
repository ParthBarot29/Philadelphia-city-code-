package ist242team3bank;

import java.util.Scanner;

public class Helper {

    boolean promptUser = true;
    boolean promptNameInput = false;
    Scanner sc = new Scanner(System.in);
    double inputBalance;
    double returnValue;
    //String inputString;
    User user = new User();

    double inputDecimal() {
        while (promptUser) {
            System.out.print("Enter balance for this account: $");
            try {
                inputBalance = sc.nextDouble();
                //user.savingsAccount.setBalance(inputBalance);
                break;

            } catch (Exception e) {
                System.out.println("Please input a valid amount.");
                sc.next(); // consumes invalid input
            }
        }
        return returnValue = inputBalance;
    }

    String inputNonBlankString(String inputString, String inputString2) {
        while (promptNameInput != true) {

            if (inputString == null || inputString.trim().isEmpty()) {
                System.out.println("First name not valid. Please enter again.");
                user.promptName();
                inputString = user.getFirstName();
            } else if (inputString2 == null || inputString2.trim().isEmpty()) {
                System.out.println("Last name not valid. Please enter again.");
                user.promptName();
                inputString2 = user.getLastName();
            } else {
                promptNameInput = true;
            }
        }
        return inputString;
    }
}
