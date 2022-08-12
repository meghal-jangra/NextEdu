package com.dpw.nexteducation.repository;

import com.dpw.nexteducation.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
        public User findById(int id);

        public User findByName(String name);
}
