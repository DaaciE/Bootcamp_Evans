package org.example;


import java.math.BigDecimal;

public class House extends Asset {
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, BigDecimal originalCost,
                 String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public BigDecimal getValue() {
        BigDecimal pricePerSqFoot = BigDecimal.ZERO;
        BigDecimal sqFootResult = BigDecimal.ZERO;
        BigDecimal pricePerLotSqFoot = BigDecimal.valueOf(.25);
        BigDecimal lotSzResult = BigDecimal.ZERO;

        //STEP 1
        //(sqFt x Rate) + (lotSz x .25)
        if (condition == 1) {
            pricePerSqFoot = new BigDecimal(180);
        } else if (condition == 2) {
            pricePerSqFoot = new BigDecimal(130);
        } else if (condition == 3) {
            pricePerSqFoot = new BigDecimal(90);
        } else if (condition == 4) {
            pricePerSqFoot = new BigDecimal(80);
        } else{
            throw new IllegalArgumentException("Please choose a valid condition (1-4)!");
        }
        //STEP 2
        sqFootResult = pricePerSqFoot.multiply(new BigDecimal(squareFoot));
        lotSzResult = pricePerLotSqFoot.multiply(new BigDecimal(lotSize));

        //STEP 3
        return sqFootResult.add(lotSzResult);
    }
}

