package com.itechart.boot.repository;

import com.itechart.boot.domain.ExamStudentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamStudentResultRepository extends JpaRepository<ExamStudentResult, Integer> {
}
