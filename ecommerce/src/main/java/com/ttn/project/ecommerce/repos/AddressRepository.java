package com.ttn.project.ecommerce.repos;

import com.ttn.project.ecommerce.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
