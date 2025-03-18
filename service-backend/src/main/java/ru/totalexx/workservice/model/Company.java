package ru.totalexx.workservice.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Company extends AbstractModel {

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column
    private String name;

    @OneToMany(mappedBy = "company_id")
    private Set<Vacancy> vacancies;

    @OneToMany(mappedBy = "owner_id")
    private Set<Rating> ratings;
}
