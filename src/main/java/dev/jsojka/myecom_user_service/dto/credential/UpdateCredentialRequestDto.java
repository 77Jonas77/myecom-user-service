package dev.jsojka.myecom_user_service.dto.credential;

import dev.jsojka.myecom_user_service.model.UserRole;

import java.io.Serializable;

/**
 * DTO for {@link dev.jsojka.myecom_user_service.model.CredentialEntity}
 */
public record UpdateCredentialRequestDto(String username, String password, UserRole role, Boolean isEnabled,
                                         Boolean isAccountNonExpired, Boolean isAccountNonLocked,
                                         Boolean isCredentialsNonExpired) implements Serializable {
}