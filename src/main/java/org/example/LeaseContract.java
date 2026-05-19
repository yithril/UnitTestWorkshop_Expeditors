package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LeaseContract extends Contract {

    public LeaseContract() {
    }

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    public BigDecimal getExpectedEndingValue() {
        return vehiclePrice().multiply(new BigDecimal("0.40")).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getLeaseFee() {
        return vehiclePrice().multiply(new BigDecimal("0.07")).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getTotalPrice() {
        return getExpectedEndingValue().add(getLeaseFee()).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        return calculateMonthlyPayment(getTotalPrice(), new BigDecimal("0.04"), 48);
    }
}
