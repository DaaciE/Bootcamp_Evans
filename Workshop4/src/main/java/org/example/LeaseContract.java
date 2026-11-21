package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LeaseContract extends Contract {
    private BigDecimal expectedEndValue;
    private BigDecimal leaseFee;

    public LeaseContract(String contractDate, String contractName, String contractEmail,
                         Vehicle vehicleSold) {
        super(contractDate, contractName, contractEmail, vehicleSold);
        this.expectedEndValue = getVehicleSold().getPrice().multiply(BigDecimal.valueOf(0.5));
        this.leaseFee = getVehicleSold().getPrice().multiply(BigDecimal.valueOf(0.07));
    }

    public BigDecimal getExpectedEndValue() {
        return expectedEndValue;
    }

    public void setExpectedEndValue(BigDecimal expectedEndValue) {
        this.expectedEndValue = expectedEndValue;
    }

    public BigDecimal getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(BigDecimal leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = expectedEndValue.add(leaseFee);
        return totalPrice.setScale(2,RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        double interestRate;
        int numberOfMonths;
        BigDecimal newMonthlyLease;

        interestRate = 0.04;
        numberOfMonths = 36;

        double monthlyInterestRate = interestRate / 12;
        double exponentResult = Math.pow((1 + monthlyInterestRate),numberOfMonths);
        double numerator = monthlyInterestRate * exponentResult;
        double denominator = exponentResult - 1;
        double divisionResult = numerator / denominator;

        newMonthlyLease = getTotalPrice().multiply(BigDecimal.valueOf(divisionResult));

        return newMonthlyLease.setScale(2, RoundingMode.HALF_UP);
    }
}
