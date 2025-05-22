package ru.totalexx.workservice.web.api.model.request.user;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "Пароль не может быть пустым")
    private String password;
    @NotNull
    private UserRole role;
    @NotBlank
    private String firstName;
    @NotBlank
    private String middleName;
    @NotBlank
    private String lastName;
}