package ru.totalexx.workservice.web.api.model.response.vacancy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.totalexx.workservice.model.VacancyResponse;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VacancyListResponse {
    private List<VacancyResponse> vacancies;
    private Integer totalPages;
}
