package airtribe.projects.learntrack.entity;

public class Trainer extends Person {
    private String specialization;

    Trainer() {
        super();
    }

    Trainer(int id, String firstName, String lastName, String email, String specialization) {
        super(id, firstName, lastName, email);
        this.specialization = specialization;
    }

    // Getters
    public String getSpecialization() {
        return specialization;
    }

    // Setters
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    // Method overridden from Parent class
    @Override
    public String getDisplayName() {
        return "Trainer: " + getFirstName() + " " + getLastName() + " [" + specialization + "]";
    }
}
