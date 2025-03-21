package ru.totalexx.workservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Rating extends AbstractModel {

    @Column
    private Integer rating;

    @Column
    private String comment;
}
