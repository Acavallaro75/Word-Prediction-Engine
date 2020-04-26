import java.util.ArrayList;
import java.util.Map;

public class AffinityAnalysis {

  Map<ArrayList<String>, Integer> biGram;
  ArrayList<ArrayList> sortedBiGram = new ArrayList<>();

  public void sortMap(Map<ArrayList<String>, Integer> biGram) {
    this.biGram = biGram;
    ArrayList<String> firstWord = new ArrayList<>();
    ArrayList<String> secondWord = new ArrayList<>();
    ArrayList<Integer> number = new ArrayList<>();

    biGram.forEach((key, value) -> firstWord.add(new ArrayList<>(key).get(0)));
    biGram.forEach((key, value) -> secondWord.add(new ArrayList<>(key).get(1)));
    biGram.forEach((key, value) -> number.add(value));

    sortedBiGram.add(firstWord);
    sortedBiGram.add(secondWord);
    sortedBiGram.add(number);
  }

  public ArrayList<ArrayList> getSortedBiGram() {
    return sortedBiGram;
  }
}
