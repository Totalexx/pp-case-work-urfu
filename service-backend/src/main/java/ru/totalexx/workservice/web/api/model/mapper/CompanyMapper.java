package ru.totalexx.workservice.web.api.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.totalexx.workservice.model.Company;
import ru.totalexx.workservice.model.User;
import ru.totalexx.workservice.model.UserProfile;
import ru.totalexx.workservice.web.api.model.request.company.CreateCompanyRequest;
import ru.totalexx.workservice.web.api.model.request.user.CreateUserRequest;
import ru.totalexx.workservice.web.api.model.request.user.UserProfileRequest;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {
    Company toEntity(CreateCompanyRequest request);
}
