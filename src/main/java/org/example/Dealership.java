package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> vehicles = new ArrayList<>();

    public Dealership() {
    }

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles != null ? vehicles : new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){
        List<Vehicle> results = new ArrayList<>();
        for(Vehicle vehicle : vehicles){
            if(vehicle.getPrice() > min && vehicle.getPrice() < max){
                results.add(vehicle);
            }
        }

        return results;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> results = new ArrayList<>();
        for(Vehicle vehicle : vehicles){
            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                results.add(vehicle);
            }
        }

        return results;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max){
        List<Vehicle> results = new ArrayList<>();
        for(Vehicle vehicle : vehicles){
            if(vehicle.getYear() > min && vehicle.getYear() < max){
                results.add(vehicle);
            }
        }

        return results;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> results = new ArrayList<>();
        for(Vehicle vehicle : vehicles){
            if(vehicle.getColor().equals(color)){
                results.add(vehicle);
            }
        }

        return results;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){
        List<Vehicle> results = new ArrayList<>();
        for(Vehicle vehicle : vehicles){
            if(vehicle.getOdometer() >= min && vehicle.getOdometer() <= max){
                results.add(vehicle);
            }
        }

        return results;
    }

    public List<Vehicle> getVehiclesByType(VehicleType vehicleType){
        List<Vehicle> results = new ArrayList<>();
        for(Vehicle vehicle : vehicles){
            if(vehicle.getVehicleType() == vehicleType){
                results.add(vehicle);
            }
        }

        return results;
    }

    public List<Vehicle> getAllVehicles(){
        return this.vehicles;
    }

    public void addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        this.vehicles.remove(vehicle);
    }
}
