package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Dealership dealership;

    public UserInterface(){
        display();
    }


    private void display(){
        String choice = "";
        init();

        while(true){
            System.out.println("Dealership Menu");
            System.out.println("[1] View All Vehicles");
            System.out.println("[2]");
            System.out.println("[3]");
            System.out.println("[4]");
            System.out.println("[5]");
            System.out.println("[6]");
            System.out.println("[7]");
            System.out.println("[8]");
            System.out.println("[9] Exit");
            System.out.println("Please Enter Your Choice:");
            choice = scanner.nextLine();


            switch (choice){
                case "1":
                    processGetAllVehiclesRequest();
                    break;

                case "9":

                    return;

                default:
                    System.out.println(" Please Enter a Valid Input.");
                    break;
            }
        }
    }
    private void init(){
        this.dealership = DealershipFileManager.getDealership();
    }
    private void processGetAllVehiclesRequest(){
       displayVehicles(dealership.getAllVehicles());
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


    private void processGetByPriceRequest(){}
    private void processGetByMakeModelRequest(){}
    private void processGetByYearRequest(){}
    private void processGetByColorRequest(){}
    private void processGetByMileageRequest(){}
    private void processGetByVehicleTypeRequest(){}
    private void processAddVehicleRequest(){}
    private void processRemoveVehicleRequest(){}

}
