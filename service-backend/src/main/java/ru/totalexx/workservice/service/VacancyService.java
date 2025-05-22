package ru.totalexx.workservice.service;

import org.springframework.data.domain.Page;
import ru.totalexx.workservice.model.Vacancy;
import ru.totalexx.workservice.model.VacancyResponse;
import ru.totalexx.workservice.repository.model.VacancyFilter;

public interface VacancyService {
    void create(Vacancy vacancy);
    Page<Vacancy> getAll(VacancyFilter filter);
    Vacancy getById(Long id);
    void addResponse(VacancyResponse response);
    void deleteResponse(Long id);
}
