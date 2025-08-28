import java.util.HashMap;
import java.util.Map;

public class DocumentIndex {
    Map<String, Map<String, Double>> documentsIndex = new HashMap<>();

    public void addDocument(String documentName, Map<String, Double> wordsTF) {
        documentsIndex.put(documentName, wordsTF);
    }

    public Map<String, Map<String, Double>> getDocumentsIndex() {
        return documentsIndex;
    }

    public void showDocumentIndexes() {
        for (Map.Entry<String, Map<String, Double>> outerEntry : documentsIndex.entrySet()) {
            String document = outerEntry.getKey();
            Map<String, Double> innerMap = outerEntry.getValue();

            System.out.println("Document: " + document);

            for (Map.Entry<String, Double> wordTF : innerMap.entrySet()) {
                String word = wordTF.getKey();
                Double tf = wordTF.getValue();

                System.out.println("   Word: " + word + " → TF: " + tf);
            }
        }
    }
}
