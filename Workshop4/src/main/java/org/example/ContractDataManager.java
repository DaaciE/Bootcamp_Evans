package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;

public class ContractDataManager {
    public void saveContract (Contract contract){

        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/contracts.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            if (contract instanceof SalesContract) {
                System.out.println("This is a sales contract!");

                SalesContract sale = (SalesContract) contract;

                String saleLine = String.format("%s|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%s|%s|%s|%s|%s|%s|%s",
                        "SALE",
                        contract.getContractDate(),
                        contract.getContractName(),
                        contract.getContractEmail(),
                        contract.getVehicleSold().getVin(),
                        contract.getVehicleSold().getYear(),
                        contract.getVehicleSold().getMake(),
                        contract.getVehicleSold().getModel(),
                        contract.getVehicleSold().getVehicleType(),
                        contract.getVehicleSold().getColor(),
                        contract.getVehicleSold().getOdometer(),
                        contract.getVehicleSold().getPrice().setScale(2, RoundingMode.HALF_UP),
                        sale.getSalesTax(),
                        sale.getRecordingFee(),
                        sale.getProcessingFee(),
                        sale.getTotalPrice(),
                        sale.isFinancingOption(),
                        sale.getMonthlyPayment());

                bufferedWriter.write(saleLine);
                bufferedWriter.newLine();

            } else if (contract instanceof LeaseContract) {
                System.out.println("This is a lease contract!");

                LeaseContract lease = (LeaseContract) contract;

                String leaseLine = String.format("%s|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%s|%s|%s|%s|%s",
                        "LEASE",
                        contract.getContractDate(),
                        contract.getContractName(),
                        contract.getContractEmail(),
                        contract.getVehicleSold().getVin(),
                        contract.getVehicleSold().getYear(),
                        contract.getVehicleSold().getMake(),
                        contract.getVehicleSold().getModel(),
                        contract.getVehicleSold().getVehicleType(),
                        contract.getVehicleSold().getColor(),
                        contract.getVehicleSold().getOdometer(),
                        contract.getVehicleSold().getPrice().setScale(2, RoundingMode.HALF_UP),
                        lease.getExpectedEndValue(),
                        lease.getLeaseFee(),
                        lease.getTotalPrice(),
                        lease.getMonthlyPayment());

                bufferedWriter.write(leaseLine);
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
