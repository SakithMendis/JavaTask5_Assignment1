package Test_Class_Pkg;

import main.Customer;
import org.junit.Test;

import static org.junit.Assert.*;


public class CustomerTest {
    Customer customer;

    @Test
    public void CreateCustomer() {
        customer = new Customer("Sakith Nimpura Mendis","sakith1256@gmail.com","0712820396");
        assertEquals(customer.getCustomerName(), "Sakith Nimpura Mendis");
        assertEquals(customer.getCustomerEmailAddress(), "sakith1256@gmail.com");
    }



}
