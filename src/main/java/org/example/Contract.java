package org.example;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "contractType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SalesContract.class, name = "SALE"),
        @JsonSubTypes.Type(value = LeaseContract.class, name = "LEASE")
})
public abstract class Contract {
    private static final MathContext MATH_CONTEXT = new MathContext(10, RoundingMode.HALF_UP);
    private static final int MONEY_SCALE = 2;

    private String date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;

    public Contract() {
    }

    public Contract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    protected BigDecimal vehiclePrice() {
        return BigDecimal.valueOf(getVehicleSold().getPrice()).setScale(MONEY_SCALE, RoundingMode.HALF_UP);
    }

    protected static BigDecimal money(String amount) {
        return new BigDecimal(amount).setScale(MONEY_SCALE, RoundingMode.HALF_UP);
    }

    protected static BigDecimal calculateMonthlyPayment(BigDecimal principal, BigDecimal annualRate, int months) {
        BigDecimal monthlyRate = annualRate.divide(BigDecimal.valueOf(12), MATH_CONTEXT);
        BigDecimal onePlusRate = BigDecimal.ONE.add(monthlyRate);
        BigDecimal factor = onePlusRate.pow(months, MATH_CONTEXT);
        BigDecimal numerator = principal.multiply(monthlyRate, MATH_CONTEXT).multiply(factor, MATH_CONTEXT);
        BigDecimal denominator = factor.subtract(BigDecimal.ONE, MATH_CONTEXT);
        return numerator.divide(denominator, MONEY_SCALE, RoundingMode.HALF_UP);
    }

    public abstract BigDecimal getTotalPrice();

    public abstract BigDecimal getMonthlyPayment();
}
