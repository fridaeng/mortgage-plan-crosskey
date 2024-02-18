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

            String line;
            reader.readLine(); //read the first line but do nothing
            while ((line = reader.readLine()) != null){

                String name = "";
                double loan = 0;
                double interest = 0;
                int years = 0;

                String[] attributes = line.split("[\",]+", 0);

                //if attributes is 4 then 0=name,1=loan,2=inter,3=year
                //if attributes is 5 then 0=name,1=name,2=loan,3=inter,4=year
                //possible fix: while attributes[i] is string, concat to name. add rest of attributes [i] to the other attributes
                if (attributes.length == 4){
                    name = attributes[0];
                    loan = Double.parseDouble(attributes[1]);
                    interest = Double.parseDouble(attributes[2]);
                    years = Integer.parseInt(attributes[3]);
                }
                if (attributes.length > 4){
                    name = attributes[1]+" "+attributes[2]; //fix this so that first \" doesnt create empty string
                    loan = Double.parseDouble(attributes[3]);
                    interest = Double.parseDouble(attributes[4]);
                    years = Integer.parseInt(attributes[5]);
                    //System.out.println(attributes.length);
                }

                Customer customer = new Customer();
                //add the attributes from the line to the customer (name, loan, interest, years)

                customer.setName(name);
                customer.setTotalLoan(loan);
                customer.setInterestRate(interest);
                customer.setPaymentYears(years);
                //add to customers
                customers.add(customer);


                System.out.println(line + name); //just a check

            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
