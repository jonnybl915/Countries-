package com.theironyard.jdblack;
import jodd.json.JsonSerializer;
import java.io.File;
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
        writeFile(letterChoice, countryArrayList.toString());
        writeFileJson(countryArrayList, letterChoice);
        System.out.println(countryMap);
    }
    public static void writeFile(String letterChoice, String countryData) throws IOException {

        File countryFile = new File (String.format("%s_Countries.txt", letterChoice));
        FileWriter fw = new FileWriter(countryFile);
        fw.write(countryData);
        fw.close();
    }
    public static void writeFileJson(ArrayList countryArrayList, String letterChoice) throws IOException {
        File f = new File(String.format("%scountry.json", letterChoice));
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(countryArrayList);
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }
}