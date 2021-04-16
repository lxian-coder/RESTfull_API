package com.jr.restapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jr.restapi.dtos.StudentGetDTO;
import com.jr.restapi.dtos.StudentPostDTO;
import com.jr.restapi.services.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import  org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Darcy Xian  11/4/21  1:48 pm      restAPI
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testCreateStudent() throws Exception{
        StudentPostDTO studentPostDTO = new StudentPostDTO();
        StudentGetDTO studentGetDTO = new StudentGetDTO();
        studentGetDTO.setFirstName("aaa");
        studentGetDTO.setId("bbb");

        BDDMockito.given(studentService.createStudent(studentPostDTO)).willReturn(studentGetDTO);
        mockMvc.perform(post("/students")
                    // 把 java object 转化成 json
                    .content(objectMapper.writeValueAsString(studentPostDTO))
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.firstName").exists())
                    .andExpect(jsonPath("$.firstName").value("aaa"))
                    .andExpect(jsonPath("$.id").exists())
                    .andExpect(jsonPath("$.id").value("bbb"));


    }
}
