package com.mylearning.controller;

import com.mylearning.service.StudentService;
import com.mylearning.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return studentService.getAllStudents();
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }
}
