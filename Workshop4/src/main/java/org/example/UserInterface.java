package org.example;

import java.util.List;

public class UserInterface {
    Dealership dealership;

    public UserInterface(){}
    private void init(){
        this.dealership = DealershipFileManager.getDealership();
    }
    private void displayVehicles(List<Vehicle> vehicles){
        for (Vehicle vehicle : vehicles ) {
            System.out.printf("%d|%d|%s|%s|%s|%s|%d|%s%n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice());

        }
    }



    private void display(){
        String choice = "";

        while(true){
            switch (choice){
                case "1":
            }
        }
    }

    private void processGetAllVehiclesRequest(){
       displayVehicles(dealership.getAllVehicles());
    }






    private void processGetByPriceRequest(){}
    private void processGetByMakeModelRequest(){}
    private void processGetByYearRequest(){}
    private void processGetByColorRequest(){}
    private void processGetByMileageRequest(){}
    private void processGetByVehicleTypeRequest(){}
    private void processAddVehicleRequest(){}
    private void processRemoveVehicleRequest(){}

}
