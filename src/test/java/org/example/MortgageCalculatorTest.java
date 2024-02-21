package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MortgageCalculatorTest {

    @Test
    void testCalculateMortgagePlan(){
        File file = new File("test_file_prospects.txt");
        ArrayList<Customer> customers = ProspectsFileReader.readProspectsFile(file);
        MortgageCalculator calculator = new MortgageCalculator();
        customers = calculator.calculateMortgagePlan(customers);

        assertEquals(4, customers.size());
        assertEquals(43.87, customers.get(0).getMonthlyPayment(), 0.01);
        assertEquals(62.87, customers.get(1).getMonthlyPayment(), 0.01);
        assertEquals(59.22, customers.get(2).getMonthlyPayment(), 0.01);
        assertEquals(46.97, customers.get(3).getMonthlyPayment(), 0.01);

    }

    @Test
    void testPrintCalculations() {
        MortgageCalculator mortgageCalculator = new MortgageCalculator();

        //redirect System.out to new ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Mickey Mouse", 1500, 3, 3, 43.62));
        customers.add(new Customer("Donald Duck", 10000, 1.5, 5, 173.10));

        mortgageCalculator.printCalculations(customers);

        //set System.out back to original state
        System.setOut(System.out);

        //get captured output from the ByteArrayOutputStream
        String printedOutput = outputStream.toString();

        assertEquals("Prospect 1: Mickey Mouse wants to borrow 1500.0 € for a period of 3 years and pay 43.62 € each month" + System.lineSeparator() +
                            "Prospect 2: Donald Duck wants to borrow 10000.0 € for a period of 5 years and pay 173.10 € each month" + System.lineSeparator(), printedOutput);
    }
}