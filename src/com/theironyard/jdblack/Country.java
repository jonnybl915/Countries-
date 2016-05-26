package com.theironyard.jdblack;

/**
 * Created by jonathandavidblack on 5/26/16.
 */
public class Country {
    String abbreviation;
    String name;


    @Override
    public String toString() {
        return
                 name;

    }

    public Country(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }
}
