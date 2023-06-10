package com.mylearning.service;

import com.mylearning.entity.Student;
import com.mylearning.entity.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
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

    int insertStudent(UUID studentId, Student student) {
        String sql = "INSERT INTO student" + "( student_id, first_name, last_name, " +
                "email, gender) VALUES (?, ?, ?, ?, ?::gender)"; // 由于把DB中的gender
        // 字段修改为type类型，所以这里需要把字符串cast为type类型
        return jdbcTemplate.update(sql,
                studentId, student.getFirstName(), student.getLastName(), student.getEmail(),
                student.getGender().name().toUpperCase());
    }

    List<StudentCourse> selectAllCoursesOfStudent(UUID studentId) {
        String sql = "select" + " student.student_id, course.course_id, course.name, course" +
                ".description, course.department, course.teacher_name, student_course.start_date," +
                " student_course.end_date, student_course.grade" + "from student join " +
                "student_course using (student_id) join course using (course_id) where student" +
                ".student_id = ?";
        return jdbcTemplate.query(sql, new Object[]{studentId}, mapStudentCourseFromDb());
    }

    private static RowMapper<StudentCourse> mapStudentCourseFromDb(){
        return (resultSet, i) ->
                new StudentCourse(
                        UUID.fromString(resultSet.getString("student_id")),
                        UUID.fromString(resultSet.getString("course_id")),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("department"),
                        resultSet.getString("teacher_name"),
                        resultSet.getDate("start_date").toLocalDate(),
                        resultSet.getDate("end_date").toLocalDate(),
                        Optional.ofNullable(resultSet.getString("grade"))
                                .map(Integer::parseInt)
                                .orElse(null)
                );
    }
}
