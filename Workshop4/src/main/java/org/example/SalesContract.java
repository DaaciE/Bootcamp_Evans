package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesContract extends Contract {
    private boolean financingOption;
    private BigDecimal recordingFee;
    private BigDecimal salesTax;
    private BigDecimal processingFee;


    public SalesContract(String contractDate, String contractName, String contractEmail,
                         Vehicle vehicleSold, boolean financingOption) {
        super(contractDate, contractName, contractEmail, vehicleSold);
        this.financingOption = financingOption;
        this.recordingFee = new BigDecimal("100.00");
        this.salesTax = vehicleSold.getPrice().multiply(BigDecimal.valueOf(0.05));

        //finding the processing fee
        if(vehicleSold.getPrice().compareTo(new BigDecimal("10000")) < 0) {
            this.processingFee = new BigDecimal("295.00");
        } else{
            this.processingFee = new BigDecimal("495.00");
        }
    }


    @Override
    public BigDecimal getTotalPrice() {
        return getVehicleSold().getPrice()
                .add(salesTax)
                .add(recordingFee)
                .add(processingFee);
    }

    @Override
    public BigDecimal getMonthlyPayment() {

        if(financingOption == false){
            return BigDecimal.ZERO;
        }
        double interestRate;
        int numberOfMonths;

        if(getVehicleSold().getPrice().compareTo(new BigDecimal("10000")) < 0){
            interestRate = 0.0525;
            numberOfMonths = 24;
        } else {
            interestRate = 0.0425;
            numberOfMonths = 48;
        }

        double monthlyInterestRate = interestRate / 12;
        double exponentResult = Math.pow((1 + monthlyInterestRate),numberOfMonths);
        double numerator = monthlyInterestRate * exponentResult;
        double denominator = exponentResult - 1;
        double divisionResult = numerator / denominator;
        BigDecimal newMonthlyPayment = getTotalPrice().multiply(BigDecimal.valueOf(divisionResult));

        return newMonthlyPayment.setScale(2, RoundingMode.HALF_UP);
    }
}

