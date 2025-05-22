package ru.totalexx.workservice.service.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.totalexx.workservice.exception.ServiceException;
import ru.totalexx.workservice.model.User;

@Component
public class AuthUtils {
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (isAuthenticated())
            return (User) auth.getPrincipal();

        throw new ServiceException(
                org.springframework.http.HttpStatus.UNAUTHORIZED,
                "Пользователь не авторизован"
        );
    }

    public boolean isAuthenticated() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null && auth.isAuthenticated()
                && !(auth.getPrincipal() instanceof String && auth.getPrincipal().equals("anonymousUser"));
    }
}
