package csv;

/** @author Dmitry Kalinenko
 * Entity to user converter
 */
public class EntityToUserConverter {
    /**
     * Split a string and returns a new user
     * @param entity the essence
     * @return user
     */
    public static User getUser(String entity) {
        String[] fields = entity.split(",");
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
