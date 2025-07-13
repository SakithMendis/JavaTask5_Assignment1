package Test_Class_Pkg;

import main.Bank;
import main.BankAccount;
import main.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;

import static org.junit.Assert.*;


public class BankTest {
    Bank bank = new Bank();
    Customer customer;
    BankAccount bankAccount;

    @Before
    public void setUp() throws Exception {
      customer = bank.addCustomer("Sakith Nimpura Mendis","sakith1256@gmail.com","0712820396");
      bankAccount = bank.addBankAccounts(customer.getCustomerName(),"Saving",12000);
    }


    @Test
    @Order(1)
    public void addCustomer(){
        Customer customer1 = bank.addCustomer("Rusith Chamathka","rusith@gmail.com","0712432535");
        assertEquals(2,bank.customers.size());
        assertTrue(bank.customers.contains(customer1));
    }

    @Test
    @Order(2)
    public void AddAccount(){
        BankAccount AddbankAccount = bank.addBankAccounts(customer.getCustomerName(), "Current",10000);
        assertEquals("Current",AddbankAccount.getAccountType());
        assertEquals(2,bank.BankAccounts.size());
        assertEquals(customer.getCustomerName(), AddbankAccount.getAccountHolderName());
    }

    @Test
    @Order(3)
    public void findCustomer(){
        bank.findCustomer(customer.getCustomerName());
        assertEquals("Sakith Nimpura Mendis",customer.getCustomerName());
    }

    @Test
    @Order(4)
    public void findAccount(){
        bank.findBankAccount(bankAccount.getAccountNumber());
    }


    @Test
    @Order(5)
    public void deposit(){
        bankAccount.deposit(2000);
        assertEquals(14000,bankAccount.getAccountBalance(),2.0);
        assertEquals(2,bankAccount.Transactions.size());

    }

    @Test
    @Order(6)
    public void withdraw(){
        bankAccount.withdraw(2000);
        assertEquals(10000,bankAccount.getAccountBalance(),2.0);
        assertEquals(2,bankAccount.Transactions.size());
    }

}
