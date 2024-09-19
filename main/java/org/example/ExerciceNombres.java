package org.example;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class ExerciceNombres {

    /*=========================================================================*/
    /* LOGGER */
    /*=========================================================================*/

    private static final Logger logger = Logger.getLogger(String.valueOf(ExerciceCounting.class));

    /*=========================================================================*/
    /* SORTIES */
    /*=========================================================================*/
    public static void main(String... args) throws IOException, URISyntaxException {
        resolution(readInputData());
    }
    /*=========================================================================*/
    /* METHODS  */
    /*=========================================================================*/

    /* Lecture de données */

    private static List<String> readInputData() throws URISyntaxException, IOException {
        URL resource = Main.class.getClassLoader().getResource("listeNombresChiffres.txt");
        if (resource == null){
            throw new FileNotFoundException("Fichier 'listeNombresChiffres.txt' non trouvé.");
        }
        return Files.readAllLines(Path.of(resource.toURI()));
    }

    /* Parcourir une chaine de caracteres */

    private static String lecture(String chain) {
        List<Character> list = Arrays.asList('1','2','3','4','5','6','7','8','9');
        String nombre = "";
        for(char element : chain.toCharArray()){
            if (list.contains(element))
                nombre=nombre.concat(String.valueOf(element));
        }
        String debut = nombre.substring(0,1);
        String fin = String.valueOf(nombre.charAt(nombre.length()-1));

        return debut.concat(fin);
    }

    /* Resolution */

    private static void resolution(List<String> A) {
        int somme = 0;
        for (String element : A) {
            logger.info(lecture(element));
            somme = somme + Integer.parseInt(lecture(element));
        }
        logger.info("La somme vaut "+ somme+ ".");
      }
    }