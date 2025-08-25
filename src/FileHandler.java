import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    public ArrayList<String> readFile(String path) {
        ArrayList<String> allWords = new ArrayList<String>();
        try {
            File newFile = new File(path);
            Scanner scanner = new Scanner(newFile);
            while (scanner.hasNext()) {
                String rawWord = scanner.next();
                String normalizedWord = normalized(rawWord);
                allWords.add(normalizedWord);
            }


        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return allWords;
    }

    private String normalized(String rawWord) {
        return rawWord.replaceAll("[,.\"]", "").toLowerCase();
    }
}
