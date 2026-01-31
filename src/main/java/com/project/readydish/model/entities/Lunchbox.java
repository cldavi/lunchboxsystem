package com.project.readydish.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lunchbox")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lunchbox {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true)
    private String id;

    @Column(nullable = false, length = 55, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

//    private String image;

    @Column(nullable = false)
    private Double price;

    public Lunchbox(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
