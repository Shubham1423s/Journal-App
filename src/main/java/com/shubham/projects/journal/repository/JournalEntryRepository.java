package com.shubham.projects.journal.repository;

import com.shubham.projects.journal.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.mongo.MongoConnectionDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {


    // best practices are
    // controller class calls ---> service class call --> repository class
}
