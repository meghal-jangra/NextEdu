package com.dpw.nexteducation.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
