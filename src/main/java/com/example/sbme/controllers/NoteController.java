package com.example.sbme.controllers;

import com.example.sbme.models.Note;
import com.example.sbme.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @PostMapping("/notes")
    public Note create(@RequestBody Note note) {
        note.setId(UUID.randomUUID().toString());
        HttpStatus http;
        return noteRepository.save(note);
    }



    @GetMapping("/notes")
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    @GetMapping("/notes/{id}")
    public Note getById(@PathVariable String id) {
        return noteRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteById(@PathVariable String id) {
        noteRepository.deleteById(id);
    }
}


