package com.websystique.springboot.service;

import com.websystique.springboot.model.Student;
import com.websystique.springboot.model.User;

import java.util.List;

/**
 * Created by dzbe1116 on 5/2/2017.
 */
public interface StudentService {
    Student findById(Long id);

    Student findByName(String name);

    void saveStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentById(Long id);

    void deleteAllStudents();

    List<Student> findAllStudents();

    boolean isStudentExist(Student student);
}
