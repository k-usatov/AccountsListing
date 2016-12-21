package html;

import csv.User;
import csv.UserStorage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**This class generates the html template created accounts
 * @author Usatov Kostiantyn - usatov.k.s@gmail.com
 */
public class HtmlBuilder {
    private final static String HTML_FILE_NAME = "index.html";
    private String htmlPath;
    private Document document;
    private UserStorage userStorage;


    public HtmlBuilder(UserStorage userStorage) {
        this.userStorage = userStorage;
        this.htmlPath = getFileFolder(userStorage.getCsvReader().getfilePath()) + HTML_FILE_NAME;
        this.document = Document.createShell("");
        generateHtmlCode();
    }

    /**It generates code for a table in html page
     */
    private void generateHtmlCode() {
        Element table = document.body().appendElement("table");
        document.head().appendElement("link").attr("rel", "stylesheet")
                .attr("type", "text/css").attr("href", "style.css");
        for (User u : userStorage.getUsers()) {
            Element row = table.appendElement("tr");
            row.appendElement("td").text(u.getFirstName());
            row.appendElement("td").text(u.getLastName());
            row.appendElement("td").text(u.getEmail());
            row.appendElement("td").text(u.getPassword());
            row.appendElement("td").text(u.getSecondaryEmail());
            row.appendElement("td").text(u.getMobilePhone());
            row.appendElement("td").text(u.getDepartment());
        }
    }
    /**Get the path to the folder in which the file is transferred
     * @param filePath absolute path to file
     * @return absolute path to folder
     */
    private String getFileFolder(String filePath) {
        String folder = filePath.substring(0, filePath.lastIndexOf('\\') + 1);
        return folder;
    }
    /**This method generates a html and css files
     */
    public void generate() {
        generateHtmlFile();
        generateCssFile();
    }
    /**This method generates a html file
     */
    private void generateHtmlFile() {
        try {
            File file = new File(htmlPath);
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(document.outerHtml());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**This method generates a css file
     */

    private void generateCssFile() {
        String to = getFileFolder(htmlPath);
        CssCopier cssCopier = new CssCopier();
        cssCopier.copy(to);
    }
}
