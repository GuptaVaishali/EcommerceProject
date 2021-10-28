package com.ttn.project.ecommerce.repos;

import com.ttn.project.ecommerce.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByEmail(String email);
}
