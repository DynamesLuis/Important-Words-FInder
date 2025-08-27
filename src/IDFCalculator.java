import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IDFCalculator {
    Map<String, ArrayList<String>> wordsInfo = new HashMap<>();
    private int totalDocuments;


    public void calculateIDF(Map<String, Double> words, String documentName) {

    }

    public void checkWordInDocument(Map<String, Double> words, String documentName) {
        for (Map.Entry<String, Double> word : words.entrySet()) {
            String key = word.getKey();
            String value = documentName;
            wordsInfo
                    .computeIfAbsent(key, k -> new ArrayList<>())
                    .add(value);
        }
        for (Map.Entry<String, ArrayList<String>> entry : wordsInfo.entrySet()) {
            String word = entry.getKey();
            ArrayList<String> documents = entry.getValue();

            System.out.print(word + " → ");
            for (String doc : documents) {
                System.out.print(doc + " ");
            }
            System.out.println(); // salto de línea
        }

    }

    public void setTotalDocuments(int totalDocuments) {
        this.totalDocuments = totalDocuments;
    }
}
