package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    public List<Vehicle> getVehicleByPrice(BigDecimal min, BigDecimal max){
        List<Vehicle> matchingVehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getPrice().compareTo(min) >=0 && vehicle.getPrice().compareTo(max) <= 0) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model){
        List<Vehicle> matchingVehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getMake().equalsIgnoreCase(make) &&
                    vehicle.getModel().equalsIgnoreCase(model)){
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehicleByYear(int min, int max){
        List<Vehicle> matchingVehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getYear() >= min && vehicle.getYear() <= max){
            matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehicleByColor(String color){
            List<Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)){
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehicleByMileage(int min, int max){
        List<Vehicle> matchingVehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehicleByType(VehicleType vehicleType){
        List<Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType() == vehicleType) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public void addVehicle(Vehicle vehicle){
         inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }

}