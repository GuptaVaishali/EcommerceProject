package com.ttn.project.ecommerce.repos;

import com.ttn.project.ecommerce.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

}
