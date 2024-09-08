package com.example.CrudSQL.repository;

import com.example.CrudSQL.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {


}
