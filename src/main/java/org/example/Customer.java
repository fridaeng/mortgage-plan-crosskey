package org.example;

public class Customer {

    private String name;
    private double totalLoan;
    private double interestRate;
    private int paymentYears;
    private double monthlyPayment;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getTotalLoan() {
        return totalLoan;
    }
    public void setTotalLoan(double totalLoan) {
        this.totalLoan = totalLoan;
    }

    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getPaymentYears() {
        return paymentYears;
    }
    public void setPaymentYears(int paymentYears) {
        this.paymentYears = paymentYears;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}
