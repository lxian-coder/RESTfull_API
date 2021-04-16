package com.jr.restapi.repositories;

import com.jr.restapi.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Darcy Xian  11/4/21  11:24 am      restAPI
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {

}
