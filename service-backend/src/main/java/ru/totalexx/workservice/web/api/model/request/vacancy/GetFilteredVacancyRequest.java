package ru.totalexx.workservice.web.api.model.request.vacancy;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetFilteredVacancyRequest {
    private String title;
    @Min(value = 0, message = "Минимальная зарплата должна быть больше 0")
    private Integer minSalary;
    private Integer maxSalary;
    private String locationStarts;

    @Min(value = 0, message = "Номер страницы должен быть больше 0")
    private Integer page;
}
