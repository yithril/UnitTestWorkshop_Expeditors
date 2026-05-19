package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesContract extends Contract {
    private static final BigDecimal TEN_THOUSAND = money("10000.00");

    private boolean financed;

    public SalesContract() {
    }

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean financed) {
        super(date, customerName, customerEmail, vehicleSold);
        this.financed = financed;
    }

    public BigDecimal getSalesTaxAmount() {
        return vehiclePrice().multiply(new BigDecimal("0.005")).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getRecordingFee() {
        return money("100.00");
    }

    public BigDecimal getProcessingFee() {
        return vehiclePrice().compareTo(TEN_THOUSAND) <= 0 ? money("295.00") : money("495.00");
    }

    public boolean isFinanced() {
        return financed;
    }

    public void setFinanced(boolean financed) {
        this.financed = financed;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return vehiclePrice()
                .add(getSalesTaxAmount())
                .add(getRecordingFee())
                .add(getProcessingFee())
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        if (!financed) {
            return money("0.00");
        }

        if (vehiclePrice().compareTo(TEN_THOUSAND) >= 0) {
            return calculateMonthlyPayment(vehiclePrice(), new BigDecimal("0.0425"), 48);
        }

        return calculateMonthlyPayment(vehiclePrice(), new BigDecimal("0.0525"), 24);
    }
}
