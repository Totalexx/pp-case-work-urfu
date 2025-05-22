package ru.totalexx.workservice.web.api.model.response.vacancy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.totalexx.workservice.model.enums.ResponseStatus;
import ru.totalexx.workservice.web.api.model.response.company.CompanyResponse;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VacancyApiResponse {
    private Long id;
    private String title;
    private String description;
    private String location;
    private Integer salary;
    private Integer workingHours;
    private ResponseStatus status;
    private CompanyResponse company;
}
