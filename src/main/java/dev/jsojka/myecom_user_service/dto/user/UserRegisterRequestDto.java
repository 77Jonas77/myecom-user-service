package dev.jsojka.myecom_user_service.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import dev.jsojka.myecom_user_service.model.UserEntity;
import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link UserEntity}
 */
@Builder
public record UserRegisterRequestDto(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank String imageUrl,
        @NotBlank @Email String email,
        @NotBlank String phone
) implements Serializable {
}