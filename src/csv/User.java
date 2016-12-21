package csv;

/**This class returns information to create an account
 * @author Basova Ekaterina - ekateryna.basova@gmail.com
 */
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String secondaryEmail;
    private String mobilePhone;
    private String department;

    public User(String firstName, String lastName, String email, String password, String secondaryEmail, String mobilePhone, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.secondaryEmail = secondaryEmail;
        this.mobilePhone = mobilePhone;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getDepartment() {
        return department;
    }

}
