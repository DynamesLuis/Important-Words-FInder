import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TFCalculator {
    int totalWord = 0;

    public Map<String, Double> calculateWordTF(ArrayList<String> allWords) {
        Map<String, Double> wordsCount = countWordFrequencies(allWords);
        for (var entry : wordsCount.entrySet()) {
            wordsCount.replace(entry.getKey(), (entry.getValue() / totalWord));
        }
        totalWord = 0;
        return wordsCount;
    }

    public Map<String, Double> countWordFrequencies(ArrayList<String> allWords) {
        Map<String, Double> wordsCount = new HashMap<String, Double>();
        for (String word : allWords) {
            wordsCount.merge(word, 1.0, Double::sum);
            totalWord++;
        }
        return wordsCount;
    }
}
