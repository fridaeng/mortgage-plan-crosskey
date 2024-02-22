package org.example;

import java.io.File;
import java.util.ArrayList;

public class Application {

    /*
     *   Reads file, adds file contents to list of customers
     *   Calculates each customer's mortgage plan
     *   Prints each customer's plan
     */
    public static void main(String[] args) {

        ArrayList<Customer> customers = ProspectsFileReader.readProspectsFile(new File("prospects.txt"));
        runCalculator(customers);

    }

    //Calculates and prints the mortgage plans for each prospect(customer)
    private static void runCalculator(ArrayList<Customer> customers) {
        MortgageCalculator mortgageCalculator = new MortgageCalculator();
        customers = mortgageCalculator.calculateMortgagePlan(customers); //makes calculation and updates customers list with calculated monthly payment
        mortgageCalculator.printCalculations(customers); //prints list of prospects and their info
    }
}
