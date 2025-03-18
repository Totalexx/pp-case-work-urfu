package ru.totalexx.workservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class UserProfile extends AbstractModel {

    @Column
    private String firstName;
    @Column
    private String middleName;
    @Column
    private String lastName;
}
