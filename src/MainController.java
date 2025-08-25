import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class MainController {
    FileHandler fileHandler;
    TFCalculator tffCalculator;
    ArrayList<String> paths = new ArrayList<String>();

    public MainController() {
        this.fileHandler = new FileHandler();
        this.tffCalculator = new TFCalculator();
    }

    public void run() {
        getPaths("documents");
        for (String path : paths) {
            ArrayList<String> allWords = fileHandler.readFile(path);
            Map<String, Double> tfWords = tffCalculator.calculateWordTF(allWords);
            for (Map.Entry<String, Double> val : tfWords.entrySet()) {
                System.out.println("Element " + val.getKey() + " - "
                        + "TF:"
                        + val.getValue());
            }
        }
    }

    public void getPaths(String folder) {
        File directory = new File(folder);
        File[] contents = directory.listFiles();
        if (contents != null) {
            for (File f : contents) {
                paths.add(f.getAbsolutePath());
            }
        }
    }


}
