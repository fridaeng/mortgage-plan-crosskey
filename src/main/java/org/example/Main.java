package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        ProspectsFileReader reader = new ProspectsFileReader();
        File prospectsfile = new File("prospects.txt"); //give file from input?
        reader.readfile(prospectsfile);
        //System.out.println("Prospect n: CustomerName wants to borrow X € for a period of Z years and pay E € each month");
    }
}