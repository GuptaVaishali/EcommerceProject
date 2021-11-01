package com.ttn.project.ecommerce.repos;

import com.ttn.project.ecommerce.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,Long> {

    User findByEmail(String email);

}
