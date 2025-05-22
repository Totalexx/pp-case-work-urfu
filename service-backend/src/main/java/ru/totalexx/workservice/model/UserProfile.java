package ru.totalexx.workservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_profiles")
@NoArgsConstructor
@AllArgsConstructor
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
