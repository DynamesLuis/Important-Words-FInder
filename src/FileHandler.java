import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandler {
    public void readFile(String path) {
        try {
            File newFile = new File(path);
            Scanner scanner = new Scanner(newFile);
            while (scanner.hasNext()) {
                String data = scanner.next();
                System.out.println(data);
                //count every word
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
