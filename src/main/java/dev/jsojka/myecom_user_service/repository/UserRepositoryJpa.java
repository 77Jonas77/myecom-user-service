package dev.jsojka.myecom_user_service.repository;

import dev.jsojka.myecom_user_service.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryJpa extends JpaRepository<UserEntity, UUID> {

    boolean existsByEmail(String email);

    Optional<UserEntity> findUserById(UUID userId);

    @Modifying
    @Query("update UserEntity u set u.firstName = :firstName, u.lastName = :lastName, " +
            "u.email = :email, u.imageUrl = :imageUrl, u.phone = :phone, " +
            "u.updatedAt = :updatedAt where u.id = :id")
    void update(
            @Param("id") UUID id,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("email") String email,
            @Param("imageUrl") String imageUrl,
            @Param("phone") String phone,
            @Param("updatedAt") Instant updatedAt
    );

}
