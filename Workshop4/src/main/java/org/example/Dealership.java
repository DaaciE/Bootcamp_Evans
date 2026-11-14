package org.example;

import java.util.ArrayList;
import java.util.List;

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

    public List<Vehicle> getVehicleByPrice(double min, double max){
        return null; //new ArrayList<>();
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model){
        return null; //new ArrayList<>();
    }

    public List<Vehicle> getVehicleByYear(int min, int max){
        return null; //new ArrayList<>();
    }

    public List<Vehicle> getVehicleByColor(String color){
        return null; //new ArrayList<>();
    }

    public List<Vehicle> getVehicleByMileage(int min, int max){
        return null; //new ArrayList<>();
    }


    public List<Vehicle> getVehicleByType(VehicleType vehicleType){
        return null; //new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
         inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        //inventory.remove(vehicle);
    }

}