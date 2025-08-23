import java.io.File;
import java.util.ArrayList;

public class MainController {
    FileHandler fileHandler;
    //TFIDFcalculator tfidfCalculator;
    ArrayList<String> paths = new ArrayList<String>();

    public MainController() {
        this.fileHandler = new FileHandler();
        //this.tfidfCalculator = new TFIDFcalculator();
    }

    public void run() {
        //obtener los path de los documentos en una carpeta y guardarlos
        getPaths("documents");
        //guardar los path en una estructura de datos
        //leer cada documento
        for (String path : paths) {
            //extraer cada palabra de cada documento
            fileHandler.readFile(path);
            System.out.println("-------------");
        }


        //contar cada palabra de cada documento
        //calcular el TFIDF
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
