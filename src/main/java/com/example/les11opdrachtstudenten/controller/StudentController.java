package com.example.les11opdrachtstudenten.controller;

import com.example.les11opdrachtstudenten.model.Student;
import com.example.les11opdrachtstudenten.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    StudentRepository repos;

    @GetMapping
    public ResponseEntity<Iterable<Student>>getStudent(){
        return ResponseEntity.ok(repos.findAll());
    }

@PostMapping
    public ResponseEntity<Student>createStudent(@RequestBody Student s){
        repos.save(s);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + s.getStudentNr()).toUriString());
        return  ResponseEntity.created(uri).body(s);
    }

    @GetMapping("/fullname")
public ResponseEntity<Iterable<Student>>getStudentBySubstring(@RequestParam String name){
        Iterable<Student> students = repos.findByFullNameContaining(name);
        return ResponseEntity.ok(students);
    }
}



