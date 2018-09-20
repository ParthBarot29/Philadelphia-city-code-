/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist242team3bank;

import java.util.Date;

/**
 *
 * @author jvf5264
 */
public class Transaction {
    private Date dateTime;
    private double ammount; 
    private Account sourceAccount,targetAccount;    
    private TransactionType transactionType;
    
    public static void main(String[] args) {
        Transaction transfer= new Transaction(
                new Account("savings",500.0),
                new Account("vacation",400.0),
                TransactionType.Transfer,
                100.0);
        transfer.reportTransaction();
        Transaction deposit= new Transaction(
                new Account("savings",600.0),
                TransactionType.Deposit,
                100.0);
        deposit.reportTransaction();
        Transaction withdrawal= new Transaction(
                new Account("savings",600.0),
                TransactionType.Withdrawal,
                100.0);
        withdrawal.reportTransaction();
    }
    
    //Constructor for transfer type (have target account)
    public Transaction(Account srcAcc,Account trgAcc,TransactionType tt,double ammount) {
        //Assign current time to dateTime field
        this.dateTime=new Date();
        this.sourceAccount=srcAcc;
        this.targetAccount=trgAcc;
        this.transactionType=tt;
        this.ammount=ammount;
    }
    
    //Constructor for deposit and withdrawal
    public Transaction(Account srcAcc,TransactionType tt,double ammount) {
        //Assign current time to dateTime field
        this.dateTime=new Date();
        this.sourceAccount=srcAcc;
        this.transactionType=tt;
        this.ammount=ammount;
    }
    
    public void reportTransaction() {
        System.out.println("Transaction report");
        String transType="Unknown";
        switch (transactionType) {
            case Deposit:
                transType="Deposit";
                break;
            case Withdrawal:
                transType="Withdrawal";
                break;
            case Transfer:
                transType="Transfer";
                break;
        }
        System.out.println("Transaction type: "+transType);
        System.out.println("Amount: "+ammount);
    }
    
    
}
