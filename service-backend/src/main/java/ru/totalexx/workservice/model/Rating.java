package ru.totalexx.workservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Rating extends AbstractModel {

    @Column
    private Integer rating;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
