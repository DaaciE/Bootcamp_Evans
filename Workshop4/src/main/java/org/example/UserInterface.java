package org.example;


import javax.print.attribute.standard.NumberUp;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
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
            System.out.println("\nDealership Menu");
            System.out.println("[0] EXIT");
            System.out.println("[1] EXPLORE THE COLLECTION");
            System.out.println("[2] SEARCH BY MAKE/MODEL");
            System.out.println("[3] SEARCH BY VEHICLE TYPE");
            System.out.println("[4] SEARCH BY YEAR");
            System.out.println("[5] SEARCH BY COLOR");
            System.out.println("[6] SEARCH BY PRICE");
            System.out.println("[7] SEARCH BY MILEAGE");
            System.out.println("[8] ADD TO THE COLLECTION");
            System.out.println("[9] REMOVE FROM THE COLLECTION");
            System.out.println("[10] PURCHASE A VEHICLE");
            System.out.println("[11] LEASE A VEHICLE\n");

            System.out.println("Please Enter Your Choice:");
            choice = scanner.nextLine();


            switch (choice) {
                case "0":
                    return;
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
                    processSellVehicleRequest();
                    break;

                case "11":
                    processLeaseVehicleRequest();
                    break;

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
        System.out.println("                                              OUR COLLECTION");
        System.out.println("=".repeat(110));
        System.out.println();

        System.out.printf(
                "%-8s %-6s %-16s %-17s %-10s %-12s %12s %15s%n",
                "VIN", "YEAR", "MAKE", "MODEL",
                "TYPE", "COLOR", "MILEAGE", "PRICE"
        );

        System.out.println("-".repeat(110));

        for (Vehicle vehicle : vehicles) {
            System.out.printf(
                    "%-8d %-6d %-16s %-17s %-10s %-12s %,12d $%,14.2f%n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice().setScale(2, RoundingMode.HALF_UP));
        }

        System.out.println("-".repeat(110));
        System.out.println("                                               END OF COLLECTION");
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

    private void processSellVehicleRequest() throws IOException {
        ContractDataManager contractDataManager = new ContractDataManager();
        String contractDate = LocalDate.now().toString();
        Vehicle selectedVehicle = null;
        boolean financingOption;


        int userInput = getValidInt("Enter VIN of the vehicle:");

        for( Vehicle vehicle : dealership.getAllVehicles()){
            if( userInput == vehicle.getVin()){
                selectedVehicle = vehicle;
                break;
            }
        }
        if (selectedVehicle == null){
            System.out.println("Vehicle not found in our collection!");
            return;
        }

        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Email:");
        String email = scanner.nextLine();

        System.out.println("Would you like to finance this vehicle? (Y/N):");
        String financeInput = scanner.nextLine();

        if(financeInput.equalsIgnoreCase("Y")) {
            financingOption = true;

        } else if (financeInput.equalsIgnoreCase("N")) {
            financingOption = false;
        } else {
            System.out.println("Please enter valid choice (Y/N).");
            return;
        }

        SalesContract sale = new SalesContract(
                contractDate,
                name,
                email,
                selectedVehicle,
                financingOption);

        boolean contractSaved = contractDataManager.saveContract(sale);

        if(contractSaved) {
            dealership.removeVehicle(selectedVehicle);
            DealershipFileManager.saveDealership(dealership);

            System.out.println("Vehicle successfully Sold!");
        }
    }

    private void processLeaseVehicleRequest() throws IOException {
        ContractDataManager contractDataManager = new ContractDataManager();
        String contractDate = LocalDate.now().toString();
        Vehicle selectedVehicle = null;

        int userInput = getValidInt("Enter VIN of the vehicle:");

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (userInput == vehicle.getVin()) {
                selectedVehicle = vehicle;
                break;
            }
        }

        if (selectedVehicle == null) {
            System.out.println("Vehicle not found in our collection!");
            return;
        }


        System.out.println("Enter Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Email:");
        String email = scanner.nextLine();


        LeaseContract lease = new LeaseContract(
                contractDate,
                name,
                email,
                selectedVehicle
        );


        boolean contractSaved = contractDataManager.saveContract(lease);


        if (contractSaved) {
            dealership.removeVehicle(selectedVehicle);
            DealershipFileManager.saveDealership(dealership);

            System.out.println("Vehicle successfully leased!");
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

