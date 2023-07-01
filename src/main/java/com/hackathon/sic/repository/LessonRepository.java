package com.hackathon.sic.repository;

import com.hackathon.sic.model.Assignment;
import com.hackathon.sic.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {
}
