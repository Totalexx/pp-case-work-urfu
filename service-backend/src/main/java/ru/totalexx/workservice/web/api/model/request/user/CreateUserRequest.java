package ru.totalexx.workservice.web.api.model.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @Email(message = "Неверный формат email")
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private UserRole role;
    @NotBlank
    private UserProfileRequest profile;
}