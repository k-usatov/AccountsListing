package csv;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for keeping the list of users
 * @author Basova Ekaterina - ekateryna.basova@gmail.com
 */
public class UserStorage {
    private List<User> users;
    private CsvReader csvReader;

    public UserStorage(CsvReader csvReader) {
        this.csvReader = csvReader;
        this.users = new ArrayList<>();
        convertAllEntities();
    }

    /**
     * Converts all of the entities in user and adds in users
     */
    private void convertAllEntities() {
        for (String str : csvReader.getEntries()) {
            User u = EntityToUserConverter.getUser(str);
            users.add(u);
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public CsvReader getCsvReader() {
        return csvReader;
    }
}
