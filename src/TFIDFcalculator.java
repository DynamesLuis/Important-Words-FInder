import java.awt.image.ColorModel;
import java.util.*;

public class TFIDFcalculator {
    Map<String, Map<String, Double>> allTFIDF = new HashMap<>();
    public void calculateTFIDF(Map<String, Double> wordsIDF, Map<String, Map<String, Double>> documentsIndex) {
        for (Map.Entry<String, Map<String, Double>> outerEntry : documentsIndex.entrySet()) {
            String document = outerEntry.getKey();
            Map<String, Double> innerMap = outerEntry.getValue();
            allTFIDF.put(document, new HashMap<>());
            for (Map.Entry<String, Double> wordTF : innerMap.entrySet()) {
                String word = wordTF.getKey();
                Double tf = wordTF.getValue();
                double idf = wordsIDF.get(word);
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

    public void sortTFIDF() {
        for (Map.Entry<String, Map<String, Double>> outerEntry : allTFIDF.entrySet()) {
            String document = outerEntry.getKey();
            Map<String, Double> unsortedMap = outerEntry.getValue();
            Map<String, Double> sortedMap = sortByValue(unsortedMap);
            allTFIDF.put(document, sortedMap);
        }
    }

    private <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V>entry: list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
