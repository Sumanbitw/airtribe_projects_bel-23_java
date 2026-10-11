package airtribe.projects.learntrack.service;

/*
* In services: addStudent, removeStudent, updateStudent, listStudents
  Use methods with different parameters (overloading example).
* */

import airtribe.projects.learntrack.entity.Student;
import airtribe.projects.learntrack.exception.EntityNotFoundException;
import airtribe.projects.learntrack.repository.StudentRepository;
import airtribe.projects.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final StudentRepository studentRepository;

    //Parameterized constructor
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Method overloading
    public Student addStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    // Method Overloading -> Same function but different parameters
    public Student addStudent(String firstName, String lastName, String email, String batch) {
        Student student = new Student(IdGenerator.getNextStudentId(),firstName, lastName, email, batch, true);
        studentRepository.save(student);
        return student;
    }

    // Without email constructor
    public Student addStudent(String firstName, String lastName, String batch) {
        Student student = new Student(
                IdGenerator.getNextStudentId(),
                firstName,
                lastName,
                batch,
                true
        );
        studentRepository.save(student);
        return student;
    }
    public List<Student> listStudents() {
        return studentRepository.findAll();
    }
    public Student findStudentById(int studentId) throws EntityNotFoundException {
        Student student = studentRepository.findById(studentId);
        if(student == null) {
            throw new EntityNotFoundException("Student not found with id: " + studentId);
        }
        return student;
    }
    public Student updateStudent(int id, String firstName, String lastName, String email, String batch) throws EntityNotFoundException {
        Student student = findStudentById(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setStudentEmail(email);
        student.setStudentBatch(batch);

        return student;
    }
    public void removeStudent(int studentId) throws EntityNotFoundException {
        Student student = findStudentById(studentId);
        studentRepository.remove(student);
    }
    public Student deactivateStudent(int studentId) throws EntityNotFoundException {
        Student student = findStudentById(studentId);
        student.setIsStudentActive(false);
        return student;
    }
}
