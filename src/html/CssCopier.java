package html;

import java.io.*;

/**
 * Responsible for the creation of a new CSS file
 * @author Usatov Kostiantyn - usatov.k.s@gmail.com
 */
public class CssCopier {
    private InputStream in = getClass().getResourceAsStream("/style.css");
    private final String CSS_FILE_NAME = "style.css";

    /**
     * Copy the CSS file in the specified folder with a special name
     * @param pathDestination the path to the folder
     */
    public void copy(String pathDestination) {
        try {
            File cssFile = new File(pathDestination + CSS_FILE_NAME);
            cssFile.createNewFile();
            FileWriter out = new FileWriter(cssFile);
            while (in.available() > 0) {
                out.write(in.read());
            }
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
