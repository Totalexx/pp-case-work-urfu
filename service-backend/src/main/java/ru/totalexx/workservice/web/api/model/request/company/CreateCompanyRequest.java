package ru.totalexx.workservice.web.api.model.request.company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyRequest {
    @NotNull
    private Long ownerId;
    @NotBlank
    private String name;
}
