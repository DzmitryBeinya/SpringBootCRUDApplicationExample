package com.websystique.springboot.service;

import com.websystique.springboot.model.Student;
import com.websystique.springboot.model.User;
import com.websystique.springboot.repositories.StudentRepository;
import com.websystique.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dzbe1116 on 5/2/2017.
 */

    @Service("studentService")
    @Transactional
    public class StudentServiceImpl implements StudentService{

        @Autowired
        private StudentRepository studentRepository;

        public Student findById(Long id) {
            return studentRepository.findOne(id);
        }

        public Student findByName(String name) {
            return studentRepository.findByName(name);
        }

        public void saveStudent(Student student) {
            studentRepository.save(student);
        }

        public void updateStudent(Student student){
            saveStudent(student);
        }

        public void deleteStudentById(Long id){
            studentRepository.delete(id);
        }

        public void deleteAllStudents(){
            studentRepository.deleteAll();
        }

        public List<Student> findAllStudents(){
            return studentRepository.findAll();
        }

        public boolean isStudentExist(Student student) {
            return findByName(student.getName()) != null;
        }

    }

