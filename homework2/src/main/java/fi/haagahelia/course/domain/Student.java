package fi.haagahelia.course.domain;

public class Student {
    
    private String firstName;
    private String lastName;

    //Constructor for creating a new student
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Getters for read values from the outside of the class
    public String getFirstName() {
        return firstName;
    }

    //Setters for update values from the outside of the class
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
