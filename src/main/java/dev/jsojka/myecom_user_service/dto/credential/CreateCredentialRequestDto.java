package dev.jsojka.myecom_user_service.dto.credential;

import dev.jsojka.myecom_user_service.model.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CreateCredentialRequestDto(
        @NotBlank String username,
        @NotBlank String password,
        @NotBlank UserRole role
) {
}
