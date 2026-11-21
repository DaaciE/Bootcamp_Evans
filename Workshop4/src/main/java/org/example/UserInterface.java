package org.example;

import javax.print.attribute.standard.NumberUp;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Dealership dealership;

    public UserInterface() {
    }


    public void display() throws IOException {
        String choice = "";
        init();

        while (true) {
            System.out.println("Dealership Menu");
            System.out.println("[0] EXIT");
            System.out.println("[1] VIEW All VEHICLES");
            System.out.println("[2] SEARCH BY MAKE/MODEL");
            System.out.println("[3] SEARCH BY VEHICLE TYPE");
            System.out.println("[4] SEARCH BY YEAR");
            System.out.println("[5] SEARCH BY COLOR");
            System.out.println("[6]");
            System.out.println("[7]");
            System.out.println("[8]");
            System.out.println("[9]");
            System.out.println("[10] SELL A VEHICLE");
            System.out.println("[11] LEASE A VEHICLE");
            System.out.println("Please Enter Your Choice:");
            choice = scanner.nextLine();


            switch (choice) {
                case "0":

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

                case "7":
                    processGetByMileageRequest();
                    break;

                case "8":
                    processAddVehicleRequest();
                    break;

                case "9":
                    processRemoveVehicleRequest();
                    break;

                case "10":

                    break;

                case "11":


                default:
                    System.out.println(" Please Enter a Valid Input.");
                    break;
            }
        }
    }

    private void init() {
        this.dealership = DealershipFileManager.getDealership();
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.printf("%d|%d|%s|%s|%s|%s|%d|%s%n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice().setScale(2, RoundingMode.HALF_UP));

        }
    }

    private void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    private void processGetByMakeModelRequest() {
        System.out.println("Car Make:");
        String makeInput = scanner.nextLine();
        System.out.println("Car Model:");
        String modelInput = scanner.nextLine();

        displayVehicles(dealership.getVehicleByMakeModel(makeInput, modelInput));
    }

    private void processGetByVehicleTypeRequest() {
        System.out.println("What type of vehicle are you searching for?");
        System.out.println("ex. SEDAN, SUV, TRUCK, SPRINTER.");
        VehicleType vehicleTypeInput = VehicleType.valueOf(scanner.nextLine().toUpperCase());

        displayVehicles(dealership.getVehicleByType(vehicleTypeInput));
    }

    private void processGetByYearRequest() {
        System.out.println("Enter Min Year:");
        int minYearInput = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Max Year:");
        int maxYearInput = Integer.parseInt(scanner.nextLine());

        displayVehicles(dealership.getVehicleByYear(minYearInput, maxYearInput));
    }

    private void processGetByColorRequest() {
        System.out.println("What color are you searching for?");
        String userInput = scanner.nextLine();

        displayVehicles(dealership.getVehicleByColor(userInput));

    }

    private void processGetByPriceRequest() {
        System.out.println("Enter Min Price:");
        BigDecimal minPricerInput = new BigDecimal(scanner.nextLine());
        System.out.println("Enter Max Price:");
        BigDecimal maxPriceInput = new BigDecimal(scanner.nextLine());

        displayVehicles(dealership.getVehicleByPrice(minPricerInput, maxPriceInput));
    }

    private void processGetByMileageRequest() {
        System.out.println("Enter Min Mileage:");
        int minMileageInput = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Max Mileage:");
        int maxMileageInput = Integer.parseInt(scanner.nextLine());

        displayVehicles(dealership.getVehicleByMileage(minMileageInput, maxMileageInput));
    }

    private void processAddVehicleRequest() throws IOException {

        System.out.println("========== ADD A NEW VEHICLE ==========");
        System.out.println("New wheels on the lot! Let's get this vehicle registered.\n");

        int vinInput = getValidInt("Enter the vehicle VIN:");

        int yearInput = getValidInt("Enter the vehicle year:");

        System.out.println("Enter the vehicle make (ex. Toyota, Honda, Ford):");
        String makeInput = scanner.nextLine().trim().toUpperCase();

        System.out.println("Enter the vehicle model (ex. Camry, Civic, Mustang):");
        String modelInput = scanner.nextLine().trim().toUpperCase();

        VehicleType vehicleType = getValidVehicleType("Enter the vehicle type (SEDAN, SUV, TRUCK, SPRINTER):");

        System.out.println("Enter the vehicle color:");
        String colourInput = scanner.nextLine().trim().toUpperCase();

        int mileageInput = getValidInt("Enter the vehicle mileage:");

        BigDecimal priceInput = getValidBigDecimal("Enter the vehicle price: $");

        Vehicle newVehicle = new Vehicle(vinInput, yearInput, makeInput, modelInput,
                vehicleType, colourInput, mileageInput, priceInput);
        dealership.addVehicle(newVehicle);

        DealershipFileManager.saveDealership(dealership);
    }

    private void processRemoveVehicleRequest() throws IOException {
        int carRemovalInput = getValidInt("Enter the VIN of the vehicle you want to remove:");

        boolean vehicleFound = false;
        for(Vehicle vehicle : dealership.getAllVehicles()) {
            if (carRemovalInput == vehicle.getVin()) {
                vehicleFound = true;
                dealership.removeVehicle(vehicle);
                break;
            }
        }
            if (vehicleFound == false) {
                System.out.println("Sorry! That vehicle does not exist.\n" +
                        "Please enter a valid VIN.");
            } else {
                DealershipFileManager.saveDealership(dealership);
            }
    }

    //HELPER METHODS FOR INPUT VALIDATIONS
    private int getValidInt(String prompt) {
        int validIntInput = 0;
        while (true) {
            System.out.println(prompt);
            try {
                validIntInput = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }

        }
        return validIntInput;
    }
    private BigDecimal getValidBigDecimal(String prompt) {
        while (true) {
            System.out.println(prompt);

            try {
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid price.");
            }
        }
    }
    private VehicleType getValidVehicleType(String prompt) {
        while (true) {
            System.out.println(prompt);

            try {
                return VehicleType.valueOf(scanner.nextLine().trim().toUpperCase());
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid vehicle type. Please enter SEDAN, SUV, TRUCK, or SPRINTER.");
            }
        }
    }
}

