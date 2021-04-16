package com.jr.restapi.services;

import com.jr.restapi.dtos.StudentGetDTO;
import com.jr.restapi.dtos.StudentPostDTO;
import com.jr.restapi.entities.StudentEntity;
import com.jr.restapi.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Darcy Xian  11/4/21  11:06 am      restAPI
 */
@Service
@RequiredArgsConstructor // attribute must be final
public class StudentService {


   private final StudentRepository studentRepository;


    public StudentGetDTO createStudent (StudentPostDTO studentPostDTO){
    StudentEntity savaStudentEntity = studentRepository.save(this.mapPostDOTToEntity(studentPostDTO));
    StudentGetDTO studentGetDTO = this.mapEntityToGetDTO(savaStudentEntity);

    return studentGetDTO;

    }

    private StudentEntity mapPostDOTToEntity(StudentPostDTO studentPostDTO){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(studentPostDTO.getFirstName());
        studentEntity.setPassword(studentPostDTO.getPassword());

        return studentEntity;
    }

    private StudentGetDTO mapEntityToGetDTO(StudentEntity studentEntity){
        StudentGetDTO studentGetDTO = new StudentGetDTO();
        studentGetDTO.setId(studentEntity.getId().toString());
        studentGetDTO.setFirstName(studentEntity.getFirstName());

        return studentGetDTO;

    }



}
