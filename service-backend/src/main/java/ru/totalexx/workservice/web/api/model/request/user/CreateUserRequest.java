package ru.totalexx.workservice.web.api.model.request.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.totalexx.workservice.model.enums.UserRole;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String email;
    private String password;
    private UserRole role;
    private UserProfileRequest profile;
}