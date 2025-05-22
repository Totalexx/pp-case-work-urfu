package ru.totalexx.workservice.web.api.model.request.user;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserProfileRequest {
    private String firstName;
    private String middleName;
    private String lastName;
}
