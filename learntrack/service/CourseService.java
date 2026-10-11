package airtribe.projects.learntrack.service;

import airtribe.projects.learntrack.exception.EntityNotFoundException;
import airtribe.projects.learntrack.entity.Course;
import airtribe.projects.learntrack.entity.Student;
import airtribe.projects.learntrack.repository.CourseRepository;
import airtribe.projects.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course) {
        courseRepository.save(course);
        return course;
    }

    public Course addCourse(String courseName, String description, int durationInWeeks) {
        Course course = new Course(
                IdGenerator.getNextCourseId(),
                courseName,
                description,
                durationInWeeks,
                true
        );
        courseRepository.save(course);
        return course;
    }

    public List<Course> listCourses() {
        return courseRepository.findAll();
    }

    public Course findCourseById(int id) throws EntityNotFoundException {
        Course course = courseRepository.findById(id);
        if (course == null) {
            throw new EntityNotFoundException("Course not found with id: " + id);
        }
        return course;
    }

    public Course activateCourse(int id) throws EntityNotFoundException {
        Course course = findCourseById(id);
        course.setIsCourseActive(true);
        return course;
    }

    public Course deactivateCourse(int id) throws EntityNotFoundException {
        Course course = findCourseById(id);
        course.setIsCourseActive(false);
        return course;
    }
}
