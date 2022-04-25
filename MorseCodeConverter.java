import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
    private static MorseCodeTree tre = new MorseCodeTree();

    public MorseCodeConverter() {

    }
    /**
     * converts a file of morse code into english each letter is delimited by a space
     * @param codeFile
     * @return
     */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        ArrayList<String> stream = new ArrayList<String>();
        Scanner inputFile = new Scanner(codeFile);
        String[] words;
        String[] characters;


        while(inputFile.hasNext())
            stream.add(inputFile.nextLine());
        inputFile.close();
        // loop through the lines in array list
        for (String s : stream) {
            words = s.split(" / ");
            for (String word : words) {
                characters = word.split(" ");
                for (String character : characters) result.append(tre.fetch(character));

                // add space after each letter
                result.append(" ");
            }
        }
        result = new StringBuilder(result.toString().trim());
        return result.toString();
    }

    /**
     * converts Morse code into english
     * @param code
     * @return
     */
    public static String convertToEnglish(String code) {
        StringBuilder result = new StringBuilder();
        String[] words;
        String[] characters;

        words = code.split(" / ");

        for (String word : words) {
            characters = word.split(" ");

            for (String character : characters) result.append(tre.fetch(character));
            result.append(" ");

        }
        result = new StringBuilder(result.toString().trim());
        return result.toString();
    }

    /**
     * returns a string with all the data in the treee in LNR order with an space
     * @return tree in LNR order
     */
    public static String printTree() {
        ArrayList<String> data = new ArrayList<>();
        data = tre.toArrayList();
        StringBuilder str = new StringBuilder();
        for (String datum : data) str.append(datum).append(" ");

        return str.toString().trim();
    }

}
