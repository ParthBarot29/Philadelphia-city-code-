package ist242team3bank;

/**
 *
 * @author eql5121
 */
import java.util.ArrayList;
//import java.util.Scanner;

public class Account {

    // Testing functionality of Account class
    /*
     public static void main(String[] args) {
     Account account1 = new Account();
     Account account2 = new Account();
        
     // testing of deposit and withdraw
     account1.deposit(100);
     account1.withdraw(25);
     account2.deposit(500);
     System.out.printf("Balance  in account 1 is currently: $" + "%.2f", account1.getBalance());
     System.out.println("");
     System.out.printf("Balance  in account 2 is currently: $" + "%.2f", account2.getBalance());
     System.out.println("");
        
     // testing of choosing an account type
     account1.initNewAccountType();
     account2.initNewAccountType();
     System.out.println("Account type of account 1 is: " + account1.getAccountType());
     System.out.println("Account type of account 2 is: " + account2.getAccountType());
        
     //testing of transferring from one account instance to another
     account2.transfer(account1, 100);
     System.out.printf("Account 1's balance is currently: $" + "%.2f", account1.getBalance());
     System.out.println("");
     System.out.printf("Account 2's balance is currently: $" + "%.2f", account2.getBalance());
     System.out.println("");
     }

     Scanner keyboard = new Scanner(System.in);
     */
    /*
     public static final String SAVINGS = "Savings";
     public static final String CHECKING = "Checking";
     public static final String VACATION = "Vacation";
     */
    private String _accountType = "";
    private double _balance = 0;
    private ArrayList<Transaction> transactions;
    
    public Account() {
        this.transactions = new ArrayList<Transaction>();
    }

    public Account(String accountType, double balance) {
        this._accountType = accountType;
        this._balance = balance;
        this.transactions = new ArrayList<Transaction>();
    }

    public String getAccountType() {
        return _accountType;
    }

    public void setAccountType(String _accountType) {
        this._accountType = _accountType;
    }

    public double getBalance() {
        return _balance;
    }

    public void setBalance(double _balance) {
        this._balance = _balance;
    }

    /*
     public void initNewAccountType() {
     System.out.println("What type of account do you want to set this to?");
     System.out.println("1.Savings");    
     System.out.println("2.Checking");
     System.out.println("3.Vacation");
     System.out.print("Choice: ");
     int x = keyboard.nextInt();

     switch (x) {
     case 1:
     _accountType = SAVINGS;
     break;
     case 2:
     _accountType = CHECKING;
     break;
     case 3:
     _accountType = VACATION;
     break;
     }
        

     }*/
    // deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            _balance += amount;
            System.out.printf("Deposit successful, deposited $" + "%.2f", amount);
            System.out.println("");
        } else {
            System.out.println("Please enter a valid amount.");
        }
        transactions.add(new Transaction(this, TransactionType.Deposit, amount));
    }

    // withdraw method
    public void withdraw(double amount) {
        double withdrawAmount = 0;

        if (_balance >= amount) {
            withdrawAmount = amount;
            System.out.printf("Withdrawal successful, withdrew $" + "%.2f", amount);
            System.out.println("");
        } else {
            // Did not have enough in the account.

            System.out.println("Did not have enough balance to withdraw.");
            System.out.println("Please enter in a valid amount.");
        }

        _balance -= withdrawAmount;
        transactions.add(new Transaction(this, TransactionType.Withdrawal, amount));
        //return withdrawAmount;

    }

    // transfer method utilizing withdraw and deposit method
    public void transfer(Account sendingAccount, Account recievingAccount, double amount) {
        
        if (_balance <= amount) {
            System.out.println("Transfer failed, not enough in balance to withdraw for transfer.");
        } else if (_balance < 0) {
            System.out.println("Transfer failed, did not deposit a valid amount.");
        } else {
            withdraw(amount);
            recievingAccount.deposit(amount);
            System.out.printf("Transfer successful, transferred $" + "%.2f", amount);
            System.out.println("");
            transactions.add(new Transaction(this, recievingAccount, TransactionType.Transfer, amount));
        }
    }
}
