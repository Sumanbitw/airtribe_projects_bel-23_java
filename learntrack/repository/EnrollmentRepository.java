package airtribe.projects.learntrack.repository;

import airtribe.projects.learntrack.entity.Enrollment;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {
    private final List<Enrollment> enrollments = new ArrayList<>();

    public void save(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public List<Enrollment> findAll() {
        return enrollments;
    }

    public Enrollment findById(int id) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getEnrollmentId() == id) {
                return enrollment;
            }
        }
        return null;
    }

    public List<Enrollment> findByStudentId(int studentId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId) {
                result.add(enrollment);
            }
        }
        return result;
    }
}
