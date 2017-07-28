package org.academiadecodigo.bootcamp.persistence;

/**
 * Created by codecadet on 28/07/2017.
 */
public class SuppliesCalculator {

    public static String displayText;

    public static void addSupplies(String supplies) {
        displayText += supplies;
    }

    public static void resetDisplayText() {
        displayText = "";
    }

    public static String displayText() {
        return displayText;
    }
}
