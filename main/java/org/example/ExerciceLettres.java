package org.example;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ExerciceLettres {

    /*=========================================================================*/
    /* LOGGER */
    /*=========================================================================*/

    private static final Logger logger = Logger.getLogger(String.valueOf(ExerciceCounting.class));

    /*=========================================================================*/
    /* SORTIES */
    /*=========================================================================*/

    public static void main(String... args) throws IOException, URISyntaxException {
        analyse();
    }

    /*=========================================================================*/
    /* METHODS  */
    /*=========================================================================*/

    /* Lecture de données */

    private static List<String> readInputData() throws URISyntaxException, IOException {
        URL resource = Main.class.getClassLoader().getResource("listeNombresLettres.txt");
        if (resource == null) {
            throw new FileNotFoundException("Fichier 'listeNombresLettres.txt' non trouvé.");
        }
        return Files.readAllLines(Path.of(resource.toURI()));
    }

    /* Analyse d'une unique ligne de code */

    private static String lecture(String A) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < A.length(); i++) {

            /* --> Cas où le motif extrait comprend un seul caractère*/

            String Z = A.substring(i, i + 1);
            switch (Z) {
                case "1" -> list.add(1);
                case "2" -> list.add(2);
                case "3" -> list.add(3);
                case "4" -> list.add(4);
                case "5" -> list.add(5);
                case "6" -> list.add(6);
                case "7" -> list.add(7);
                case "8" -> list.add(8);
                case "9" -> list.add(9);
                default -> {}
            }

            /* --> Cas où le motif extrait comprend 3 caractères*/

            if (i + 2 < A.length()) {
                String B = A.substring(i, i + 3);
                switch (B) {
                    case "one" -> list.add(1);
                    case "two" -> list.add(2);
                    case "six" -> list.add(6);
                    default -> {}
                }
            }

            /* --> Cas où le motif extrait comprend 4 caractères*/

            if (i + 3 < A.length()) {
                String B = A.substring(i, i + 4);
                switch (B) {
                    case "four" -> list.add(4);
                    case "five" -> list.add(5);
                    case "nine" -> list.add(9);
                    default -> {}
                }
            }

            /* --> Cas où le motif extrait comprend 5 caractères*/

            if (i + 4 < A.length()) {
                String B = A.substring(i, i + 5);
                switch (B) {
                    case "three" -> list.add(3);
                    case "seven" -> list.add(7);
                    case "eight" -> list.add(8);
                    default -> {}
                }
            }
        }

        return String.valueOf(list.getFirst() * 10 + list.getLast());
    }

    /* Analyse de chacune des lignes  */

    private static void analyse() throws URISyntaxException, IOException {
        int somme =0;
        for (String element : readInputData()) {
            logger.info(lecture(element));
            somme= somme+Integer.parseInt(lecture(element));
        }
        logger.info("La somme finale vaut :"+ somme);
    }
}