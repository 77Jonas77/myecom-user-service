package dev.jsojka.myecom_user_service.dto;

import dev.jsojka.myecom_user_service.model.UserEntity;
import lombok.Builder;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link UserEntity}
 */
@Builder
public record UserDTO(UUID id, String firstName, String lastName, String imageUrl, String email,
                      String phone) implements Serializable {
}