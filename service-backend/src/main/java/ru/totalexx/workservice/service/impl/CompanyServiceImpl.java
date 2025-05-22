package ru.totalexx.workservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.totalexx.workservice.model.Company;
import ru.totalexx.workservice.repository.CompanyRepository;
import ru.totalexx.workservice.service.CompanyService;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public void create(Company company) {
        companyRepository.save(company);
    }
}
