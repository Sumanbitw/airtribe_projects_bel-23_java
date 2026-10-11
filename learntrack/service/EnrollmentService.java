package airtribe.projects.learntrack.service;

import airtribe.projects.learntrack.exception.EntityNotFoundException;
import airtribe.projects.learntrack.entity.Course;
import airtribe.projects.learntrack.entity.Enrollment;
import airtribe.projects.learntrack.entity.Student;
import airtribe.projects.learntrack.enums.EnrollmentStatus;
import airtribe.projects.learntrack.exception.InvalidInputException;
import airtribe.projects.learntrack.repository.EnrollmentRepository;
import airtribe.projects.learntrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentService(
            EnrollmentRepository enrollmentRepository,
            StudentService studentService,
            CourseService courseService
    ) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public Enrollment enrollStudent(int studentId, int courseId)
            throws EntityNotFoundException, InvalidInputException {
        Student student = studentService.findStudentById(studentId);
        Course course = courseService.findCourseById(courseId);

        if (!student.isStudentActive()) {
            throw new InvalidInputException("Cannot enroll inactive student with id: " + studentId);
        }
        if (!course.isCourseActive()) {
            throw new InvalidInputException("Cannot enroll in inactive course with id: " + courseId);
        }

        Enrollment enrollment = new Enrollment(
                IdGenerator.getNextEnrollmentId(),
                studentId,
                courseId,
                LocalDate.now(),
                EnrollmentStatus.ACTIVE
        );
        enrollmentRepository.save(enrollment);
        return enrollment;
    }

    public List<Enrollment> viewEnrollmentsForStudent(int studentId) throws EntityNotFoundException {
        studentService.findStudentById(studentId);
        return enrollmentRepository.findByStudentId(studentId);
    }

    public Enrollment markEnrollmentStatus(int enrollmentId, EnrollmentStatus status)
            throws EntityNotFoundException {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId);
        if (enrollment == null) {
            throw new EntityNotFoundException("Enrollment not found with id: " + enrollmentId);
        }
        enrollment.setEnrollmentStatus(status);
        return enrollment;
    }
}
