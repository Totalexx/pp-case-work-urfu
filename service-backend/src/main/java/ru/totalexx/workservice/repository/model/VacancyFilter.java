package ru.totalexx.workservice.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VacancyFilter {
    private String title;
    private Integer minSalary;
    private Integer maxSalary;
    private String locationStarts;
    private Integer page;
}
