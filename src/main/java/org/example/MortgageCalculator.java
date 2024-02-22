package org.example;

import java.util.ArrayList;

public class MortgageCalculator {

    /*
     *   Takes a list of customers and calculates the monthly mortgage payment sum
     *   returns the list of customers with set monthlyPayment
     */
    public ArrayList<Customer> calculateMortgagePlan(ArrayList<Customer> customers) {

        for (Customer c : customers) {

            double u = c.getTotalLoan();                    //get the customer's total loan
            double b = c.getInterestRate() / (12 * 100);    //get the customer's interest on a monthly basis
            int p = c.getPaymentYears() * 12;               //get the customer's nr of payment months (total number of payments)

            double e = u * (b * power(1 + b, p)) / (power(1 + b, p) - 1); //mortgage formula

            c.setMonthlyPayment(e);

        }

        return customers;

    }

    //calculates positive exponent to be used in the mortgage calculation
    //TODO: handle negative value cases
    private static double power(double base, int exponent) {
        double result = 1.0;
        while (exponent != 0) {
            result = result * base;
            exponent--;
        }
        return result;

    }

    /*
     *   Takes list of customers prints their loan info and monthly payment plan
     */
    public void printCalculations(ArrayList<Customer> customers) {

        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);

            String name = c.getName();
            double loan = c.getTotalLoan();
            int years = c.getPaymentYears();
            String monthlyPayment = String.format("%.2f", c.getMonthlyPayment());

            System.out.println("Prospect " + (i + 1) + ": " +
                    name +
                    " wants to borrow " + loan + " € " +
                    "for a period of " + years + " years " +
                    "and pay " + monthlyPayment + " € each month");
        }

    }

}
