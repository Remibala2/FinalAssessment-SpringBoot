package org.generation.SpringBootAssessment.repository.entity;

import org.generation.SpringBootAssessment.controller.dto.ItemDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

//Repository is the model layer
//JPA (Java Persistence API) map Java Objects (Class) to the database tables
//This concept is known as ORM(Object Relational Mapping)
//Item is an entity that will be used to map with the Item table in the database
//E.g if you have a category table, then you have to create another entity
//1 table = 1 entity

@Entity
public class Item {
    //Table columns is the item attributes of the class
    //Database is responsible for auto generating the primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Date date;


    public Item(){}

    public Item(ItemDTO itemDTO)
    {
        this.title = itemDTO.getTitle();
        this.description = itemDTO.getDescription();
        this.date = itemDTO.getDate();
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public Date getDate() {return date;}

    public void setDate(Date date) {this.date = date;}

    @Override
    public String toString()
    {
        return "ToDo{" + "id=" +id+", Title =' " +title+ '\'' + ", description='" + description+ '\'' + ", Date='" + date +'}';
    }
}