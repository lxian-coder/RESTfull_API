package com.jr.restapi.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * Darcy Xian  11/4/21  11:28 am      restAPI
 */
@Entity
@Getter
@Setter
@Table(name="student")
public class StudentEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    private UUID id;
    @Column(name = "first_name", unique = false, nullable = false)
    private String firstName;
    @Column(name = "password",  nullable = false)
    private String password;
}
