package ru.totalexx.workservice.web.api.model.request.vacancy;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateVacancyRequest {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String location;
    private Integer salary;
    @Min(value = 1, message = "Количество рабочих часов должно быть больше 0")
    private Integer workingHours;

    @NotNull
    private Long companyId;
}
