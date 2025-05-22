package ru.totalexx.workservice.web.api.model.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import ru.totalexx.workservice.model.Vacancy;
import ru.totalexx.workservice.model.VacancyResponse;
import ru.totalexx.workservice.repository.model.VacancyFilter;
import ru.totalexx.workservice.web.api.model.request.vacancy.AddVacancyResponseRequest;
import ru.totalexx.workservice.web.api.model.request.vacancy.CreateVacancyRequest;
import ru.totalexx.workservice.web.api.model.request.vacancy.GetFilteredVacancyRequest;
import ru.totalexx.workservice.web.api.model.response.vacancy.VacancyApiResponse;
import ru.totalexx.workservice.web.api.model.response.vacancy.VacancyApiResponseListResponse;
import ru.totalexx.workservice.web.api.model.response.vacancy.VacancyListResponse;

import java.util.List;

@DecoratedWith(VacancyMapperDecorator.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {CompanyMapper.class})
public interface VacancyMapper {
    VacancyFilter toFilter(GetFilteredVacancyRequest request);
    VacancyApiResponse toResponse(Vacancy vacancy);

    default VacancyListResponse toResponse(Page<Vacancy> vacancies) {
        VacancyListResponse response = new VacancyListResponse();
        List<VacancyApiResponse> content = vacancies.getContent().stream().map(this::toResponse).toList();
        response.setVacancies(content);
        response.setTotalPages(vacancies.getTotalPages());

        return response;
    }

    Vacancy toEntity(CreateVacancyRequest request);

    VacancyResponse toEntity(AddVacancyResponseRequest request);

    VacancyApiResponse toResponse(VacancyResponse response);

    default VacancyApiResponseListResponse toResponse(List<VacancyResponse> allResponses) {
        return new VacancyApiResponseListResponse(allResponses.stream().map(this::toResponse).toList());
    }
}
