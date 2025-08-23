package dev.jsojka.myecom_user_service.repository;

import dev.jsojka.myecom_user_service.model.CredentialEntity;
import dev.jsojka.myecom_user_service.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CredentialRepositoryJpa extends JpaRepository<CredentialEntity, Integer> {

    CredentialEntity findByUserId(UUID userId);

    @Modifying
    @Query("update CredentialEntity c set c.username=:username, c.password=:password, c.role=:role, " +
            "c.isCredentialsNonExpired=:credentialsNonExpired, c.isAccountNonExpired=:accountNonExpired," +
            "c.isAccountNonLocked=:accountNonLocked, c.isEnabled=:enabled where c.user.id=:userId")
    void update(
            @Param("username") String username,
            @Param("password") String password,
            @Param("role") UserRole role,
            @Param("credentialsNonExpired") Boolean credentialsNonExpired,
            @Param("accountNonExpired") Boolean accountNonExpired,
            @Param("accountNonLocked") Boolean accountNonLocked,
            @Param("enabled") Boolean enabled,
            @Param("userId") UUID userId);

    void deleteByUserId(UUID user_id);
}
