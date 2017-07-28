package org.academiadecodigo.bootcamp.model;

import org.academiadecodigo.bootcamp.persistence.SuppliesCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TravelDistance {

    public void distance(String origem, String destino) {
        try {

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

            System.out.println(endResult[0]);

            Double km = Double.parseDouble(endResult[0]);

            km = Math.ceil(km / 30);

            int numOfDays = km.intValue();

            SuppliesCalculator.setNumberOfDays(numOfDays);

            System.out.println("numero de dias: " + numOfDays);

        } catch (IOException err) {
            System.out.println(err);
        }
        catch (ArrayIndexOutOfBoundsException err) {
            System.out.println("...");
        }


        System.out.println("___________________________________");

    }

}
