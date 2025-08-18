package dev.jsojka.myecom_user_service.repository;

import dev.jsojka.myecom_user_service.dto.UserDTO;
import dev.jsojka.myecom_user_service.model.UserEntity;

import java.util.UUID;

public interface UserRepository {
    UserEntity save(UserDTO user);

    boolean existsByEmail(String email);

    UserDTO findUserById(UUID userId);

    UserDTO update(UserDTO user);

    void deleteById(UUID userId);
}
