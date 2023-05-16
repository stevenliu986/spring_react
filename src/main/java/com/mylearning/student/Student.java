package com.mylearning.student;

import java.util.UUID;

/**
 * ClassName: Student
 * Package: com.mylearning.student
 * Description:
 *
 * @Author: Steven_LIU
 * @Create: 27/4/2023 - 11:29 pm
 * @Version: v1.0
 */
public class Student {
    private final UUID studentId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Gender gender;

    public enum Gender{
        MALE, FEMALE
    }

    public Student(UUID studentId, String firstName, String lastName, String email, Gender gender) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }
}
