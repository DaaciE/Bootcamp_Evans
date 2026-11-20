package org.example;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Dealership dealership;

    public UserInterface(){}


    public void display(){
        String choice = "";
        init();

        while(true){
            System.out.println("Dealership Menu");
            System.out.println("[1] VIEW All VEHICLES");
            System.out.println("[2] SEARCH BY MAKE/MODEL");
            System.out.println("[3] SEARCH BY VEHICLE TYPE");
            System.out.println("[4] SEARCH BY YEAR");
            System.out.println("[5] SEARCH BY COLOR");
            System.out.println("[6]");
            System.out.println("[7]");
            System.out.println("[8]");
            System.out.println("[9]");
            System.out.println("[10] SELL/LEASE A VEHICLE");
            System.out.println("[11] Exit");
            System.out.println("Please Enter Your Choice:");
            choice = scanner.nextLine();


            switch (choice){
                case "1":
                    processGetAllVehiclesRequest();
                    break;

                case "2":
                    processGetByMakeModelRequest();
                    break;

                case "3":
                    processGetByVehicleTypeRequest();
                    break;

                case "4":
                    processGetByYearRequest();
                    break;

                case "5":
                    processGetByColorRequest();
                    break;

                case "6":
                    processGetByPriceRequest();
                    break;

                case"7":
                    processGetByMileageRequest();
                    break;

                case "8":

                    break;

                case "9":

                    break;

                case "10":
                    break;

                case "11":

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

    private void processGetAllVehiclesRequest(){
       displayVehicles(dealership.getAllVehicles());
    }
    private void processGetByMakeModelRequest(){
        System.out.println("Car Make:");
        String makeInput = scanner.nextLine();
        System.out.println("Car Model:");
        String modelInput = scanner.nextLine();

        displayVehicles(dealership.getVehicleByMakeModel(makeInput, modelInput));
    }
    private void processGetByVehicleTypeRequest(){
        System.out.println("What type of vehicle are you searching for?");
        System.out.println("ex. SEDAN, SUV, TRUCK, SPRINTER.");
        VehicleType vehicleTypeInput = VehicleType.valueOf(scanner.nextLine().toUpperCase());

        displayVehicles(dealership.getVehicleByType(vehicleTypeInput));
    }
    private void processGetByYearRequest(){
        System.out.println("Enter Min Year:");
        int minYearInput = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Max Year:");
        int maxYearInput = Integer.parseInt(scanner.nextLine());

        displayVehicles(dealership.getVehicleByYear(minYearInput, maxYearInput));
    }
    private void processGetByColorRequest(){
        System.out.println("What color are you searching for?");
        String userInput = scanner.nextLine();

        displayVehicles(dealership.getVehicleByColor(userInput));

    }
    private void processGetByPriceRequest(){
        System.out.println("Enter Min Price:");
        BigDecimal minPricerInput = new BigDecimal(scanner.nextLine());
        System.out.println("Enter Max Price:");
        BigDecimal maxPriceInput = new BigDecimal(scanner.nextLine());

        displayVehicles(dealership.getVehicleByPrice(minPricerInput, maxPriceInput));
    }
    private void processGetByMileageRequest(){
        System.out.println("Enter Min Mileage:");
        int minMileageInput = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Max Mileage:");
        int maxMileageInput = Integer.parseInt(scanner.nextLine());

        displayVehicles(dealership.getVehicleByMileage(minMileageInput, maxMileageInput));
    }

    private void processAddVehicleRequest(){
        System.out.println("========== ADD A NEW VEHICLE ==========");
        System.out.println("New wheels on the lot! Let's get this vehicle registered.");

        System.out.println("Enter the vehicle VIN:");

        System.out.println("Enter the vehicle year:");

        System.out.println("Enter the vehicle make (ex. Toyota, Honda, Ford):");

        System.out.println("Enter the vehicle model (ex. Camry, Civic, Mustang):");

        System.out.println("Enter the vehicle type (SEDAN, SUV, TRUCK, SPRINTER):");

        System.out.println("Enter the vehicle color:");

        System.out.println("Enter the current mileage:");

        System.out.println("Enter the vehicle price: $");

    }
    private void processRemoveVehicleRequest(){}

}
