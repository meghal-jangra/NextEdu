package com.dpw.nexteducation.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
        public User findById(int id);

        public User findByName(String name);
}
