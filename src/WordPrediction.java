import java.util.ArrayList;

public class WordPrediction {

  ArrayList<String> firstWord;
  ArrayList<String> secondWord;
  ArrayList<Integer> wordOccurrences;

  public void setArrays(ArrayList<ArrayList> Array) {
    this.firstWord = Array.get(0);
    this.secondWord = Array.get(1);
    this.wordOccurrences = Array.get(2);
  }

  public void predictWord(String word) {
    int i = 0;
    int secondTotal = 0;
    ArrayList<Integer> found = new ArrayList<>();

    for (String biGramWord : firstWord) {
      if (biGramWord.equals(word)) {
        secondTotal += wordOccurrences.get(i);
        found.add(i);
      }
      i++;
    }

    for (int index : found) {
      if (((wordOccurrences.get(index) / (float) secondTotal) * 100) > 65) {
        System.out.printf("Your next word might be %s\n", secondWord.get(index));
        return;
      }
    }

    System.out.println("Your next word might be the");
    System.out.println("Your next word might be this");
    System.out.println("Your next word might be of");
  }
}
