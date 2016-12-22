package html;

import csv.User;
import csv.UserStorage;
import main.Constants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**This class generates the html template created accounts
 * @author Usatov Kostiantyn - usatov.k.s@gmail.com
 */
public class HtmlBuilder {
    private String htmlPath;
    private HashMap<User, Document> map;
    private UserStorage userStorage;


    public HtmlBuilder(UserStorage userStorage) {
        this.userStorage = userStorage;
        this.htmlPath = getFileFolder(userStorage.getCsvReader().getFilePath());
        this.map = new HashMap<>();
        try {
            for (User u : userStorage.getUsers()) {
                Document d = Jsoup.parse(getClass().getResourceAsStream("pattern.html"), "UTF-8", "");
                map.put(u, d); //добавляем нового пользователя и шаблон
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        generateHtmlCode();
    }

    /**
     *Replace template all users
     */
    private void generateHtmlCode() {
        for (Map.Entry<User, Document> entry : map.entrySet()) {
            generateHtmlCodeForUser(entry.getKey());
        }
    }

    /**
     * Replace template for a specific user
     * @param user users
     */
    private void generateHtmlCodeForUser(User user) {
        replace(user, "firstName", user.getFirstName());
        replace(user, "lastName", user.getLastName());
        replace(user, "email", user.getEmail());
        replace(user, "password", user.getPassword());
        replace(user, "secondaryEmail", user.getSecondaryEmail());
        replace(user, "mobilePhone", user.getMobilePhone());
        replace(user, "department", user.getDepartment());
    }

    /**
     * Seeking peremennіe and replaces user
     * @param user users
     * @param tag var from template
     * @param replacement so what should be changed
     */
    private void replace(User user, String tag, String replacement) {
        String selector = "p:contains(\\{" + tag + "\\})";
        String r = "\\{" + tag + "\\}";
        for (Element e : map.get(user).select(selector)) { //map.get(user) take document
            e.text(e.text().replaceAll(r, replacement));
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
        for (User u : userStorage.getUsers()) {
            generateCssFile();
            generateHtmlFileForUser(u);
        }
    }

    /**
     * This method generates a html file for user
     * @param u users
     */
    private void generateHtmlFileForUser(User u) {
            try {
                File file = new File(htmlPath + u.getFirstName() + u.getLastName() + Constants.HTML_FILE_EXTENSION);
                file.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(map.get(u).outerHtml());
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
