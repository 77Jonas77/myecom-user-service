package dev.jsojka.myecom_user_service.dto;

import dev.jsojka.myecom_user_service.model.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateCredentialRequestDTO(
        @NotBlank String username,
        @NotBlank String password,
        @NotBlank UserRole role
) {
}
