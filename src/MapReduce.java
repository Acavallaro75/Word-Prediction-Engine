import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapReduce {

  Map<ArrayList<String>, Integer> biGram = new HashMap<>();

  // Sets the bi-gram up using the messages that were passed in as a parameter //
  public void setBiGram(ArrayList<String> messages) {
    String message;
    for (int i = 1; i < messages.size(); i++) {
      message = messages.get(i);
      String[] words = message.split(" ");
      for (int j = 1; j < words.length; j++) {
        biGram.merge(new ArrayList<>(Arrays.asList(words[j - 1], words[j])), 1, Integer::sum);
      }
    }
  }

  // Returns the bi-gram //
  public Map<ArrayList<String>, Integer> getBiGram() {
    return biGram;
  }
}
