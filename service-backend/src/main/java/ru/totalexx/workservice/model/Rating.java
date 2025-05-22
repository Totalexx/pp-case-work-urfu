package ru.totalexx.workservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating extends AbstractModel {

    @Column
    private Integer rating;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
