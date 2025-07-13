package main;

import java.util.concurrent.ThreadLocalRandom;

public class Customer {
    private String customerId;
    private String customerName;
    private String customerEmailAddress;
    private String customerPhoneNumber;

    public Customer(String customerName, String customerEmailAddress, String customerPhoneNumber) {
        this.customerId = "C-"+  String.valueOf(ThreadLocalRandom.current().nextInt(100, 1000));
        this.customerName = customerName;
        this.customerEmailAddress = customerEmailAddress;
        this.customerPhoneNumber = customerPhoneNumber;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }
    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }
    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }
    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

}
