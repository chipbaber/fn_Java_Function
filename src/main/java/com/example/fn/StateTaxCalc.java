package com.example.fn;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StateTaxCalc {
    //variable to hold state name and rate
    public List<List<String>> rateCard = new ArrayList<>();

    public static class Input {
        public String state;
        public double price;
    }

    public static class Result {
        public String state;
        public double price;
        public double tax_rate;
        public double tax;
        public double total_cost;
    }

    /*
    Method to read .csv for state name and rate rows, send row to getRecordFromLine() method.
     */
    private void loadStateTaxRates() {
        try {
            List<List<String>> rates = new ArrayList<>();
             try (Scanner scanner = new Scanner(new File("stateRates.csv"));) {
                while (scanner.hasNextLine()) {
                    rateCard.add(getRecordFromLine(scanner.nextLine()));
                }
            }
        }
        catch (Exception e) {
           System.out.println("Error loading State Rates: "+e.toString());
        }
    }

    /*
    Method to process state name and rate, columes into single List
     */
    private List<String>  getRecordFromLine(String line) {
        List<String> temp = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                temp.add(rowScanner.next());
            }
        }
        catch (Exception e) {
            System.out.println("Error parsing rows into array in getRecordFromLine: "+e.toString());
        }
        return temp;
    }

    /*
    Fn Result method gathers and returns json result
     */
    public Result calcTotalCost(Input input) {
        Result result = new Result();
        result.state = input.state;
        result.price = input.price;
        result.tax_rate = .05;
        result.tax = input.price*(.05);
        result.total_cost = input.price*(1+.05);
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println("Testing the core .csv read and processing");
        StateTaxCalc a = new StateTaxCalc();
        a.loadStateTaxRates();
        System.out.println(a.rateCard.size());
    }

}