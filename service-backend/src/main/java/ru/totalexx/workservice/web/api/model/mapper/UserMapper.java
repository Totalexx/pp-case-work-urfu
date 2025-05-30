package ru.totalexx.workservice.web.api.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.totalexx.workservice.model.User;
import ru.totalexx.workservice.model.UserProfile;
import ru.totalexx.workservice.web.api.model.request.user.CreateUserRequest;
import ru.totalexx.workservice.web.api.model.request.user.UserProfileRequest;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    default User toEntity(CreateUserRequest request) {
        UserProfile profile = new UserProfile();
        profile.setFirstName(request.getFirstName());
        profile.setMiddleName(request.getMiddleName());
        profile.setLastName(request.getLastName());

        return new User(
                request.getEmail(),
                request.getPassword(),
                request.getRole(),
                profile
        );
    }

    UserProfile toEntity(UserProfileRequest request);
}
