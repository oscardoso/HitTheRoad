package org.academiadecodigo.bootcamp.model;

import org.academiadecodigo.bootcamp.persistence.SuppliesCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TravelDistance {

    private static String originDestiny;
    private static String origemFinal;
    private static String destinoFinal;
    private static int numberOfDays;
    private static int kilometres;

    public static void distance (String origem, String destino) {

        try {

            originDestiny = origem + destino;

            String line, outputString = "";

            URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origem + "&destinations=" + destino + "&mode=walking");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                outputString += line;
            }

            System.out.println(outputString);

            String[] result = outputString.split("\"text\" : \"");

            String endResult[] = result[1].split(" ");

            Double km = Double.parseDouble(endResult[0]);
            kilometres = km.intValue();
            km = Math.ceil(km / 30);

            int numOfDays = km.intValue();

            SuppliesCalculator.setNumberOfDays(numOfDays);

            origemFinal = origem;
            destinoFinal = destino;

            numberOfDays = numOfDays;

            SuppliesCalculator.setNumberOfDays(numberOfDays);

        } catch (IOException err) {
            System.out.println(err);
        }
        catch (ArrayIndexOutOfBoundsException err) {
            System.out.println("...");
        }


        System.out.println("___________________________________");

    }

    public static String getOriginDestiny() {
        return originDestiny;
    }


    public static String getOrigemFinal() {
        return origemFinal;
    }

    public static String getDestinoFinal() {
        return destinoFinal;
    }

    public static int getNumberOfDays() {
        return numberOfDays;
    }

    public static int getKilometres() {
        return kilometres;
    }

    public static void setOriginDestiny() {
        originDestiny = "";
    }

}
