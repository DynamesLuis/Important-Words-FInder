import java.io.*;
import java.util.ArrayList;
import java.util.Map;
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

    public void writeFile(Map<String, Map<String, Double>> tfidfs) throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Results"));
            for (Map.Entry<String, Map<String, Double>> outerEntry : tfidfs.entrySet()) {
                String document = outerEntry.getKey();
                Map<String, Double> innerMap = outerEntry.getValue();
                writer.write("Document: " + document);
                writer.newLine();
                for (Map.Entry<String, Double> wordTFIDF : innerMap.entrySet()) {
                    String word = wordTFIDF.getKey();
                    Double tfidf = wordTFIDF.getValue();
                    writer.write("  " + word + " -> tfidf: " +tfidf);
                    writer.newLine();
                }
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

    private String normalized(String rawWord) {
        return rawWord.replaceAll("[,.\"]", "").toLowerCase();
    }
}
