package airtribe.projects.learntrack.entity;

// Fields: id, studentId, courseId, enrollmentDate, status (e.g., "ACTIVE", "COMPLETED", "CANCELLED" as String or simple enum if you want slightly advanced)

import airtribe.projects.learntrack.enums.EnrollmentStatus;

import java.time.LocalDate;

public class Enrollment {
    private int id;
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;
    private EnrollmentStatus status;

    // Default constructor
    public Enrollment(){}

    //Parameterised constructor
    public Enrollment(int id, int studentId, int courseId, LocalDate enrollmentDate, EnrollmentStatus status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    // Getters
    public int getEnrollmentId() {
        return id;
    }
    public int getStudentId() {
        return studentId;
    }
    public int getCourseId() {
        return courseId;
    }
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
    public EnrollmentStatus getEnrollmentStatus() {
        return status;
    }

    // Setters
    public void setEnrollmentId(int id) { this.id = id; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }
    public void setEnrollmentDate(LocalDate enrollmentDate) { this.enrollmentDate = enrollmentDate; }
    public void setEnrollmentStatus(EnrollmentStatus status) { this.status = status; }
}
