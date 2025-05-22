package ru.totalexx.workservice.web.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.totalexx.workservice.model.User;
import ru.totalexx.workservice.service.UserService;
import ru.totalexx.workservice.web.api.model.mapper.UserMapper;
import ru.totalexx.workservice.web.api.model.request.user.CreateUserRequest;
import ru.totalexx.workservice.web.api.model.request.user.UpdateUserProfileRequest;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping()
    public ResponseEntity<Void> create(@Valid CreateUserRequest request) {
        User entity = userMapper.toEntity(request);
        userService.create(entity);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateProfile(@Valid UpdateUserProfileRequest request) {
        return ResponseEntity.ok().build();
    }
}
