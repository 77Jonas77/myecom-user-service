package dev.jsojka.myecom_user_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Getter // @Data
@Setter
@Entity
@Table(name = "credentials", schema = "users")
@NoArgsConstructor
@AllArgsConstructor
public class CredentialEntity implements Serializable {
    @Id
    @Column(name = "credential_id", nullable = false)
    private UUID id;

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "password", nullable = false, length = Integer.MAX_VALUE)
    private String password;

    @Column(name = "role", length = 50)
    private String role;

    @ColumnDefault("true")
    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @ColumnDefault("true")
    @Column(name = "is_account_non_expired")
    private Boolean isAccountNonExpired;

    @ColumnDefault("true")
    @Column(name = "is_account_non_locked")
    private Boolean isAccountNonLocked;

    @ColumnDefault("true")
    @Column(name = "is_credentials_non_expired")
    private Boolean isCredentialsNonExpired;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("now()")
    @Column(name = "updated_at")
    private Instant updatedAt;

}