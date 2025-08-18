package dev.jsojka.myecom_user_service.repository;

import dev.jsojka.myecom_user_service.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositoryJpa extends JpaRepository<UserEntity, UUID> {

    boolean existsByEmail(String email);

    UserEntity findUserById(UUID userId);
}
