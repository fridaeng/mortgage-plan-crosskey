package org.example;

import java.io.File;
import java.util.ArrayList;

public class MortgageCalculator {

    //makes calculation
    //prints calculation
    public static void calculateMortgagePlan(File file){
        ArrayList<Customer> customers = ProspectsFileReader.readfile(file);

        for (Customer c : customers) {

            double u = c.getTotalLoan();                    //total loan
            double b = c.getInterestRate() / (12 * 100);    //interest on a monthly basis
            int p = c.getPaymentYears() * 12;               //payment months (total number of payments)

            double e = u * (b * power(1 + b, p)) / (power(1 + b, p) - 1); //mortgage formula

            c.setMonthlyPayment(e);

        }

        printCalculations(customers);

    }

    //calculate positive exponent
    private static double power(double base, int exponent){
        double result = 1.0;
        while (exponent != 0){
            result = result * base;
            exponent--;
        }
        return result;

    }

    private static void printCalculations(ArrayList<Customer> customers){

        for (int i=0; i<customers.size(); i++){
            Customer c = customers.get(i);

            String name = c.getName();
            double loan = c.getTotalLoan();
            int years = c.getPaymentYears();
            String monthlyPayment = String.format("%.2f", c.getMonthlyPayment());

            System.out.println("Prospect "+(i+1)+": "+
                    name+
                    " wants to borrow "+loan+" € "+
                    "for a period of "+years+" years "+
                    "and pay "+monthlyPayment+" € each month");
        }

    }

}
