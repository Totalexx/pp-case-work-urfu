package ru.totalexx.workservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Resume extends AbstractModel {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String text;
}
