package airtribe.projects.learntrack.repository;

import airtribe.projects.learntrack.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private final List<Course> courses = new ArrayList<>();

    public void save(Course course) {
        courses.add(course);
    }

    public List<Course> findAll() {
        return courses;
    }

    public Course findById(int id) {
        for (Course course : courses) {
            if (course.getCourseId() == id) {
                return course;
            }
        }
        return null;
    }

    public boolean remove(Course course) {
        return courses.remove(course);
    }
}
