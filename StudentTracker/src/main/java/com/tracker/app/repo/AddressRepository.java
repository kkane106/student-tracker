package com.tracker.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.tracker.app.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
