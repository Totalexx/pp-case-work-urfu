package ru.totalexx.workservice.web.api.model.response.vacancy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VacancyListResponse {
    private List<VacancyApiResponse> vacancies;
    private Integer totalPages;
}
