package com.theironyard.jdblack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        HashMap<String, ArrayList<Country>> countryMap = new HashMap<>();
        File f = new File("countries.txt");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String countryLine = fileScanner.nextLine();
            String[] columns = countryLine.split("\\|");
            Country country = new Country(columns[0], columns[1]);
            String firstLetter = String.valueOf(country.name.charAt(0));
            if (!countryMap.containsKey(firstLetter)) {
                countryMap.put(firstLetter, new ArrayList<>());
            }
            countryMap.get(firstLetter).add(country);

        }
        System.out.println("Please type a letter.");
        Scanner scanner = new Scanner(System.in);
        String letterChoice = scanner.nextLine();
        if (letterChoice.length()!=1) {
            throw new Exception("Please enter one SINGLE letter!");
        }
        ArrayList countryArrayList = countryMap.get(letterChoice);
        System.out.println(countryArrayList);

        File countryFile = new File (String.format("%s_Countries.txt", letterChoice));
        FileWriter fw = new FileWriter(countryFile);
        fw.write(countryArrayList.toString());
        fw.close();
    }
}