import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {

    // Path to the messages file //
    Path path = Paths.get("src/messages.txt");

    // Extracts the messages from the text file line by line and stores them into an ArrayList //
    ExtractMessages extractMessages = new ExtractMessages();
    extractMessages.setMessages(path);

    // Performs the map reduce function on the messages ArrayList //
    MapReduce mapReduce = new MapReduce();
    mapReduce.setBiGram(extractMessages.getMessages());

    // Performs the affinity analysis on the bi-gram //
    AffinityAnalysis affinityAnalysis = new AffinityAnalysis();
    affinityAnalysis.sortMap(mapReduce.getBiGram());

    // Makes a word prediction based on te bi-gram //
    WordPrediction wordPrediction = new WordPrediction();
    wordPrediction.setArrays(affinityAnalysis.getSortedBiGram());

    // Taking a user's input //
    Scanner scanner = new Scanner(System.in);
    System.out.print("Please type a word or esc to escape: ");
    String word = scanner.nextLine();
    while (!word.equalsIgnoreCase("esc")) {
      wordPrediction.predictWord(word);
      System.out.print("Please type a word or esc to escape: ");
      word = scanner.nextLine();
    }
  }
}
