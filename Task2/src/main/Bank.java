package main;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Bank {

    public ArrayList<Customer> customers;
    public ArrayList<BankAccount> BankAccounts;

    public Bank() {
        this.customers= new ArrayList<>();
        this.BankAccounts= new ArrayList<>();
    }

    public Customer addCustomer(String customerName, String customerEmailAddress, String customerPhoneNumber) {
        Customer customer = new Customer(customerName,customerEmailAddress,customerPhoneNumber);
        customers.add(customer);
        System.out.println("\n✅ Customer " + customerName + " added successfully.");
        return customer;
    }


    public Customer findCustomer(String customerName) {
        Customer validatedCustomerName = null;
        if(!customers.isEmpty()) {
            for (Customer customer : customers) {
                if (customer.getCustomerName().toLowerCase().contains(customerName.toLowerCase())) {
                    validatedCustomerName = customer;
                }
            }
            if(validatedCustomerName==null) {
                System.out.println("⚠️ Customer " + customerName + " not found.");
            }
        }else{
            System.out.println("⚠️ Customer " + customerName + " not found.");
        }
        return validatedCustomerName;
    }

    public BankAccount addBankAccounts(String accountHolderName, String accountType,int amount) {
        Customer accountHolder = findCustomer(accountHolderName);
        if(!Objects.equals(accountHolder, "")) {
            BankAccount Account =new BankAccount(accountHolder.getCustomerName(), accountType, 0.00);
            BankAccounts.add(Account);
            Account.deposit(amount);
            System.out.println("\n✅ BankAccount (" + Account.getAccountNumber()+"-"+Account.getAccountType() + " account) added successfully.");
            return Account;
        }else {
            return null;
        }

    }


    public void displayCustomerInfo (String customerName){
        Customer customer = findCustomer(customerName);
        if(customer != null) {
            System.out.printf(
                    """
                            ‍♂️ Customer Information
                            
                            Customer Id    : %s
                            Customer Name  : %s
                            Customer Email : %s
                            Customer Phone : %s
                            %n""", customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerEmailAddress(),
                    customer.getCustomerPhoneNumber());
        }
    }



public BankAccount bankAccountDetails(String accountNumber) {
    BankAccount account = findBankAccount(accountNumber) ;
    if (account != null) {
        System.out.printf("""
                                     Account Number  : %s
                                     Account Type    : %s
                                     Account Holder  : %s
                                     Account Balance : %s
                                    """,account.getAccountNumber(),
                account.getAccountType(),
                account.getAccountHolderName(),
                account.getAccountBalance());
    }
    return account;
}

public BankAccount findBankAccount (String accountNumber) {
    BankAccount validBankAccount = null;
    if (!BankAccounts.isEmpty()) {
        for (BankAccount bankAccount : BankAccounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                validBankAccount = bankAccount;
            }
        }
        System.out.println((validBankAccount == null) ? "No Bank Account Found" : "");
    }
    return validBankAccount;
}
}

