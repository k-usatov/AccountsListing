package csv;

import main.Constants;

/**
 * Entity to user converter
 * @author Dmitry Kalinenko
 */
public class EntityToUserConverter {
    /**
     * Split a string and returns a new user
     * @param entity to entity
     * @return user
     */
    public static User getUser(String entity) {
        String[] fields = entity.split(Constants.SEPARATOR);
        User user = null;
        try {
            String firstName = fields[0];
            String lastName = fields[1];
            String email = fields[2];
            String password = fields[3];
            String secondaryEmail = fields[4];
            String mobilePhone = fields[5];
            String department = fields[6];
            user = new User(firstName, lastName, email, password, secondaryEmail, mobilePhone, department);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return user;
    }
}
