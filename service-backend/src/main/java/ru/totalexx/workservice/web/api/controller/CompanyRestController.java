package ru.totalexx.workservice.web.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.totalexx.workservice.model.Company;
import ru.totalexx.workservice.service.CompanyService;
import ru.totalexx.workservice.web.api.model.mapper.CompanyMapper;
import ru.totalexx.workservice.web.api.model.request.company.CreateCompanyRequest;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyRestController {

    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    @PostMapping("create")
    public ResponseEntity<Void> create(CreateCompanyRequest request) {
        Company entity = companyMapper.toEntity(request);
        companyService.create(entity);

        return ResponseEntity.ok().build();
    }
}
