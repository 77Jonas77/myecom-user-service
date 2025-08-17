package dev.jsojka.myecom_user_service.repository;

import dev.jsojka.myecom_user_service.dto.UserDTO;
import dev.jsojka.myecom_user_service.model.UserEntity;

public interface UserRepository {
    UserEntity save(UserDTO user);

    boolean existsByEmail(String email);
}
