package airtribe.projects.learntrack.repository;

import airtribe.projects.learntrack.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private final List<Student> students = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }
    public void remove(Student student) {
        students.remove(student);
    }
    public List<Student> findAll() {
        return students;
    }
    public Student findById(int studentId) {
        for(Student student: students) {
            if(student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }
}
