package org.example;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //TODO: too much happening in main

        ArrayList<Customer> customers;

        //program starts calculator
        MortgageCalculator mortgageCalculator = new MortgageCalculator();

        //get file or input
        File prospectsInput = new File("prospects.txt");

        //program enters file into calculator (when prompted with input?)
        customers = mortgageCalculator.calculateMortgagePlan(prospectsInput);

        mortgageCalculator.printCalculations(customers);

    }
}