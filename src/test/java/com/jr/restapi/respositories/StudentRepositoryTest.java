package com.jr.restapi.respositories;

import com.jr.restapi.RestApiApplication;
import com.jr.restapi.entities.StudentEntity;
import com.jr.restapi.repositories.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

/**
 * Darcy Xian  11/4/21  2:17 pm      restAPI
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RestApiApplication.class)
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void shouldAddStudentIntoDBSuccessfullyGivenPropertyStudentObject(){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName("aaa");
        studentEntity.setPasswrod("bbb");
        StudentEntity returnedStudent = studentRepository.save(studentEntity);
        Assertions.assertEquals("aaa",returnedStudent.getFirstName());
    }
}
