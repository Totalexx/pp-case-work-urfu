package ru.totalexx.workservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.totalexx.workservice.model.enums.VacancyStatus;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vacancy extends AbstractModel {

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String location;

    @Column
    private Integer salary;

    @Column
    private Integer workingHours;

    @Column
    @Enumerated(EnumType.STRING)
    private VacancyStatus status;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "vacancy")
    private Set<VacancyResponse> responses;
}
