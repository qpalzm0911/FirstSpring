package com.example.first.Repository;

import com.example.first.Model.DAO.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepositary extends JpaRepository<Question, Long> {
}
