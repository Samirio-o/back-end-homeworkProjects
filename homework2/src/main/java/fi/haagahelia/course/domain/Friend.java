package fi.haagahelia.course.domain;

public class Friend {

    private String firstName;
    private String lastName;

    // Empty constructor for creating Friend objects without initial values
    public Friend() {
    }

    public Friend(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}
