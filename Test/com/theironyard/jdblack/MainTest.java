package com.theironyard.jdblack;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by jonathandavidblack on 5/29/16.
 */
public class MainTest {
    @Test
    public void readCountriesFromFile() throws Exception {
        HashMap<String, ArrayList<Country>> testCountryData = Main.readCountriesFromFile("countries.txt");
        assertEquals(15, testCountryData.get("a").size());

    }

    @Test
    public void writeFile() throws Exception {

    }

    @Test
    public void writeFileJson() throws Exception {

    }

}