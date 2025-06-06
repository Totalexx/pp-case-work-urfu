package ru.totalexx.workservice.web.api.model.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.totalexx.workservice.model.Company;
import ru.totalexx.workservice.web.api.model.request.company.CreateCompanyRequest;
import ru.totalexx.workservice.web.api.model.response.company.CompanyResponse;

@DecoratedWith(CompanyMapperDecorator.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {
    Company toEntity(CreateCompanyRequest request);
    CompanyResponse toResponse(Company company);
}
