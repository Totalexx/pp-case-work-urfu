package ru.totalexx.workservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.totalexx.workservice.exception.ServiceException;
import ru.totalexx.workservice.model.Chat;
import ru.totalexx.workservice.model.Vacancy;
import ru.totalexx.workservice.model.VacancyResponse;
import ru.totalexx.workservice.model.enums.ResponseStatus;
import ru.totalexx.workservice.repository.VacancyRepository;
import ru.totalexx.workservice.repository.VacancyResponseRepository;
import ru.totalexx.workservice.repository.model.VacancyFilter;
import ru.totalexx.workservice.repository.specification.VacancySpecification;
import ru.totalexx.workservice.service.VacancyService;
import ru.totalexx.workservice.service.util.AuthUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final AuthUtils authUtils;
    private final VacancyRepository vacancyRepository;
    private final VacancyResponseRepository vacancyResponseRepository;

    @Override
    public void create(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    @Override
    public Page<Vacancy> getAll(VacancyFilter filter) {
        int page = 0;
        int pageSize = 100;

        return vacancyRepository.findAll(
                VacancySpecification.filter(filter),
                PageRequest.of(page, pageSize)
        );
    }

    @Override
    public Vacancy getById(Long id) {
        return vacancyRepository.findById(id)
                .orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Вакансия не найдена"));
    }

    @Override
    public List<VacancyResponse> getAllResponses() {
        return vacancyResponseRepository.findAllByResume_User(authUtils.getCurrentUser());
    }

    @Override
    public void addResponse(VacancyResponse response) {
        response.setStatus(ResponseStatus.AWAITING);
        response.setChat(createChat(response));
        vacancyResponseRepository.save(response);
    }

    @Override
    public void deleteResponse(Long id) {
        VacancyResponse response = vacancyResponseRepository.findById(id)
                .orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Отклик не найден"));

        vacancyResponseRepository.delete(response);

    }

    private Chat createChat(VacancyResponse vacancy) {
        return null;
    }
}
