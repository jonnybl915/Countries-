package com.theironyard.jdblack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Country> countryArray = new ArrayList<>();

        HashMap<String, ArrayList<Country>> countryMap = new HashMap<>();
        File f = new File("countries.txt");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String countryLine = fileScanner.nextLine();
            String[] columns = countryLine.split("\\|");
            Country country = new Country(columns[0], columns[1]);
            String firstLetter = String.valueOf(country.name.charAt(0));
            countryMap.put(firstLetter, countryArray);
            countryArray.add(country);

            if (!countryMap.containsKey(firstLetter)) {
                countryMap.put(firstLetter, new ArrayList<>());
            }
            System.out.println(countryMap.toString());
        }
        //System.out.println(countryArray);

    }
}






//    public void getMap() throws FileNotFoundException {
//        System.out.println("Please type in a letter.");
//        HashMap<String, ArrayList<Country>> countryMap = new HashMap<>();
//        File f = new File("countries.txt");
//        Scanner fileScanner = new Scanner(f);
//        while (fileScanner.hasNext()) {
//            String countryLine = fileScanner.nextLine();
//            String[] columns = countryLine.split("\\|");
//            Country country = new Country(columns[0], columns[1]);
//            String firstLetter = String.valueOf(country.name.charAt(0));
//            if(!countryMap.containsKey(firstLetter)){
//                countryMap.put(firstLetter, new ArrayList<>());
//            }
//        }
//            System.out.println(countryMap);
//    }
//            Scanner scanner = new Scanner;
//            String letterChoice = scanner.nextLine();


//        for (Country country : countryArray){
//            ArrayList<Country> coun = countryMap.get(country.name);
//            if (coun == null) {
//                coun = new ArrayList<>();
//                coun.add(country);
//            }
//            else{
//                return;
//            }



//            HashMap<String, ArrayList<Email>> map = new HashMap<>();
//            for (Email email : emails){
//                ArrayList<Email> arr = map.get(email.destination);
//                if (arr == null) {
//                    arr = new ArrayList<>();
//                    arr.add(email);
//                    map.put(email.destination, arr);
//
//            countryMap.put(firstLetter, countryArray);
//            System.out.println(country1);
           // if(){

         //   }


            //countryArray.add(country1);

            //countryMap.put(country1.abbreviation, country);

       //System.out.println(countryArray);

