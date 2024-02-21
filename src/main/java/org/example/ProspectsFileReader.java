package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProspectsFileReader {

    //method for reading file and putting it in arraylist of customers
    public static ArrayList<Customer> readProspectsFile(File file){
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));

            reader.readLine(); //read the first line but do nothing

            String line;
            while ((line = reader.readLine()) != null) {

                //removes quotes and commas in name
                if (line.contains("\"")){

                    int quoteStart = line.indexOf("\"");
                    int quoteEnd = line.indexOf("\"", quoteStart+1);

                    String name = line.substring(quoteStart+1, quoteEnd);   //gets the name part, excluding the quotes
                    name = name.replace(",", " ");         //remove commas from name

                    line = name + line.substring(quoteEnd+1);      //adds name together with rest of line

                }

                String[] attributes = line.split("[\",]");             //splits line into array of attributes

                //register customer with attributes and add to list
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
                } catch (ArrayIndexOutOfBoundsException e){
                    //System.out.println("Prospect could not be added: Wrong nr of attributes");
                }

            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
