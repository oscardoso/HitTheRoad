package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.model.TravelDistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by codecadet on 28/07/2017.
 */
public class testurl {

    public static void main(String[] args) throws IOException {

        TravelDistance travelDistance = new TravelDistance();

        while (true) {


            Scanner bla = new Scanner(System.in);
            String cenas = bla.nextLine();
            String origem = "";

            if (cenas.split(" ").length > 1) {
                origem += cenas.replace(" ", "");
            } else {
                origem = cenas;
            }

            System.out.println(origem);

            Scanner blabla = new Scanner(System.in);
            String to = blabla.nextLine();
            String destino = "";

            if (to.split(" ").length > 1) {
                destino += to.replace(" ", "");
            } else {
                destino = to;
            }

            System.out.println(destino);

            travelDistance.distance(origem, destino);
        }

    }


}
