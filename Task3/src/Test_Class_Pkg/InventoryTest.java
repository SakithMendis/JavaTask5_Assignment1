package Test_Class_Pkg;

import main.Car;
import main.Inventory;
import main.Truck;
import main.Vehicle;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryTest {
    Inventory inventory = new Inventory();
    @Before
    public void beforeTest() {
        Vehicle[] vehicles = {
                new Car("Toyota", "Camry", "Red", 2020, 25000000, 4, 5, false)
                ,new Car("Honda", "Civic", "Blue", 2022, 23000000, 4, 5, false),
                new Truck("Ford", "F-150", "White", 2023, 40000000, 8, 1000),
                new Truck("Chevy", "Silverado", "Gray", 2022, 42000000, 7, 1200)
        };
        for(Vehicle vehicle : vehicles) {
            inventory.addVehicle(vehicle);
        }
    }


    @Test
    public void getAveragePrice() {
        double averagePrice = (25000000+23000000+40000000+42000000)/4.0;
        assertEquals(averagePrice,inventory.getAveragePrice(),0.1);

    }

    @Test
    public void searchByMakeAndModel(){
        ArrayList <Vehicle> vehicle = inventory.searchByMakeAndModel("Ford","F-150");
        assertEquals(1,vehicle.size());
        assertEquals("F-150",vehicle.getFirst().getModel());
        assertEquals("Ford",vehicle.getFirst().getMake());
    }

    @Test
    public void searchByMakeAndModelNull(){
        ArrayList <Vehicle> vehicle = inventory.searchByMakeAndModel("Fords","F-950");
        assertTrue(vehicle.isEmpty());
    }


}
