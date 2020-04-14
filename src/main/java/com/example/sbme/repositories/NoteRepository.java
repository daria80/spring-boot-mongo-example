package com.example.sbme.repositories;

import com.example.sbme.models.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {

}
