package Task2;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<BankAccount> BankAccounts = new ArrayList<>();

    public void addCustomer(String customerName, String customerEmailAddress, String customerPhoneNumber) {
      customers.add(new Customer("100",customerName,customerEmailAddress,customerPhoneNumber));
    }

    public void removeCustomer(String customerName) {
        customers.removeIf(customer -> customer.getCustomerName().equals(customerName));
    }

    public void displayCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public String findCustomer(String customerName) {
        for (Customer customer : customers) {
            if (customer.getCustomerName().contains(customerName)) {
                customerName= customer.getCustomerName();
            }
        }
        return customerName;
    }

    public void addBankAccounts(String accountHolderName, String accountType){
        String accountHolder = findCustomer(accountHolderName);
        BankAccounts.add(new BankAccount("10003234",accountHolder,accountType,0));
    }

    public void removeBankAccounts(String accountNumber){
        BankAccounts.removeIf(bankAccount -> bankAccount.getAccountNumber().equals(accountNumber));
    }

    public void displayCustomerInfo (String customerName){
        addCustomer("Sakith","sakith@gmail.com","0712820396");
        for (Customer customer : customers) {
            if (customer.getCustomerName().contains(customerName)) {
                System.out.printf(
                        """
                                🙎‍♂️ Customer Information
                                
                                Customer Id    : %s
                                Customer Name  : %s
                                Customer Email : %s
                                Customer Phone : %s
                                %n""", customer.getCustomerId(),
                                    customer.getCustomerName(),
                                    customer.getCustomerEmailAddress(),
                                    customer.getCustomerPhoneNumber());
            }else{
                System.out.println("No Customer Found");
            }
        }
    }


}
