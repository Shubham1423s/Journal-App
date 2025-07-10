package com.shubham.projects.journal.entity;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Builder
@Document(collection = "user")// collection name created in the mongo db if we don't provide it
// will use class name
@Data
public class User {

@Id
   private ObjectId id;

  @Indexed(unique = true)// userName should be unique that's why we use this
  @NonNull
   private String userName;

  @NonNull
   private String password;

  @DBRef// it is used to connect user to journal
  private List<JournalEntry>  journalEntries = new ArrayList<>();

  private List<String> roles;
}
