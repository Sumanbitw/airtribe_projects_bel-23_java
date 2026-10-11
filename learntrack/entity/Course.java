package airtribe.projects.learntrack.entity;

// Fields: id, courseName, description, durationInWeeks, active

public class Course {
    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private boolean active;

    // Default constructor
    Course() {
        this.active = true;
    }

    // Parameterised constructor
    public Course(int id, String courseName, String description, int durationInWeeks, boolean active) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.active = active;
    }

    // Getters
    public int getCourseId() {
        return id;
    }
    public String getCourseName() {
        return courseName;
    }
    public String getDescription() {
        return description;
    }
    public int getDurationInWeeks() {
        return durationInWeeks;
    }
    public boolean isCourseActive() {
        return active;
    }

    // Setters
    public void setCourseId(int id){ this.id = id; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setDescription(String description) { this.description = description; }
    public void setDurationInWeeks(int durationInWeeks) { this.durationInWeeks = durationInWeeks; }
    public void setIsCourseActive(boolean isCourseActive) { this.active = isCourseActive; }
}
