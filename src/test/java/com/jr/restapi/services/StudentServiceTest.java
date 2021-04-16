package com.jr.restapi.services;

import com.jr.restapi.dtos.StudentGetDTO;
import com.jr.restapi.dtos.StudentPostDTO;
import com.jr.restapi.entities.StudentEntity;
import com.jr.restapi.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
/**
 * Darcy Xian  11/4/21  1:15 pm      restAPI
 */
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks // DI and use with @Mock above together
    StudentService studentService;


    @Test
    public void shouldAddStudentSuccessfullyGivenProperStudent(){
        StudentPostDTO studentPostDTO = new StudentPostDTO();
        studentPostDTO.setFirstName("Darcy");
        studentPostDTO.setPassword("123");

        StudentEntity mockStudentEntity = new StudentEntity();
        mockStudentEntity.setPasswrod("123");
        mockStudentEntity.setFirstName("Darcy");
        UUID studentId = UUID.randomUUID();
        mockStudentEntity.setId(studentId);
        // only mock class can use when return method.
        when(studentRepository.save(any())).thenReturn(mockStudentEntity);

        StudentGetDTO studentGetDTO = studentService.createStudent(studentPostDTO);

        assertEquals(studentGetDTO.getFirstName(),"Darcy");
        assertEquals(studentGetDTO.getId(),studentId.toString());

    }
}
