package airtribe.projects.learntrack.ui;


import airtribe.projects.learntrack.constants.AppConstants;
import airtribe.projects.learntrack.constants.MenuOptions;
import airtribe.projects.learntrack.entity.Course;
import airtribe.projects.learntrack.entity.Enrollment;
import airtribe.projects.learntrack.entity.Student;
import airtribe.projects.learntrack.enums.EnrollmentStatus;
import airtribe.projects.learntrack.exception.EntityNotFoundException;
import airtribe.projects.learntrack.exception.InvalidInputException;
import airtribe.projects.learntrack.repository.CourseRepository;
import airtribe.projects.learntrack.repository.EnrollmentRepository;
import airtribe.projects.learntrack.repository.StudentRepository;
import airtribe.projects.learntrack.service.CourseService;
import airtribe.projects.learntrack.service.EnrollmentService;
import airtribe.projects.learntrack.service.StudentService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner scanner;
    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    public Main() {
        this.scanner = new Scanner(System.in);
        StudentRepository studentRepository = new StudentRepository();
        CourseRepository courseRepository = new CourseRepository();
        EnrollmentRepository enrollmentRepository = new EnrollmentRepository();

        this.studentService = new StudentService(studentRepository);
        this.courseService = new CourseService(courseRepository);
        this.enrollmentService = new EnrollmentService(
                enrollmentRepository,
                studentService,
                courseService
        );
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }
    private void run() {
        boolean running = true;
        while (running) {
            printMenu();
            try {
                System.out.print("Enter option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case MenuOptions.ADD_STUDENT:
                        addStudentFlow();
                        break;
                    case MenuOptions.VIEW_STUDENTS:
                        viewAllStudents();
                        break;
                    case MenuOptions.SEARCH_STUDENT:
                        searchStudentFlow();
                        break;
                    case MenuOptions.DEACTIVATE_STUDENT:
                        deactivateStudentFlow();
                        break;
                    case MenuOptions.ADD_COURSE:
                        addCourseFlow();
                        break;
                    case MenuOptions.VIEW_COURSES:
                        viewAllCourses();
                        break;
                    case MenuOptions.TOGGLE_COURSE:
                        toggleCourseFlow();
                        break;
                    case MenuOptions.ENROLL_STUDENT:
                        enrollStudentFlow();
                        break;
                    case MenuOptions.VIEW_STUDENT_ENROLLMENTS:
                        viewStudentEnrollmentsFlow();
                        break;
                    case MenuOptions.MARK_ENROLLMENT_STATUS:
                        markEnrollmentStatusFlow();
                        break;
                    case MenuOptions.EXIT:
                        running = false;
                        System.out.println("Exiting " + AppConstants.APP_NAME + ". Goodbye!");
                        break;
                    default:
                        System.out.println("Option not found. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (InvalidInputException e) {
                System.out.println("Invalid input: " + e.getMessage());
            } catch (EntityNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
    private void printMenu() {
        System.out.println();
        System.out.println("===== " + AppConstants.APP_NAME + " =====");
        System.out.println("--- Student Management ---");
        System.out.println("1. Add new student");
        System.out.println("2. View all students");
        System.out.println("3. Search student by ID");
        System.out.println("4. Deactivate a student");
        System.out.println("--- Course Management ---");
        System.out.println("5. Add new course");
        System.out.println("6. View all courses");
        System.out.println("7. Activate/Deactivate a course");
        System.out.println("--- Enrollment Management ---");
        System.out.println("8. Enroll a student in a course");
        System.out.println("9. View enrollments for a student");
        System.out.println("10. Mark enrollment as completed/cancelled");
        System.out.println("0. Exit");
    }
    private void addStudentFlow() {
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Email (optional, press Enter to skip): ");
        String email = scanner.nextLine();
        System.out.print("Batch: ");
        String batch = scanner.nextLine();

        Student student;
        if (email.trim().isEmpty()) {
            student = studentService.addStudent(firstName, lastName, batch);
        } else {
            student = studentService.addStudent(firstName, lastName, email, batch);
        }
        System.out.println("Student added: " + student.getDisplayName()
                + " | id=" + student.getStudentId()
                + ", email=" + student.getStudentEmail()
                + ", active=" + student.isStudentActive());
    }

    private void viewAllStudents() {
        List<Student> students = studentService.listStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println(student.getDisplayName()
                    + " | id=" + student.getStudentId()
                    + ", email=" + student.getStudentEmail()
                    + ", active=" + student.isStudentActive());
        }
    }

    private void searchStudentFlow() throws EntityNotFoundException {
        System.out.print("Enter student ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = studentService.findStudentById(id);
        System.out.println("Found: " + student.getDisplayName()
                + " | id=" + student.getStudentId()
                + ", email=" + student.getStudentEmail()
                + ", active=" + student.isStudentActive());
    }

    private void deactivateStudentFlow() throws EntityNotFoundException {
        System.out.print("Enter student ID to deactivate: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = studentService.deactivateStudent(id);
        System.out.println("Student deactivated: " + student.getDisplayName()
                + " | active=" + student.isStudentActive());
    }

    private void addCourseFlow() {
        System.out.print("Course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Duration in weeks: ");
        int duration = Integer.parseInt(scanner.nextLine());

        Course course = courseService.addCourse(courseName, description, duration);
        System.out.println("Course added: id=" + course.getCourseId()
                + ", name=" + course.getCourseName()
                + ", durationInWeeks=" + course.getDurationInWeeks()
                + ", active=" + course.isCourseActive());
    }

    private void viewAllCourses() {
        List<Course> courses = courseService.listCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        System.out.println("Courses:");
        for (Course course : courses) {
            System.out.println("id=" + course.getCourseId()
                    + ", name=" + course.getCourseName()
                    + ", durationInWeeks=" + course.getDurationInWeeks()
                    + ", active=" + course.isCourseActive());
        }
    }

    private void toggleCourseFlow() throws EntityNotFoundException {
        System.out.print("Enter course ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Course course = courseService.findCourseById(id);
        if (course.isCourseActive()) {
            courseService.deactivateCourse(id);
            System.out.println("Course deactivated.");
        } else {
            courseService.activateCourse(id);
            System.out.println("Course activated.");
        }
    }

    private void enrollStudentFlow() throws EntityNotFoundException, InvalidInputException {
        System.out.print("Enter student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter course ID: ");
        int courseId = Integer.parseInt(scanner.nextLine());

        Enrollment enrollment = enrollmentService.enrollStudent(studentId, courseId);
        System.out.println("Enrollment created: id=" + enrollment.getEnrollmentId()
                + ", studentId=" + enrollment.getStudentId()
                + ", courseId=" + enrollment.getCourseId()
                + ", status=" + enrollment.getEnrollmentStatus());
    }

    private void viewStudentEnrollmentsFlow() throws EntityNotFoundException {
        System.out.print("Enter student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        List<Enrollment> enrollments = enrollmentService.viewEnrollmentsForStudent(studentId);
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found for student id: " + studentId);
            return;
        }
        System.out.println("Enrollments:");
        for (Enrollment enrollment : enrollments) {
            System.out.println("id=" + enrollment.getEnrollmentId()
                    + ", studentId=" + enrollment.getStudentId()
                    + ", courseId=" + enrollment.getCourseId()
                    + ", date=" + enrollment.getEnrollmentDate()
                    + ", status=" + enrollment.getEnrollmentStatus());
        }
    }

    private void markEnrollmentStatusFlow() throws EntityNotFoundException, InvalidInputException {
        System.out.print("Enter enrollment ID: ");
        int enrollmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("1. COMPLETED");
        System.out.println("2. CANCELLED");
        System.out.print("Choose status: ");
        int statusChoice = Integer.parseInt(scanner.nextLine());

        EnrollmentStatus status;
        if (statusChoice == 1) {
            status = EnrollmentStatus.COMPLETED;
        } else if (statusChoice == 2) {
            status = EnrollmentStatus.CANCELLED;
        } else {
            throw new InvalidInputException("Status option not found.");
        }

        Enrollment enrollment = enrollmentService.markEnrollmentStatus(enrollmentId, status);
        System.out.println("Enrollment updated: id=" + enrollment.getEnrollmentId()
                + ", status=" + enrollment.getEnrollmentStatus());
    }
}
