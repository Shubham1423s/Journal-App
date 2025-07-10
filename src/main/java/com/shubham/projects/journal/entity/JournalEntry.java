package com.shubham.projects.journal.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "journal_entries")
@Data// it store all the things that we need using lombok dependencies i did this
@NoArgsConstructor
public class JournalEntry {

    @Id//id should be unique so this annotation means we added primary key
    private ObjectId id;
    @NonNull// means title can not be null
    private String title;
    private String content;




}
