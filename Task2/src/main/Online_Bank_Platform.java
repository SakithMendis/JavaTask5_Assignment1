package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Online_Bank_Platform {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        boolean applicationEnd = false;
        while (!applicationEnd) {
            applicationEnd = menuFunctionality(scanner, bank, applicationEnd);
        }
    }

    public static String applicationMenu() {
        return """
                ---------------------------------------------------------------
                                Online Banking Platform Menu
                ---------------------------------------------------------------
                1.New Customer
                2.View Customer Details
                3.Create New main.Bank Account for main.Customer
                4.View Bank Account Details
                5.Customer withdraw and deposit
                6.Exit
                ---------------------------------------------------------------
                """;
    }

    public static boolean menuFunctionality(Scanner scanner, Bank bank, boolean applicationEnd) {
        try {
            System.out.print(applicationMenu());
            System.out.print("Add menu number :");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("""
                            ---------------------------------------------------------------
                                                🧔 Create New main.Customer 
                            ---------------------------------------------------------------
                            """);
                    String email;
                    String phoneNumber;
                    System.out.print("Enter Customer Name : ");
                    String name = scanner.nextLine().trim();
                    while (true){
                        System.out.print("Enter Customer Email Address('@'is mandatory) : ");
                        email = scanner.nextLine().trim();
                        if(email.contains("@")) break;
                        System.out.print("❌ Email Address not contain '@' \n");
                    }
                    while (true) {
                        System.out.print("Enter Customer Phone Number (10 digits) :");
                        phoneNumber = scanner.next();
                        if(!phoneNumber.matches("\\d+")){
                            System.out.print("❌ Phone number must contain only digits. \n ");
                        }else if (phoneNumber.length() != 10){
                            System.out.print("❌ Phone number must be 10 digits long.\" \n ");
                        }else{ break;}

                    }
                    bank.addCustomer(name, email, phoneNumber);
                    break;
                case 2:
                    System.out.print("""
                            ---------------------------------------------------------------
                                                🧔 Search for  customer
                            ---------------------------------------------------------------
                            """);
                    System.out.print("Enter Customer Name :");
                    String customerNameSearch = scanner.next().trim();
                    bank.displayCustomerInfo(customerNameSearch);
                    break;
                case 3:
                    System.out.print("""
                            ---------------------------------------------------------------
                                        🧔 Create New Bank Account for a Customer 
                            ---------------------------------------------------------------
                            """);
                    System.out.print("Enter Customer Name :");
                    String customerName = scanner.next().trim();
                    Customer customer = bank.findCustomer(customerName);
                    if (!(customer ==null)) {
                        String accountType;
                        while (true) {
                            System.out.print("Enter Account Type (Saving(S)/Current (C)): ");
                            accountType = scanner.next();
                            accountType = accountType.toUpperCase();
                            if (accountType.equalsIgnoreCase("S") || accountType.equalsIgnoreCase("C")||accountType.equalsIgnoreCase("SAVING") || accountType.equalsIgnoreCase("CURRENT"))
                                break;
                            System.out.println("❌ Invalid account type. Please enter 'Saving' or 'Current'.");
                        }
                            System.out.print("Enter Account Initial deposit : ");
                            int accountInitialDeposit = scanner.nextInt();
                        accountType = (accountType.equals("S")||accountType.equals("SAVING")) ? "Saving" : (accountType.equals("C")||accountType.equals("CURRENT")) ? "Current" : "";
                        bank.addBankAccounts(customer.getCustomerName(), accountType,accountInitialDeposit);

                    }
                    break;
                case 4:
                    System.out.print("""
                            ---------------------------------------------------------------
                                                🧾 Search for Bank Account details
                            ---------------------------------------------------------------
                            """);
                    System.out.print("Enter Bank Account Number : ");
                    String accountNumber = scanner.next();
                    BankAccount account = bank.bankAccountDetails(accountNumber);
                    if(!(account==null)){
                        while (true) {
                            System.out.print("\nDo you want to view transaction history (y/n) : ");
                            String input = scanner.next();
                            if (input.equalsIgnoreCase("y")) {
                                account.transactionHistory();
                                break;
                            } else if (input.equalsIgnoreCase("n")) {
                                break;
                            } else {
                                System.out.println("❌ Invalid Option");
                            }
                        }
                    }

                    break;
                case 5:

                    System.out.print("Enter Customer Account Number  :");
                    String customerAccountNumber = scanner.next();
                    BankAccount bankAccount = bank.findBankAccount(customerAccountNumber);
                    if(bankAccount!=null) {
                        System.out.print("""
                                ---------------------------------------------------------------
                                                    Deposit and Withdraw
                                ---------------------------------------------------------------
                                D. Deposits
                                W. Withdraws
                                ---------------------------------------------------------------
                                """);

                        while (true) {
                            System.out.print("Enter Transaction type (D/W) :");
                            String transactionType = scanner.next();
                            System.out.print("Enter Amount : ");
                            int amount = scanner.nextInt();
                            switch (transactionType.toUpperCase()) {
                                case "D":
                                    bankAccount.deposit(amount);
                                    break;
                                case "W":
                                    bankAccount.withdraw(amount);
                                    break;
                            }
                            System.out.print("Does Customer want to do another transactions  (y/n) :");
                            String input = scanner.next();
                            if (!input.equals("y")) {
                                break;
                            }

                        }
                    }else{
                        System.out.print("⚠️ You entered Account Number is Invalid");
                    }
                    break;

                case 6:
                    applicationEnd = true;
                    break;
                default:
                    System.out.println("❌ Invalid Option");
                    break;

            }

        }  catch (InputMismatchException e) {
            System.out.println("⚠️ Invalid input. Please enter a number.");
            scanner.nextLine(); // consume invalid input (important!)
        } catch (Exception e) {
            System.out.println("⚠️ Unexpected error: " + e.getMessage());
            e.printStackTrace(); // optional for debugging
        }
        return applicationEnd;
    }


}