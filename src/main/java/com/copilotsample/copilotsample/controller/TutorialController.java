package com.copilotsample.copilotsample.controller;

//Create a class named TutorialController that is annotated with @RestController and @RequestMapping with a value of /api.
//Create a method that returns a list of tutorials by published status
//Create a method that returns a list of tutorials by title containing a keyword

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.copilotsample.copilotsample.model.Tutorial;
import com.copilotsample.copilotsample.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TutorialController {

    @Autowired
    private TutorialRepository tutorialRepository;

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
        List<Tutorial> tutorials = title == null ? tutorialRepository.findAll() : tutorialRepository.findByTitleContaining(title);
        return ResponseEntity.ok(tutorials);
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
        Tutorial tutorial = tutorialRepository.findById(id).orElseThrow(() -> new RuntimeException("Tutorial not found"));
        return ResponseEntity.ok(tutorial);
    }

    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        Tutorial createdTutorial = tutorialRepository.save(tutorial);
        return ResponseEntity.ok(createdTutorial);
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
        Tutorial tutorialData = tutorialRepository.findById(id).orElseThrow(() -> new RuntimeException("Tutorial not found"));
        tutorialData.setTitle(tutorial.getTitle());
        tutorialData.setDescription(tutorial.getDescription());
        tutorialData.setPublished(tutorial.isPublished());
        Tutorial updatedTutorial = tutorialRepository.save(tutorialData);
        return ResponseEntity.ok(updatedTutorial);
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<Void> deleteTutorial(@PathVariable("id") long id) {
        tutorialRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<Void> deleteAllTutorials() {
        tutorialRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

    //Create a method that returns a list of tutorials by title containing a keyword
    @GetMapping("/tutorials/published")
    public List<Tutorial> findByPublished() {
        return tutorialRepository.findByPublished(true);
    }
}


