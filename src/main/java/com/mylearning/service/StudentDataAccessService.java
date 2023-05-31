package com.mylearning.service;

import com.mylearning.student.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * ClassName: StudentDataAccessService
 * Package: com.mylearning.service
 * Description:
 *
 * @Author: Steven_LIU
 * @Create: 31/5/2023 - 11:22 am
 * @Version: v1.0
 */
@Repository
public class StudentDataAccessService {
    public List<Student> selectAllStudent() {
        return List.of(new Student(UUID.randomUUID(), "James", "Bonds", "jamesbond@gmail.com", Student.Gender.MALE), new Student(UUID.randomUUID(), "Elisa", "Tamara", "elisatamara@gmail.com", Student.Gender.FEMALE));
    }
}
