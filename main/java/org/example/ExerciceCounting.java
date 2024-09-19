package org.example;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Logger;

public class ExerciceCounting {

    /*=========================================================================*/
    /* LOGGER */
    /*=========================================================================*/

    private static final Logger logger = Logger.getLogger(String.valueOf(ExerciceCounting.class));

    /*=========================================================================*/
    /* SORTIES */
    /*=========================================================================*/
    public static void main(String[] args) throws IOException, URISyntaxException {
        popGreediestElf(computeCalories(readInputData()));
    }

    /*=========================================================================*/
    /* METHODS  */
    /*=========================================================================*/

    /* Lecture de données */

    private static List<String> readInputData() throws URISyntaxException, IOException {
        URL resource = Main.class.getClassLoader().getResource("listeCalories.txt");
        if (resource == null){
            throw new FileNotFoundException("Fichier 'listeCalories.txt' non trouvé.");
        }
        return Files.readAllLines(Path.of(resource.toURI()));
    }

    /* Compter les calories */

    private static List<Integer> computeCalories(List<String> data) {
        List<Integer> calories = new ArrayList<>();
        int somme = 0;
        int i = 0;
        for (String element : data) {
            if (!element.isEmpty()) {
                somme = somme + Integer.parseInt(element);
                continue;
            }
            calories.add(somme);
            somme = 0;
            i = i + 1;
        }
        return calories;
    }

    /* Classer les elfes */

    private static void popGreediestElf(List<Integer> calories) {
        for (int m=0;m<3;m++){
        int maximumCalories = Collections.max(calories);
        int indice = calories.indexOf(maximumCalories);
            logger.info("Elfe gourmand n°"+ (indice+1) + " : (" + maximumCalories +")");
            calories.remove(calories.get(indice));
        }
    }

}

