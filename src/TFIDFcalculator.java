import java.util.HashMap;
import java.util.Map;

public class TFIDFcalculator {
    Map<String, Map<String, Double>> allTFIDF = new HashMap<>();
    public void calculateTFIDF(Map<String, Double> wordsIDF, Map<String, Map<String, Double>> documentsIndex) {
        for (Map.Entry<String, Map<String, Double>> outerEntry : documentsIndex.entrySet()) {
            String document = outerEntry.getKey();
            Map<String, Double> innerMap = outerEntry.getValue();
            System.out.println("Document: " + document);
            allTFIDF.put(document, new HashMap<>());
            for (Map.Entry<String, Double> wordTF : innerMap.entrySet()) {
                String word = wordTF.getKey();
                Double tf = wordTF.getValue();
                double idf = wordsIDF.get(word);
                System.out.println("   Word: " + word + " → TF: " + tf);
                System.out.println("   Word: " + word + " → TFIDF: " + (tf * idf));
                allTFIDF.get(document).put(word, tf * idf);
            }
        }
    }

    public void showTFIDF() {
        System.out.println("------------------");
        for (Map.Entry<String, Map<String, Double>> outerEntry : allTFIDF.entrySet()) {
            String document = outerEntry.getKey();
            Map<String, Double> innerMap = outerEntry.getValue();

            System.out.println("Document: " + document);

            for (Map.Entry<String, Double> wordIDF : innerMap.entrySet()) {
                String word = wordIDF.getKey();
                Double tfidf = wordIDF.getValue();

                System.out.println("   Word: " + word + " → TFIDF: " + tfidf);
            }
        }
    }
}
