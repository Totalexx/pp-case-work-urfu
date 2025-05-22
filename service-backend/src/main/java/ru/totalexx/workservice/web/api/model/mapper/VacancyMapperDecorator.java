package ru.totalexx.workservice.web.api.model.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.totalexx.workservice.exception.ServiceException;
import ru.totalexx.workservice.model.Company;
import ru.totalexx.workservice.model.Resume;
import ru.totalexx.workservice.model.Vacancy;
import ru.totalexx.workservice.model.VacancyResponse;
import ru.totalexx.workservice.model.enums.ResponseStatus;
import ru.totalexx.workservice.model.enums.VacancyStatus;
import ru.totalexx.workservice.repository.CompanyRepository;
import ru.totalexx.workservice.repository.ResumeRepository;
import ru.totalexx.workservice.repository.VacancyRepository;
import ru.totalexx.workservice.web.api.model.request.vacancy.AddVacancyResponseRequest;
import ru.totalexx.workservice.web.api.model.request.vacancy.CreateVacancyRequest;

@Component
public abstract class VacancyMapperDecorator implements VacancyMapper {

    private CompanyRepository companyRepository;
    private VacancyRepository vacancyRepository;
    private ResumeRepository resumeRepository;

    @Override
    public Vacancy toEntity(CreateVacancyRequest request) {
        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Компания не найдена"));

        Vacancy vacancy = new Vacancy();
        vacancy.setCompany(company);
        vacancy.setTitle(request.getTitle());
        vacancy.setDescription(request.getDescription());
        vacancy.setSalary(request.getSalary());
        vacancy.setLocation(request.getLocation());
        vacancy.setStatus(VacancyStatus.ACTIVE);
        vacancy.setWorkingHours(request.getWorkingHours());

        return vacancy;
    }

    public VacancyResponse toEntity(AddVacancyResponseRequest request) {
        Vacancy vacancy = vacancyRepository.findById(request.getVacancyId())
                .orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Вакансия не найдена"));

        Resume resume = resumeRepository.findById(request.getResumeId())
                .orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Резюме не найдено"));

        VacancyResponse vacancyResponse = new VacancyResponse();
        vacancyResponse.setVacancy(vacancy);
        vacancyResponse.setResume(resume);
        vacancyResponse.setStatus(ResponseStatus.AWAITING);

        return vacancyResponse;
    }


    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Autowired
    public void setVacancyRepository(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    @Autowired
    public void setResumeRepository(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }
}
