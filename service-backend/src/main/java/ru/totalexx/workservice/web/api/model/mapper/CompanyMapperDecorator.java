package ru.totalexx.workservice.web.api.model.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.totalexx.workservice.exception.ServiceException;
import ru.totalexx.workservice.model.Company;
import ru.totalexx.workservice.repository.UserRepository;
import ru.totalexx.workservice.web.api.model.request.company.CreateCompanyRequest;

@Component
public abstract class CompanyMapperDecorator implements CompanyMapper {

    private UserRepository userRepository;

    @Override
    public Company toEntity(CreateCompanyRequest request) {
        Company company = new Company();
        company.setName(request.getName());
        company.setOwner(userRepository.findById(request.getOwnerId()).orElseThrow(
                () -> new ServiceException(HttpStatus.NOT_FOUND, "Пользователь не найден")));

        return company;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
