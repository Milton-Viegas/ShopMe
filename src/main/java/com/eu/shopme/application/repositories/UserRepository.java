package com.eu.shopme.application.repositories;

import com.eu.shopme.application.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{}
