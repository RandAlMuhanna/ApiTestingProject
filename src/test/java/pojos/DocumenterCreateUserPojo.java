package pojos;

public class DocumenterCreateUserPojo {

    /*
    --data-raw '{
    "firstName": "Rand",
    "lastName": "AlMuhanna",
    "email": "Rand@fake.com",
    "password": "myPassword"
}
     */
    private String firstName ;
    private String lastName ;
    private String email ;
    private String password ;

    public DocumenterCreateUserPojo() {
    }

    public DocumenterCreateUserPojo(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DocumenterCreateUserPojo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
