package com.example.CrudSQL.controller;

import com.example.CrudSQL.entity.Student;
import com.example.CrudSQL.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/students")

public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping
    public List<Student> getAll() {

        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") Long id) {

        return studentService.getStudent(id);
    }

    @PostMapping
    public void saveUpdated(@RequestBody Student student) {
        studentService.saveOrUpdate(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        studentService.delete(id);
    }

}




