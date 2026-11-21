package org.example;

import java.math.BigDecimal;

public abstract class Contract {
    private String contractDate;
    private String contractName;
    private String contractEmail;
    private Vehicle vehicleSold;

    public Contract(String contractDate, String contractName, String contractEmail,
                    Vehicle vehicleSold) {
        this.contractDate = contractDate;
        this.contractName = contractName;
        this.contractEmail = contractEmail;
        this.vehicleSold = vehicleSold;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractEmail() {
        return contractEmail;
    }

    public void setContractEmail(String contractEmail) {
        this.contractEmail = contractEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public abstract BigDecimal getTotalPrice();
    public abstract BigDecimal getMonthlyPayment();

}
