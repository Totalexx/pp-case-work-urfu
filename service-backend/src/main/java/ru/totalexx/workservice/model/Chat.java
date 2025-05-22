package ru.totalexx.workservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.Set;

@Entity
public class Chat extends AbstractModel {

    @OneToOne
    private User employer;

    @OneToOne
    private User student;

    @OneToOne
    @JoinColumn(name = "response_id")
    private VacancyResponse response;

    @OneToMany(mappedBy = "chat")
    private Set<Message> messages;
}
