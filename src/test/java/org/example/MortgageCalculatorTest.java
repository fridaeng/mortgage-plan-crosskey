package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MortgageCalculatorTest {

    @Test
    void testCalculateMortgagePlan(){
        File file = new File("test_file_prospects.txt");
        MortgageCalculator calculator = new MortgageCalculator();
        ArrayList<Customer> customers = calculator.calculateMortgagePlan(file);

        assertEquals(4, customers.size());
        assertEquals(43.87, customers.get(0).getMonthlyPayment(), 0.01);
        assertEquals(62.87, customers.get(1).getMonthlyPayment(), 0.01);
        assertEquals(59.22, customers.get(2).getMonthlyPayment(), 0.01);
        assertEquals(46.97, customers.get(3).getMonthlyPayment(), 0.01);

    }

    @Test
    void testPower(){

    }

    @Test
    void testPrintCalculations() {

    }
}