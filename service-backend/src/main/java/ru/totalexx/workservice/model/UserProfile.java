package ru.totalexx.workservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class UserProfile extends AbstractModel {

    @Column
    private String firstName;
    @Column
    private String middleName;
    @Column
    private String lastName;

    @OneToOne(mappedBy = "profile")
    private User user;
}
