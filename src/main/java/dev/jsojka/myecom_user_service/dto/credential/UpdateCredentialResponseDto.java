package dev.jsojka.myecom_user_service.dto.credential;

import dev.jsojka.myecom_user_service.model.UserRole;
import lombok.Builder;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

/**
 * DTO for {@link dev.jsojka.myecom_user_service.model.CredentialEntity}
 */
@Builder
public record UpdateCredentialResponseDto(Instant createdAt, Instant updatedAt, Integer id, String username,
                                          String password, UserRole role, Boolean isEnabled,
                                          Boolean isAccountNonExpired, Boolean isAccountNonLocked,
                                          Boolean isCredentialsNonExpired, UUID userId) implements Serializable {
}