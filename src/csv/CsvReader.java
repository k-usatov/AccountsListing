package csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**This class opens and reads the CSV file line by line, and add these lines in the internal field
 * @author Dmitry Kalinenko
 */
 public class CsvReader {
    private String filePath;
    private List<String> entries;

    public CsvReader(String filePath) {
        this.filePath = filePath;
        this.entries = new ArrayList<>();
        readAllEntries();
    }

    /**
     * This method return path to file
     * @return filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Returns array of strings from CSV file
     * @return entries
     */
    public List<String> getEntries() {
        return entries;
    }

    /**
     * Open file and reading all strings from CSV file and add to entries
     */
    private void readAllEntries() {
        try(BufferedReader file = new BufferedReader(new FileReader(filePath))) {
            while (file.ready()) {
                entries.add(file.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
