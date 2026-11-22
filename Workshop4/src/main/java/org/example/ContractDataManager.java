package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;

public class ContractDataManager {
    public boolean saveContract (Contract contract){

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
                        sale.getSalesTax().setScale(2, RoundingMode.HALF_UP),
                        sale.getRecordingFee().setScale(2, RoundingMode.HALF_UP),
                        sale.getProcessingFee().setScale(2, RoundingMode.HALF_UP),
                        sale.getTotalPrice().setScale(2, RoundingMode.HALF_UP),
                        sale.isFinancingOption(),
                        sale.getMonthlyPayment().setScale(2, RoundingMode.HALF_UP));

                bufferedWriter.write(saleLine);
                bufferedWriter.newLine();

            }
            else if (contract instanceof LeaseContract) {
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
                        lease.getExpectedEndValue().setScale(2, RoundingMode.HALF_UP),
                        lease.getLeaseFee().setScale(2, RoundingMode.HALF_UP),
                        lease.getTotalPrice().setScale(2, RoundingMode.HALF_UP),
                        lease.getMonthlyPayment().setScale(2, RoundingMode.HALF_UP));

                bufferedWriter.write(leaseLine);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            return true;

        } catch (IOException ex){
            System.out.println("Trouble writing file. Check your file.");
            return false;
            //ex.printStackTrace();
        }catch (Exception ex) {
            System.out.println("Something went wrong while saving the contract.");
            return false;
            //ex.printStackTrace();
        }

    }
}
