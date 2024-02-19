package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProspectsFileReader {

    //method for reading file and putting it in arraylist of prospect objects

    public static ArrayList<Customer> readfile(File file){
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));

            reader.readLine(); //read the first line but do nothing

            String line;
            while ((line = reader.readLine()) != null) {

                String[] attributes = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); //split line by commas that are not surrounded by quotes

                //TODO: check that line is written in the right format: String, double, double, int
                if (attributes.length == 4){
                    //register customer with attributes and add to list
                    Customer customer = new Customer();

                    customer.setName(attributes[0]);
                    customer.setTotalLoan(Double.parseDouble(attributes[1]));
                    customer.setInterestRate(Double.parseDouble(attributes[2]));
                    customer.setPaymentYears(Integer.parseInt(attributes[3]));

                    customers.add(customer);

                } else {
                    //TODO: wrong nr of attributes
                }

            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
