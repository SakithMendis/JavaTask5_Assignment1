package main;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Vehicle>vehicles;

    public Inventory() {
        this.vehicles = new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public double getAveragePrice() {
        if (vehicles.isEmpty()) return 0.0;

        double total = 0.0;
        for (Vehicle v : vehicles) {
            total += v.getPrice();
        }
        return total / vehicles.size();
    }

    public ArrayList<Vehicle> searchByMakeAndModel(String make, String model) {
        ArrayList<Vehicle> vehicle = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getMake().equals(make) && v.getModel().equals(model)) {
                vehicle.add(v);
            }
        }
        return vehicle;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

}
