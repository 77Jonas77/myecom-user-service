package dev.jsojka.myecom_user_service.dto;

import dev.jsojka.myecom_user_service.model.UserEntity;
import lombok.Builder;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

/**
 * DTO for {@link UserEntity}
 */
@Builder
public record UserRegisterResponseDTO(UUID id, String firstName, String lastName, String imageUrl, String email,
                                      String phone, Instant createdAt, Instant updatedAt) implements Serializable {
}