package com.mylearning.controller;

import com.mylearning.entity.Student;
import com.mylearning.entity.StudentCourse;
import com.mylearning.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin("http://localhost:3000") // spring的跨域注解，添加前端的URL和端口号
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getAllStudents() {
        // throw new ApiRequestException("Oops can't get all students.");
        return studentService.getAllStudents();
    }

    @GetMapping(path = "{studentId}/courses")
    public List<StudentCourse> getAllCoursesOfStudent(@PathVariable("studentId") UUID studentId) {
        return studentService.getAllCoursesOfStudent(studentId);
    }

    @PostMapping
    public void addNewStudent(@RequestBody @Valid Student student) {
        studentService.addNewStudent(student);
    }
}
