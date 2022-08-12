package com.dpw.nexteducation.repository;

import com.dpw.nexteducation.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    public Student findByName(String name);
}
