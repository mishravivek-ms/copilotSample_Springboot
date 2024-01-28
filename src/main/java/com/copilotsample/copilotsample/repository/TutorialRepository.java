package com.copilotsample.copilotsample.repository;

//Create a Interface named TutorialRepository that extends JpaRepository and has a generic type of Tutorial and Long.
//Create a method that returns a list of tutorials by published status
//Create a method that returns a list of tutorials by title containing a keyword

import com.copilotsample.copilotsample.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContaining(String keyword);
}
