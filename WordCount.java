import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        String inputFile = "WordList.txt";
        String outputFile = "OutputList.txt";

        // Create a map to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();

        try {
            // Open the input file for reading
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Convert the line to lowercase to make it case-insensitive
                line = line.toLowerCase();

                // Update the word count for the current line
                wordCountMap.put(line, wordCountMap.getOrDefault(line, 0) + 1);
            }

            // Close the input file
            reader.close();

            // Open the output file for writing
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            // Write the word counts to the output file
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }

            // Close the output file
            writer.close();

            System.out.println("Word counts written to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
