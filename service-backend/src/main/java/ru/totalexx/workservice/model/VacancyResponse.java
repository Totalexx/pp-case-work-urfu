package ru.totalexx.workservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.totalexx.workservice.model.enums.ResponseStatus;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vacancy_responses")
public class VacancyResponse extends AbstractModel {

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @Column
    @Enumerated(EnumType.STRING)
    private ResponseStatus status;

    @OneToOne(mappedBy = "response")
    private Chat chat;
}
