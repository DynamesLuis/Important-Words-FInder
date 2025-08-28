import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IDFCalculator {
    Map<String, ArrayList<String>> wordsInfo = new HashMap<>();
    Map<String, Double> wordsIDF = new HashMap<>();
    private int totalDocuments;


    public void calculateIDF(String word, ArrayList<String> documents) {
        double idf = Math.log10((double) totalDocuments / documents.size());
        wordsIDF.put(word, idf);
        //System.out.println(word + ": " + idf + ", " + documents.size());
    }

    public void checkWordInDocument(Map<String, Double> words, String documentName) {
        for (Map.Entry<String, Double> word : words.entrySet()) {
            String key = word.getKey();
            String value = documentName;
            wordsInfo
                    .computeIfAbsent(key, k -> new ArrayList<>())
                    .add(value);
        }
    }

    public void setTotalDocuments(int totalDocuments) {
        this.totalDocuments = totalDocuments;
    }

    public Map<String, ArrayList<String>> getWordsInfo() {
        return wordsInfo;
    }

    public int getTotalDocuments() {
        return totalDocuments;
    }

    public Map<String, Double> getWordsIDF() {
        return wordsIDF;
    }
}
