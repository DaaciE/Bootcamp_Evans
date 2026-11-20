package org.example;


import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

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

    public static void saveDealership(Dealership dealership) throws IOException {
    try {
        FileWriter fileWriter = new FileWriter("src/main/resources/car_inventory.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String line = String.format("%s|%s|%s",
                dealership.getName(),
                dealership.getAddress(),
                dealership.getPhone());

        bufferedWriter.write(line);
        bufferedWriter.newLine();


        for(Vehicle vehicle : dealership.getAllVehicles()) {
            String line2 = String.format("%d|%d|%s|%s|%s|%s|%d|%s",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice().setScale(2, RoundingMode.HALF_UP));

            bufferedWriter.write(line2);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        System.out.println("Action Successful!");

    } catch (IOException ex){
        System.out.println("Trouble writing file. Check your file.");
        //ex.printStackTrace();
    }catch (Exception ex) {
        System.out.println("...");
        //ex.printStackTrace();
    }
    }
}
