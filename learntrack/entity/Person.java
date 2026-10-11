package airtribe.projects.learntrack.entity;

// Fields: id, firstName, lastName, email

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    // Default Constructor
    Person() {
        System.out.println("This is a default constructor values");
    }

    // Parameterised constructor
    Person(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getters
    public int getStudentId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getStudentEmail() {
        return email;
    }

    // Setters
    public void setStudentId(int id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setStudentEmail(String email) {
        this.email = email;
    }

    // Method to display the details
    public String getDisplayName() {
        return firstName + " " + lastName;
    }
}
