package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        // Add Cars
        Vehicle [] vehicles = {
         new Car("Toyota", "Camry", "Red", 2020, 25000000, 4, 5, false)
        ,new Car("Honda", "Civic", "Blue", 2022, 23000000, 4, 5, false)
        ,new Car("Ford", "Mustang", "Black", 2021, 35000000, 2, 4, true)
        ,new Car("Ford", "Mustang", "Yellow", 2022, 37000000, 2, 4, true),
                new Truck("Ford", "F-150", "White", 2023, 40000000, 8, 1000),
        new Truck("Chevy", "Silverado", "Gray", 2022, 42000000, 7, 1200)
        };

        // Add Trucks

        for(Vehicle vehicle : vehicles) {
            inventory.addVehicle(vehicle);
        }

        System.out.printf("Average main.Vehicle Price: LKR %.2f ",inventory.getAveragePrice());
        System.out.println("\n---------------------------------------------------------------");
        ArrayList<Vehicle> foundVehicles = inventory.searchByMakeAndModel("Ford", "Mustang");
        System.out.println("(Test) Search Results for Ford Mustang:");
        System.out.println("---------------------------------------------------------------");
        for (Vehicle v : foundVehicles) {
            printResult(v.getMake(), v.getModel(), v.getYear(), v.getPrice());
        }

        foundVehicles.clear();

        System.out.println("Search Manually");

        while (true) {
            System.out.println("""
                    ---------------------------------------------------------------
                    🧾 Search By Make and Model
                    ---------------------------------------------------------------""");
            System.out.print("Enter makers name : ");
            String make = scanner.nextLine();
            System.out.print("Enter models name : ");
            String model = scanner.nextLine();

            foundVehicles = inventory.searchByMakeAndModel(make, model);

            System.out.println("---------------------------------------------------------------");
            System.out.println("Search Results :");
            System.out.println("---------------------------------------------------------------");
            for (Vehicle v : foundVehicles) {
                printResult(v.getMake(), v.getModel(), v.getYear(), v.getPrice());
            }
            foundVehicles.clear();
            String Exit;
            while (true) {
                System.out.print("Do you want to search more (y/n) : ");
                 Exit = scanner.nextLine().toLowerCase();
                 if(Exit.equals("n") || Exit.equals("y")) {
                     break;
                 } else {
                     System.out.println("❌ Invalid Input");
                 }
            }
            if (Exit.equals("n")) {
                break;
            }
        }
    }

    public static void printResult(String make, String model, int year, double price) {
        System.out.printf("""
                    Make : %S
                    Model: %S
                    Year :%S
                    Price: %.2f
                    ---------------------------------------------------------------
                    """,
                make, model, year, price
        );
    }

}
