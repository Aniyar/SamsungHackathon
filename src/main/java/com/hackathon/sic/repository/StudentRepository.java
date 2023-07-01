package com.hackathon.sic.repository;

import com.hackathon.sic.model.Assignment;
import com.hackathon.sic.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
