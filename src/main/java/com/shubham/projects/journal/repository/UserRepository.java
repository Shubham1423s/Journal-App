package com.shubham.projects.journal.repository;

import com.shubham.projects.journal.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository  extends MongoRepository<User, ObjectId> {

    User findByUserName (String username);
    User deleteByUserName (String username);
}
