package dev.jsojka.myecom_user_service.dto.credential;

import dev.jsojka.myecom_user_service.model.UserRole;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

@Builder
public record CredentialDto(
        Integer id,
        String username,
        String password,
        UserRole role,
        Boolean isEnabled,
        Boolean isAccountNonExpired,
        Boolean isAccountNonLocked,
        Boolean isCredentialsNonExpired,
        Instant createdAt,
        Instant updatedAt,
        UUID userId
) {
}
