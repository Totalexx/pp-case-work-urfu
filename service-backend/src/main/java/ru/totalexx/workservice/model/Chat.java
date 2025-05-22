package ru.totalexx.workservice.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "chats")
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
