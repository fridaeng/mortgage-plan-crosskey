package org.example;

import java.io.File;
import java.util.ArrayList;

public class Application {

    public void launch(String filePath){

        //get list of customers from input file
        File prospectsInput = new File(filePath);
        ArrayList<Customer> customers = ProspectsFileReader.readProspectsFile(prospectsInput);

        //program enters list into calculator
        MortgageCalculator mortgageCalculator = new MortgageCalculator();
        customers = mortgageCalculator.calculateMortgagePlan(customers); //makes calculation and updates the customers list with calculated monthly payment
        mortgageCalculator.printCalculations(customers); //prints list of prospects and their info
    }
}
