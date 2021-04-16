package com.jr.restapi.controllers;

import com.jr.restapi.dtos.StudentGetDTO;
import com.jr.restapi.dtos.StudentPostDTO;
import com.jr.restapi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Darcy Xian  11/4/21  10:35 am      restAPI
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentGetDTO> createStudent(@RequestBody StudentPostDTO studentPostDTO){

        StudentGetDTO studentGetDTO = studentService.createStudent(studentPostDTO);
        return ResponseEntity.ok(studentGetDTO);
    }




}
