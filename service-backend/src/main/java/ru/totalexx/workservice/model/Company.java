package ru.totalexx.workservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
public class Company extends AbstractModel {

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column
    private String name;

    @OneToMany(mappedBy = "company")
    private Set<Vacancy> vacancies;

    @OneToMany(mappedBy = "company")
    private Set<Rating> ratings;
}
