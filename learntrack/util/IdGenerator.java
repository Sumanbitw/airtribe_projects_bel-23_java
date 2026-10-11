package airtribe.projects.learntrack.util;

/*
* Static field like private static int studentIdCounter
  Static methods like getNextStudentId(), getNextCourseId()
* */

public class IdGenerator {
    private static int studentIdCounter = 0;
    private static int courseIdCounter = 0;
    private static int enrollmentCounter = 0;

    public static int getNextStudentId() {
       return ++studentIdCounter;
    }
    public static int getNextCourseId() {
        return ++courseIdCounter;
    }
    public static int getNextEnrollmentId() {
        return ++enrollmentCounter;
    }
}
