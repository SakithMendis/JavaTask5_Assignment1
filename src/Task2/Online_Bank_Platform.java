package Task2;


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
                3.Create New Bank Account for Customer
                4.View Bank Account Details
                5.exit
                ---------------------------------------------------------------
                """;
    }

    public static boolean menuFunctionality(Scanner scanner, Bank bank, boolean applicationEnd) {
        try {
            System.out.print(applicationMenu());
            System.out.print("Add menu number :");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("""
                            ---------------------------------------------------------------
                                                🧔 Create New Customer 
                            ---------------------------------------------------------------
                            """);

                    System.out.print("Enter Customer Name : ");
                    String name = scanner.next();
                    String email;
                    String phoneNumber;
                    while (true){
                        System.out.print("Enter Customer Email Address('@'is mandatory) : ");
                        email = scanner.next();
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
                    String customerNameSearch = scanner.next();
                    bank.displayCustomerInfo(customerNameSearch);
                    break;
                case 3:
                    System.out.print("""
                            ---------------------------------------------------------------
                                        🧔 Create New Bank Account for Customer 
                            ---------------------------------------------------------------
                            """);
                    System.out.print("Enter Customer Name :");
                    String customerName = scanner.next();
                    customerName = bank.findCustomer(customerName);
                    if (!customerName.isEmpty()) {
                        String accountType;
                        while (true) {
                            System.out.print("Enter Account Type (Saving/Current): ");
                            accountType = scanner.next();
                            if (accountType.equalsIgnoreCase("saving") || accountType.equalsIgnoreCase("current"))
                                break;
                            System.out.println("❌ Invalid account type. Please enter 'Saving' or 'Current'.");
                        }
                        System.out.print("Enter Account Initial deposit : ");
                        int accountInitialDeposit = scanner.nextInt();
                        BankAccount Account = bank.addBankAccounts(customerName, accountType);
                        Account.deposit(accountInitialDeposit);
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

                case 5:
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