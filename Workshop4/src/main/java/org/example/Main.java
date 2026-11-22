package org.example;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        TESTING
        Vehicle chicken = new Vehicle(10122, 2020, "Kia", "Forte", VehicleType.SEDAN, "Black", 108005, BigDecimal.valueOf(25000)); //BigDecimal.valueOf()
        Dealership dealership = DealershipFileManager.getDealership();

        dealership.getAllVehicles().size();
        System.out.println("Total vehicles in inventory: " + dealership.getAllVehicles().size());

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            System.out.printf("%d|%d|%s|%s|%s|%s|%d|%s%n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice());
        } */
        /*
        System.out.println("========== SALES CONTRACT TEST ==========");
        System.out.println("Vehicle Price: $" + testVehicle.getPrice());
        System.out.println("Total Price: $" + testSale.getTotalPrice());
        System.out.println("Monthly Payment: $" + testSale.getMonthlyPayment());

        System.out.println("========== LEASE CONTRACT TEST ==========");
        System.out.println("Vehicle Price: $" + testVehicle2.getPrice());
        System.out.println("Expected Ending Value: $" + testLease.getExpectedEndValue());
        System.out.println("Lease Fee: $" + testLease.getLeaseFee());
        System.out.println("Total Lease Price: $" + testLease.getTotalPrice());
        System.out.println("Monthly Payment: $" + testLease.getMonthlyPayment());

         */

        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface();
        ui.display();

    }
}