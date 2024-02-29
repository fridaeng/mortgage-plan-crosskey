package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProspectsFileReader {

    /*
     *   Reads a file and puts it in list of customers
     *   returns the list of customers
     */
    public static ArrayList<Customer> readProspectsFile(File file) {
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            //reads the file line by line
            BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));
            String line;

            while ((line = reader.readLine()) != null) {

                if (line.contains("\"")) {
                    line = removeQuotesAndCommasInName(line);
                }

                String[] attributes = line.split(","); //splits line into array of attributes by commas

                registerNewCustomer(customers, attributes); //creates new customer with attributes and adds it to customers

            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }

    /*
     *   Some lines in the input file may have names written in quotes
     *   This method removes the quotes and any commas in the name
     *   Finally it adds name together with the rest of the line, so that it can later be split up into attributes
     */
    private static String removeQuotesAndCommasInName(String line) {
        int quoteStart = line.indexOf("\"");
        int quoteEnd = line.indexOf("\"", quoteStart + 1);

        String name = line.substring(quoteStart + 1, quoteEnd);   //gets the name part, excluding the quotes
        name = name.replace(",", " ");         //remove commas from name

        line = name + line.substring(quoteEnd + 1);      //adds name together with rest of line

        return line;
    }

    /*
     *   Creates a new customer and adds attributes to it from a string array
     *   Converts attributes with number values into double and int
     *   Exceptions to ignore for example empty lines or attributes that are in the wrong format
     */
    private static void registerNewCustomer(ArrayList<Customer> customers, String[] attributes) {
        Customer customer = new Customer();

        try {
            customer.setName(attributes[0]);
            customer.setTotalLoan(Double.parseDouble(attributes[1]));
            customer.setInterestRate(Double.parseDouble(attributes[2]));
            customer.setPaymentYears(Integer.parseInt(attributes[3]));

            customers.add(customer);
            //System.out.println("Prospect successfully added");

        } catch (IllegalArgumentException e) {
            //System.out.println("Prospect could not be added: Illegal attribute");
        } catch (ArrayIndexOutOfBoundsException e) {
            //System.out.println("Prospect could not be added: Wrong nr of attributes");
        }

    }

}
