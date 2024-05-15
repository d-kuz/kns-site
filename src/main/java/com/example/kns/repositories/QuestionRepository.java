
package com.example.kns.repositories;

import com.example.kns.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuestionRepository  extends JpaRepository<Question, Long> {

}
