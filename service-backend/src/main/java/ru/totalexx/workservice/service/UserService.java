package ru.totalexx.workservice.service;

import ru.totalexx.workservice.model.User;
import ru.totalexx.workservice.model.UserProfile;

public interface UserService {
    void create(User user);
    UserProfile getProfile();
    void updateProfile(UserProfile userProfile);
}
