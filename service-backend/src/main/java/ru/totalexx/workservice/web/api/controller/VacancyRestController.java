package ru.totalexx.workservice.web.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.totalexx.workservice.model.Vacancy;
import ru.totalexx.workservice.model.VacancyResponse;
import ru.totalexx.workservice.repository.model.VacancyFilter;
import ru.totalexx.workservice.service.VacancyService;
import ru.totalexx.workservice.web.api.model.mapper.VacancyMapper;
import ru.totalexx.workservice.web.api.model.request.vacancy.AddVacancyResponseRequest;
import ru.totalexx.workservice.web.api.model.request.vacancy.CreateVacancyRequest;
import ru.totalexx.workservice.web.api.model.request.vacancy.GetFilteredVacancyRequest;
import ru.totalexx.workservice.web.api.model.response.vacancy.VacancyListResponse;

@RestController
@RequestMapping("/api/v1/vacancy")
@RequiredArgsConstructor
public class VacancyRestController {

    private final VacancyService vacancyService;
    private final VacancyMapper vacancyMapper;

    @GetMapping("get/filter")
    public VacancyListResponse getVacancies(@Valid GetFilteredVacancyRequest request) {
        VacancyFilter filter = vacancyMapper.toFilter(request);
        vacancyService.getAll(filter);
        return vacancyMapper.toResponse(vacancyService.getAll(filter));
    }

    @GetMapping("get/{id}")
    public VacancyResponse getVacancyById(@PathVariable Long id) {
        Vacancy vacancy = vacancyService.getById(id);
        return vacancyMapper.toResponse(vacancy);
    }

    @PostMapping("create")
    public ResponseEntity<Void> createVacancy(@Valid CreateVacancyRequest request) {
        Vacancy vacancy = vacancyMapper.toEntity(request);
        vacancyService.create(vacancy);
        return ResponseEntity.ok().build();
    }

    @PostMapping("response/add")
    public ResponseEntity<Void> addResponse(@Valid AddVacancyResponseRequest request) {
        VacancyResponse vacancyResponse = vacancyMapper.toEntity(request);
        vacancyService.addResponse(vacancyResponse);

        return ResponseEntity.ok().build();
    }

    @GetMapping("response/delete")
    public ResponseEntity<Void> deleteResponse(Long responseId) {
        vacancyService.deleteResponse(responseId);
        return ResponseEntity.ok().build();
    }
}
