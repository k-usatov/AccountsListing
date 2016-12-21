import csv.CsvReader;
import csv.UserStorage;
import html.HtmlBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Demonstration of project
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input path to csv file, please:");
        String filePath = reader.readLine();
        //initialize
        CsvReader csvReader = new CsvReader(filePath);
        UserStorage userStorage = new UserStorage(csvReader);
        HtmlBuilder htmlBuilder = new HtmlBuilder(userStorage);
        //get index.html
        htmlBuilder.generate();
    }
}
