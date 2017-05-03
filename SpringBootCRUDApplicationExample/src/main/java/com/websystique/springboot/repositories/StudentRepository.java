package com.websystique.springboot.repositories;

import com.websystique.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dzbe1116 on 5/2/2017.
 */
public interface StudentRepository extends JpaRepository <Student, Long> {
    Student findByName(String name);
}
