package dev.jsojka.myecom_user_service.repository;

import dev.jsojka.myecom_user_service.dto.user.UserDto;
import dev.jsojka.myecom_user_service.model.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    UserEntity save(UserDto user);

    boolean existsByEmail(String email);

    Optional<UserDto> findUserById(UUID userId);

    UserDto update(UserDto user);

    void deleteById(UUID userId);
}
