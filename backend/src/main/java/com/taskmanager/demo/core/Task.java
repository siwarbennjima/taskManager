package com.taskmanager.demo.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id ;
    private String titre ;
    private String description ;
    private Date DL ;


}
