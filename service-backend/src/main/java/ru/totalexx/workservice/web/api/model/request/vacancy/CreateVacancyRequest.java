package ru.totalexx.workservice.web.api.model.request.vacancy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateVacancyRequest {
    private String title;
    private String description;
    private String location;
    private Integer salary;
    private Integer workingHours;
    private Long companyId;
}
