package com.assignment.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.assignment.rest.domain.User;

public interface UserRepository extends MongoRepository<User, String>{

}
