package org.example;

import java.io.File;
import java.util.ArrayList;

public class MortgageCalculator {


    //makes calculation
    //prints everything out

    public static void calculateMortgagePlan(File file){
        ArrayList<Customer> customers = ProspectsFileReader.readfile(file);

        for (int i = 0; i<customers.size(); i++){

            String customerName = customers.get(i).getName();
            double u = customers.get(i).getTotalLoan(); // total loan
            double b = customers.get(i).getInterestRate()/(12 * 100); //interest on a monthly basis
            int years = customers.get(i).getPaymentYears();
            int p = years*12; //total number of payments

            double monthlyPayment = u * (b * power(1+b, p)) / (power(1+b, p) - 1); //mortgage formula



            System.out.println("Prospect "+ (i+1) + ": "+customerName+" wants to borrow "+u+" € for a period of "+years+" years and pay "+monthlyPayment+" € each month");

        }

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

    //test
    /*
    public static void prinnnt(){
        double i = (double) 5 /(12*100);
        int y = 4*12;
        double pow = power(i, y);
        System.out.println(pow);
    }
    */


}
