import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainController {
    FileHandler fileHandler;
    TFCalculator tffCalculator;
    IDFCalculator idfCalculator;
    //DocumentIndex documentIndex;

    Map<String, String> documentsInfo = new HashMap<>();

    public MainController() {
        this.fileHandler = new FileHandler();
        this.tffCalculator = new TFCalculator();
        this.idfCalculator = new IDFCalculator();
     //   this.documentIndex = new DocumentIndex();
    }

    public void run() {
        getPaths("documents");
        idfCalculator.setTotalDocuments(documentsInfo.size());
        for (Map.Entry<String, String > document: documentsInfo.entrySet()) {
            ArrayList<String> allWords = fileHandler.readFile(document.getValue());
            Map<String, Double> tfWords = tffCalculator.calculateWordTF(allWords);
            idfCalculator.checkWordInDocument(tfWords, document.getKey());
            //for (Map.Entry<String, Double> val : tfWords.entrySet()) {
            //    System.out.println("Element " + val.getKey() + " - "
            //            + "TF:"
            //            + val.getValue());
            //}
        }

        Map<String, ArrayList<String>> wordInDocumentCount = idfCalculator.getWordsInfo();
        //wordInDocumentCount.forEach((word, documents) -> {
        //    System.out.println(word + " → " + documents);
        //});
        System.out.println(idfCalculator.getTotalDocuments());
        for (Map.Entry<String, ArrayList<String>> wordInfo: wordInDocumentCount.entrySet()) {
            idfCalculator.calculateIDF(wordInfo.getKey(), wordInfo.getValue());
        }
    }

    public void getPaths(String folder) {
        File directory = new File(folder);
        File[] contents = directory.listFiles();
        if (contents != null) {
            for (File f : contents) {
                documentsInfo.put(f.getName(), f.getAbsolutePath());
            }
        }
    }


}
