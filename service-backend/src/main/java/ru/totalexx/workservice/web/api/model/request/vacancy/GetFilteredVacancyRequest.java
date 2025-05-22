package ru.totalexx.workservice.web.api.model.request.vacancy;

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
    private Integer minSalary;
    private Integer maxSalary;
    private String locationStarts;
    private Integer page;
}
