package org.academiadecodigo.bootcamp.persistence;

import org.academiadecodigo.bootcamp.service.jdbc.SuppliesType;

/**
 * Created by codecadet on 28/07/2017.
 */
public class SuppliesCalculator {

    private static String displayText;
    private static int numberOfDays;

    public static void addToDisplayText(String text) {
        displayText += text;
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

        if(numberOfDays >= 5) {

            displayText = String.valueOf(numberOfDays * 2) + " " + SuppliesType.values()[0].getDescription() + "\n" + String.valueOf(numberOfDays * 2) +
                    " " + SuppliesType.values()[1].getDescription() + "\n" + String.valueOf(numberOfDays * 2) + " " + SuppliesType.values()[2].getDescription() +
            "\n (opc) " + String.valueOf(numberOfDays * 2) + " " + SuppliesType.values()[3].getDescription() + "\n" +
            String.valueOf(numberOfDays / 2) + " " + SuppliesType.values()[4].getDescription() + "\n" + String.valueOf(numberOfDays / 2) + " " +
            SuppliesType.values()[5].getDescription() + "\n" + SuppliesType.DUMDUM.getDescription() + "\n" + SuppliesType.CANIVETEBEARGRYLLS.getDescription() +
            "\n" + SuppliesType.TOALHETES.getDescription() + "\n" + SuppliesType.DESODORIZANTE.getDescription() + "\n" + String.valueOf(numberOfDays / 2) + " " +
            SuppliesType.PAPELHIGIENICO.getDescription() + "\n" + String.valueOf(numberOfDays / 2) + " caixas " + SuppliesType.PRESERVATIVOS.getDescription() + "\n" + SuppliesType.SACOCAMA.getDescription() +
            "\nRepor stock ao fim " + "\ndo quinto dia.";
        }
        else if (numberOfDays >= 2) {

            displayText = String.valueOf(numberOfDays * 2) + " " + SuppliesType.values()[0].getDescription() + "\n" + String.valueOf(numberOfDays * 2) +
                    " " + SuppliesType.values()[1].getDescription() + "\n" + String.valueOf(numberOfDays * 2) + " " + SuppliesType.values()[2].getDescription() +
                    "\n (opcional) " + String.valueOf(numberOfDays * 2) + " " + SuppliesType.values()[3].getDescription() + "\n" +
                    String.valueOf(numberOfDays / 2) + " " + SuppliesType.values()[4].getDescription() + "\n" + String.valueOf(numberOfDays / 2) + " " +
                    SuppliesType.values()[5].getDescription() + "\n" + SuppliesType.DUMDUM.getDescription() + "\n" + SuppliesType.CANIVETEBEARGRYLLS.getDescription() +
                    " " + SuppliesType.TOALHETES.getDescription() + "\n" + SuppliesType.DESODORIZANTE.getDescription() + "\n" + String.valueOf(numberOfDays / 2) + " " +
                    SuppliesType.PAPELHIGIENICO.getDescription() + "\n" + String.valueOf(numberOfDays / 2) + " caixas " + SuppliesType.PRESERVATIVOS.getDescription() + "\n" + SuppliesType.SACOCAMA.getDescription();

            return;
        }
        else {
            displayText = "2 " + SuppliesType.values()[0].getDescription() + "\n2 " + SuppliesType.values()[1].getDescription() +
                    "\n2 " + SuppliesType.values()[2].getDescription() + "\n(opcional) 2 " + SuppliesType.values()[3].getDescription() +
                    "\n1 rolo " + SuppliesType.values()[10].getDescription() + "\n " + SuppliesType.values()[11].getDescription();
        }

    }
}
