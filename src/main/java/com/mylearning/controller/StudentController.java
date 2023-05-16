package com.mylearning.controller;

import com.mylearning.student.Student;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * ClassName: StudentController
 * Package: com.mylearning.controller
 * Description:
 *
 * @Author: Steven_LIU
 * @Create: 27/4/2023 - 11:40 pm
 * @Version: v1.0
 */
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/students")
public class StudentController {
    @GetMapping
    public List<Student> getAllStudents() {
        return List.of(
            new Student(UUID.randomUUID(), "James", "Bond", "jamesbond@gmail.com",
                Student.Gender.MALE),
            new Student(UUID.randomUUID(), "Elisa", "Tamara", "elisatamara@gmail.com",
                Student.Gender.FEMALE)
        );
    }
}
