package airtribe.projects.learntrack.entity;

// Fields: id, firstName, lastName, email, batch, active (boolean)

public class Student extends Person {
    private String batch;
    private boolean active;

    // default constructor
    public Student() {
        super();
        this.active = true;
    }

    // Constructor without email
    public Student(int id, String firstName, String lastName, String batch, boolean active) {
        super(id, firstName, lastName, null);
        this.batch = batch;
        this.active = active;
    }

    // Constructor with email
    public Student(int id, String firstName, String lastName, String email, String batch, boolean active) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = active;
    }

    // Getters
    public String getStudentBatch() {
        return batch;
    }
    public boolean isStudentActive() {
        return active;
    }

    // Setters
    public void setStudentBatch(String batch) {
        this.batch = batch;
    }
    public void setIsStudentActive(boolean active) {
        this.active = active;
    }


    // Method overridden from Parent class
    @Override
    public String getDisplayName() {
        return "Student: " + getFirstName() + " " + getLastName() + " [" + batch + "]";
    }
}
