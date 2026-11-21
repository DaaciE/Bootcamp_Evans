package org.example;

import java.math.BigDecimal;

public class LeaseContract extends Contract {
    public LeaseContract(String contractDate, String contractName, String contractEmail, Vehicle vehicleSold) {
        super(contractDate, contractName, contractEmail, vehicleSold);
    }

    @Override
    public BigDecimal getTotalPrice() {
        return null;
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        return null;
    }
}
