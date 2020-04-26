import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ExtractMessages {

  // ArrayList for all of the messages in the text file //
  ArrayList<String> messages = new ArrayList<>();

  // Checks if the file exists and if it does, it reads each line and add that line to messages //
  public void setMessages(Path path) throws FileNotFoundException {
    File file = new File(String.valueOf(path));
    if (!file.exists()) {
      System.out.println("File does not exist");
    } else {
      Scanner fileReader = new Scanner(file);
      while (fileReader.hasNextLine()) {
        messages.add(fileReader.nextLine().toLowerCase());
      }
    }
  }

  // Returns the ArrayList messages //
  public ArrayList<String> getMessages() {
    return messages;
  }
}
