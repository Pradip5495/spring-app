package com.test.demo.controllers;


import com.test.demo.model.Student;
import com.test.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

  @Autowired
  public StudentRepository studentRepository;

  @GetMapping(value="/all")
  public List<Student> getAllStudents(){
    return studentRepository.findAll();

  }

  @PostMapping(value="/create")
  public String createStudents(@RequestBody Student student){
    Student insertStudent = studentRepository.insert(student);
  return "Student created" + insertStudent.getName();
  }

}
