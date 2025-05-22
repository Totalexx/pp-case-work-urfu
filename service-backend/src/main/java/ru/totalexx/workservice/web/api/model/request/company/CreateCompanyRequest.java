package ru.totalexx.workservice.web.api.model.request.company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyRequest {
    @NotBlank
    private Long ownerId;
    @NotEmpty
    private String name;
}
