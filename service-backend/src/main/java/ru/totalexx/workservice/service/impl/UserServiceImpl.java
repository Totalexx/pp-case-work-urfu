package ru.totalexx.workservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.totalexx.workservice.exception.ServiceException;
import ru.totalexx.workservice.model.User;
import ru.totalexx.workservice.model.UserProfile;
import ru.totalexx.workservice.repository.UserRepository;
import ru.totalexx.workservice.service.UserService;
import ru.totalexx.workservice.service.util.AuthUtils;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthUtils authUtils;

    @Override
    public void create(User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "Email не может быть пустым");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "Email уже используется");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "Password не может быть пустым");
        }

        userRepository.save(user);
    }

    @Override
    public UserProfile getProfile() {
        return authUtils.getCurrentUser().getProfile();
    }

    @Override
    public void updateProfile(UserProfile userProfile) {
        User user = authUtils.getCurrentUser();
        user.setProfile(userProfile);
        userRepository.save(user);
    }
}
