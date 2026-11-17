package org.example;

import java.math.BigDecimal;
import java.time.Year;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost,
                   String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue(){
     int vehicleAge = Year.now().getValue() - year;
     BigDecimal depreciationRate = BigDecimal.ZERO;
     BigDecimal vehicleValue = BigDecimal.ZERO;

     if (vehicleAge >= 0 && vehicleAge <= 3) {
         depreciationRate = new BigDecimal("0.03");
     } else if (vehicleAge >= 4 && vehicleAge <= 6) {
         depreciationRate = new BigDecimal("0.06");
     } else if (vehicleAge >= 7 && vehicleAge <= 10) {
        depreciationRate = new BigDecimal("0.08");
     } else if (vehicleAge > 10) {
         vehicleValue = new BigDecimal(1000);
     } else{
         throw new IllegalArgumentException("Please choose a valid condition (1-4)!");
     }

        if (odometer > 100000 &&
                !makeModel.toLowerCase().contains("honda") &&
                !makeModel.toLowerCase().contains("toyota")) {

            vehicleValue = vehicleValue.multiply(new BigDecimal("0.75"));
        }

        return vehicleValue;
    }
}
