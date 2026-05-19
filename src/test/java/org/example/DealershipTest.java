package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {
    private Dealership dealership;

    @BeforeEach
    public void setUp() {
        dealership = new Dealership("Sample Dealership", "123 Main St", "555-555-5555");
    }

    @Test
    public void testAddVehicle() {
        Vehicle vehicle = new Vehicle(1, 2020, "Toyota", "Camry", "Red", VehicleType.SEDAN, 15000, 25000.0);

        dealership.addVehicle(vehicle);
        List<Vehicle> vehicles = dealership.getAllVehicles();

        assertTrue(vehicles.contains(vehicle));
    }
}
