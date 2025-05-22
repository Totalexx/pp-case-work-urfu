package ru.totalexx.workservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.totalexx.workservice.model.enums.UserRole;

import java.util.Set;

@Entity
@Getter
@Setter
public class User extends AbstractModel {

    @Column
    private String email;

    @Getter
    private String password;

    @Column
    private UserRole role;

    @OneToOne(fetch = FetchType.EAGER)
    private UserProfile profile;
}
