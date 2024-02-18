package org.example;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProspectsFileReader {

    //ArrayList<Customer> customers = new ArrayList<Customer>();

    //method for reading file and putting it in arraylist of prospect objects

    void readfile(File file){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));

            String line;
            while ((line = reader.readLine()) != null){

                //Customer customer = new Customer();
                //add the attributes from the line to the customer (name, loan, interest, years)
                //add to customers
                //customers.add(customer);


                System.out.println(line); //just a check

            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
