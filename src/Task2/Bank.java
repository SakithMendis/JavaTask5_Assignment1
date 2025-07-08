package Task2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Bank {

    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<BankAccount> BankAccounts = new ArrayList<>();

    public Customer addCustomer(String customerName, String customerEmailAddress, String customerPhoneNumber) {
        Customer customer = new Customer("C-"+  String.valueOf(ThreadLocalRandom.current().nextInt(100, 1000)),customerName,customerEmailAddress,customerPhoneNumber);
        customers.add(customer);
        System.out.println("\n✅ Customer " + customerName + " added successfully.");
        return customer;
    }


    public String findCustomer(String customerName) {
        String validatedCustomerName ="";
        if(!customers.isEmpty()) {
            for (Customer customer : customers) {
                if (customer.getCustomerName().toLowerCase().contains(customerName.toLowerCase())) {
                    validatedCustomerName = customer.getCustomerName();
                }
            }
            if(validatedCustomerName.isEmpty()) {
                System.out.println("⚠️ Customer " + customerName + " not found.");
            }
        }else{
            System.out.println("⚠️ Customer " + customerName + " not found.");
            validatedCustomerName = "";
        }
        return validatedCustomerName;
    }

    public BankAccount addBankAccounts(String accountHolderName, String accountType){
        String accountHolder = findCustomer(accountHolderName);
        if(!Objects.equals(accountHolder, "")) {
            BankAccount Account =new BankAccount("1034"+  String.valueOf(ThreadLocalRandom.current().nextInt(1000, 10000)), accountHolder, accountType, 0.00);
            BankAccounts.add(Account);
            System.out.println("\n✅ BankAccount (" + Account.getAccountNumber()+"-"+Account.getAccountType() + " account) added successfully.");
            return Account;
        }else {
            return null;
        }

    }

    public void removeBankAccounts(String accountNumber){
        BankAccounts.removeIf(bankAccount -> bankAccount.getAccountNumber().equals(accountNumber));
    }

    public void displayCustomerInfo (String customerName){
        for (Customer customer : customers) {
            if (customer.getCustomerName().toLowerCase().contains(customerName.toLowerCase())) {
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
            }else{
                System.out.println("❌ No Customer Found");
            }
        }
    }


    public BankAccount bankAccountDetails(String accountNumber) {
        BankAccount account = null ;
        if(!BankAccounts.isEmpty()) {
            for (BankAccount bankAccount : BankAccounts) {
                if (bankAccount.getAccountNumber().equals(accountNumber)) {
                    account = bankAccount;
                     System.out.printf("""
                                     Account Number  : %s
                                     Account Type    : %s
                                     Account Holder  : %s
                                     Account Balance : %s
                                    """,bankAccount.getAccountNumber(),
                            bankAccount.getAccountType(),
                    bankAccount.getAccountHolderName(),
                    bankAccount.getAccountBalance());
                }
            }

        }
            return account;
    }

}
