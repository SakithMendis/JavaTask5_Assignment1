package Task2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private String accountType;
    private Double accountBalance;

    public BankAccount(String accountNumber, String accountHolderName, String accountType, Double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    public HashMap<String,Transaction> Transactions = new HashMap<String,Transaction>();


    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public Double getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void deposit(int amount) {
        try {
            double accountBalanceAmount = getAccountBalance() + amount;
            Transaction transaction = new  Transaction(String.valueOf(ThreadLocalRandom.current().nextInt(100, 1000)),"Deposit ",amount, LocalDate.now());
            Transactions.put(this.accountNumber+transaction.getTransactionId(), transaction);
            setAccountBalance(accountBalanceAmount);
            System.out.printf("""
                        \nDeposit Successful
                        Bank Account : %s | Deposit Amount : %s
                        %n""", BankAccount.this.accountNumber, amount);

        }catch(Exception e) {
            System.out.println("Invalid Input");
        }
    }
    public void withdraw(int amount) {
        try {
            if(getAccountBalance() > amount) {
                double accountBalanceAmount = getAccountBalance() - amount;
                Transaction transaction = new  Transaction(String.valueOf(ThreadLocalRandom.current().nextInt(100, 1000)),"Withdraw",amount,LocalDate.now());
                Transactions.put(BankAccount.this.accountNumber+transaction.getTransactionId(), transaction);
                setAccountBalance(accountBalanceAmount);
                System.out.printf("""
                                    Withdraw Successful
                                    Bank Account : %s | Withdraw Amount : %s
                                    %n""", BankAccount.this.accountNumber, amount);

            }else{
                System.out.println("Insufficient Funds");
            }
        }catch(Exception e) {
            System.out.println("Invalid Input");
        }
    }
    public void transactionHistory() {
        if (!Transactions.isEmpty()) {
            System.out.println("""
                    ---------------------------------------------------------------
                                            Transaction History
                    ---------------------------------------------------------------""");
          for(Transaction transaction : Transactions.values()) {
             System.out.printf("""
    Transaction ID    : %s
    Transaction Date  : %s
    Bank Account      : %s
    Transaction Type  : %s
    Transaction amount: %.2f
    ---------------------------------------------------------------
    \n""",transaction.getTransactionId(),transaction.getTransactionDate(),BankAccount.this.accountNumber,transaction.getTransactionType(),transaction.getTransactionAmount());
          }
        }

    }

}
