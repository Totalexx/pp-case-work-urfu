package ru.totalexx.workservice.model;

import jakarta.persistence.*;
import ru.totalexx.workservice.model.enums.VacancyStatus;

import java.util.Set;

@Entity
public class Vacancy extends AbstractModel {

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String location;

    @Column
    @Enumerated(EnumType.STRING)
    private VacancyStatus status;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "vacancy_id")
    private Set<VacancyResponse> responses;
}
