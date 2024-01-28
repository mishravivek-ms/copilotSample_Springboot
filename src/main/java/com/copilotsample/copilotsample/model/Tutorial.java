package com.copilotsample.copilotsample.model;

//create a Entity class called Tutorial  with the following attributes: id, title, description, published. Make sure ID as a primary key and auto increment.
// use lombok to generate getters and setters. use tostring method to print the object.
//create a constructor that takes all the properties as arguments
// make table name as "tutorials"

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tutorials")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private boolean published;

    //create a validation on all fields
    public boolean validate() {
        if (this.title == null || this.title.isEmpty()) {
            System.out.println("Title is empty");
            return false;
        }
        if (this.description == null || this.description.isEmpty()) {
            System.out.println("Description is empty");
            return false;
        }
        return true;
    }
    // getters and setters
}

