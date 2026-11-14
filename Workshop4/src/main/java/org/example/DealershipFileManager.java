package org.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class DealershipFileManager {
    public static Dealership getDealership() {

        Dealership dealership = null;

        try {
            FileReader fileReader = new FileReader("src/main/resources/car_inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //This is telling me to read the first line...
            String dealershipInfo = bufferedReader.readLine();
            String[] dealershipData = dealershipInfo.split("\\|");

            String name = dealershipData[0];
            String address = dealershipData[1];
            String phone = dealershipData[2];

            dealership = new Dealership(name, address, phone);


            String row;
            while ((row = bufferedReader.readLine()) != null) {
                String[] brokenUpRow = row.split("\\|");
                int vin = Integer.parseInt(brokenUpRow[0]);
                int year = Integer.parseInt(brokenUpRow[1]);
                String make = brokenUpRow[2];
                String model = brokenUpRow[3];
                VehicleType vehicleType = VehicleType.valueOf(brokenUpRow[4]);
                String color = brokenUpRow[5];
                int odometer = Integer.parseInt(brokenUpRow[6]);
                BigDecimal price = new BigDecimal(brokenUpRow[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                dealership.addVehicle(vehicle);
            } bufferedReader.close();

        } catch (IOException ex) {
            System.out.println("Trouble reading file. Check your file.");
            //ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("...");
            //ex.printStackTrace();
        }
        return dealership;
    }

    public static void saveDealership(Dealership dealership){

    }
}
