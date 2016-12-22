package html;

import main.Constants;

import java.io.*;

/**
 * Responsible for the creation of a new CSS file
 * @author Usatov Kostiantyn - usatov.k.s@gmail.com
 */
public class CssCopier {
    private InputStream in = getClass().getResourceAsStream("/style.css");

    /**
     * Copy the CSS file in the specified folder with a special name
     * @param pathDestination to pathDestination
     */
    public void copy(String pathDestination) {
        try {
            File cssFile = new File(pathDestination + Constants.CSS_FILE_NAME);
            if (!cssFile.exists()) {
                cssFile.createNewFile();
                FileWriter out = new FileWriter(cssFile);
                while (in.available() > 0) {
                    out.write(in.read());
                }
                in.close();
                out.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
