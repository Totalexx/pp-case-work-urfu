package ru.totalexx.workservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.totalexx.workservice.exception.ServiceException;
import ru.totalexx.workservice.model.User;
import ru.totalexx.workservice.model.UserProfile;
import ru.totalexx.workservice.repository.UserRepository;
import ru.totalexx.workservice.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

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
    public void updateProfile(UserProfile userProfile) {
        if (userProfile.getId() == null)
            throw new ServiceException(HttpStatus.BAD_REQUEST, "ID пользователя не может быть пустым");

        User user = userRepository.findById(userProfile.getId())
                .orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Пользователь не найден"));

        user.setProfile(userProfile);
        userRepository.save(user);
    }
}
