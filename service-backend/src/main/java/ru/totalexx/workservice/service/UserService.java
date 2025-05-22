package ru.totalexx.workservice.service;

import ru.totalexx.workservice.model.User;
import ru.totalexx.workservice.model.UserProfile;

public interface UserService {
    void create(User user);
    void updateProfile(UserProfile userProfile);
}
