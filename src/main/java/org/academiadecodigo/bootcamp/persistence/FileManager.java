package org.academiadecodigo.bootcamp.persistence;

import java.io.*;

/**
 * Class responsable for Writing and Reading files
 */
public class FileManager {

    /**
     * Saves a .txt file named after the user, with the supplies of the trip
     * @param user
     * @param supplies
     */
    public static void save(String user, String supplies) {

        BufferedWriter outputBufferedWriter = null;


        try {
            outputBufferedWriter = new BufferedWriter(new FileWriter(user + ".txt"));
            outputBufferedWriter.write(supplies, 0, supplies.length());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (outputBufferedWriter != null) {
                    outputBufferedWriter.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Loads a specific file
     * @param fileName name of the file
     * @return the content of the file
     */
    public static String load(String fileName) {

        String line = "";
        String fileContent = "";
        BufferedReader inputBufferedReader;

        try {
            inputBufferedReader = new BufferedReader(new FileReader(fileName + ".txt"));

            while((line = inputBufferedReader.readLine()) != null) {
                fileContent += line + "\n";
            }



        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return fileContent;
    }
}
