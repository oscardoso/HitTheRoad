package org.academiadecodigo.bootcamp.persistence;

import org.academiadecodigo.bootcamp.service.jdbc.SuppliesType;

/**
 * Created by codecadet on 28/07/2017.
 */
public class SuppliesCalculator {

    private static String displayText;
    private static int numberOfDays;

    public static void addSupplies(String supplies) {
        displayText += supplies;
    }

    public static void resetDisplayText() {
        displayText = "";
    }

    public static String displayText() {
        calculateSupplies();
        return displayText;
    }

    public static void setNumberOfDays(int numberOfDays) {
        SuppliesCalculator.numberOfDays = numberOfDays;
    }

    private static void calculateSupplies() {

        if(numberOfDays < 2) {
            displayText = "2 " + SuppliesType.values()[0] + "\n 2 " + SuppliesType.values()[1] +
                    "\n 2 " + SuppliesType.values()[2] + "\n (opcional) 2 " + SuppliesType.values()[3] +
                    "1 rolo " + SuppliesType.values()[10];
        }

    }
}
