package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProspectsFileReaderTest {

    @Test
    void testReadProspectsFile() {
        File file = new File("test_file_prospects.txt");
        ArrayList<Customer> customers = ProspectsFileReader.readProspectsFile(file);

        assertEquals("Juha", customers.get(0).getName());
        assertEquals(1000.0, customers.get(0).getTotalLoan());
        assertEquals(5.0, customers.get(0).getInterestRate());
        assertEquals(2, customers.get(0).getPaymentYears());

        assertEquals("Karvinen", customers.get(1).getName());
        assertEquals(4356.0, customers.get(1).getTotalLoan());
        assertEquals(1.27, customers.get(1).getInterestRate());
        assertEquals(6, customers.get(1).getPaymentYears());

        assertEquals("Claes Månsson", customers.get(2).getName());
        assertEquals(1300.55, customers.get(2).getTotalLoan());
        assertEquals(8.67, customers.get(2).getInterestRate());
        assertEquals(2, customers.get(2).getPaymentYears());

        assertEquals("Clarencé Andersson", customers.get(3).getName());
        assertEquals(2000.0, customers.get(3).getTotalLoan());
        assertEquals(6.0, customers.get(3).getInterestRate());
        assertEquals(4, customers.get(3).getPaymentYears());

    }

    @Test
    void testReadInvalidFile() {
        File file = new File("invalid_file.txt");
        ArrayList<Customer> customers = ProspectsFileReader.readProspectsFile(file);

        assertTrue(customers.isEmpty());
    }

}