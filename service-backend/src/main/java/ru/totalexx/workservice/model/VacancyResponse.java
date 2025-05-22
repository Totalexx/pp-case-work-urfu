package ru.totalexx.workservice.model;

import jakarta.persistence.*;
import ru.totalexx.workservice.model.enums.VacancyStatus;

@Entity
public class VacancyResponse extends AbstractModel {

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @Column
    @Enumerated(EnumType.STRING)
    private VacancyStatus status;

    @OneToOne(mappedBy = "response")
    private Chat chat;
}
