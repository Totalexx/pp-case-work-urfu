package ru.totalexx.workservice.web.api.model.request.vacancy;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateVacancyRequest {

    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    @NotEmpty
    private String location;
    private Integer salary;
    @Min(value = 1, message = "Количество рабочих часов должно быть больше 0")
    private Integer workingHours;

    private Long companyId;
}
