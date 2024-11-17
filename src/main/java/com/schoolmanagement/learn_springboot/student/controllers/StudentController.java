package com.schoolmanagement.learn_springboot.student.controllers;

import com.schoolmanagement.learn_springboot.student.Student;
import com.schoolmanagement.learn_springboot.student.StudentRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.crossstore.ChangeSetPersister.*;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("students")
    private Student createStudent(
            @RequestBody Student student
            ) {
        return this.studentRepository.save(student);
    }

    @GetMapping("students")
    private List<Student> findAllStudents(
            @PathParam("search") String search
    ) {
        return this.studentRepository.findAll();
    }

    @GetMapping("students/{id}")
    private Student findAStudent(@PathVariable("id") int id){
        return this.studentRepository.findById(id)
                .orElse(new Student());
    }

    @PatchMapping("students/{id}")
    private Student updateStudent(
            @RequestBody Student studentBody,
            @PathVariable("id") int id
    ) {
        Student student = this.findAStudent(id);
        return this.studentRepository.save(studentBody);
    }

    @DeleteMapping("students/{id}")
    private Student deleteStudent(
            @PathVariable("id") int id
    ) throws NotFoundException {
        Student student = this.findAStudent(id);
        if(student == null) {
            throw new NotFoundException();
        };
        this.studentRepository.deleteById(id);
        return student;
    }

}
