package com.mylearning.service;

import com.mylearning.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<Student> selectAllStudent() {
        String sql = "SELECT" + " student_id, first_name, last_name, email, gender" + " FROM student";
        return jdbcTemplate.query(sql, mapStudentFromDb());
    }

    private static RowMapper<Student> mapStudentFromDb() {
        return (resultSet, i) -> {
            String studentIdStr = resultSet.getString("student_id");
            UUID studentId = UUID.fromString(studentIdStr);

            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String genderStr = resultSet.getString("gender").toUpperCase();
            Student.Gender gender = Student.Gender.valueOf(genderStr);
            return new Student(studentId, firstName, lastName, email, gender);
        };
    }
}