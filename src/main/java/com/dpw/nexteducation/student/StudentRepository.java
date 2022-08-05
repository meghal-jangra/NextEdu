package com.dpw.nexteducation.student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    public Student findByName(String name);
}
