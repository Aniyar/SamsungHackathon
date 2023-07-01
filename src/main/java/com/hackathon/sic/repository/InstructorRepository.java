package com.hackathon.sic.repository;

import com.hackathon.sic.model.Assignment;
import com.hackathon.sic.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
	Optional<Instructor> findByUser_Id(Integer id);
}
