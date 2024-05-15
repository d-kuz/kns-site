package com.example.kns.repositories;

import com.example.kns.models.QuestionsAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsAnswerRepository  extends JpaRepository<QuestionsAnswer, Long> {
}