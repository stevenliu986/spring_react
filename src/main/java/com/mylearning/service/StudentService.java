package com.mylearning.service;

import com.mylearning.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * ClassName: StudentService
 * Package: com.mylearning.service
 * Description:
 *
 * @Author: Steven_LIU
 * @Create: 31/5/2023 - 10:40 am
 * @Version: v1.0
 */
@Service
public class StudentService {

    private final StudentDataAccessService studentDataAccessService;

    @Autowired
    public StudentService(StudentDataAccessService studentDataAccessService) {
        this.studentDataAccessService = studentDataAccessService;
    }

    public List<Student> getAllStudents() {
        return studentDataAccessService.selectAllStudent();
    }

    void addNewStudent(UUID studentId, Student student) {
        UUID newStudentId = Optional.ofNullable(studentId).orElse(UUID.randomUUID());

        // TODO: verify that email is not taken

        studentDataAccessService.insertStudent(newStudentId, student);
    }

    public void addNewStudent(Student student) {
        addNewStudent(null, student);
    }
}
