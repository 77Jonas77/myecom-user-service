package dev.jsojka.myecom_user_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Getter // @Data
@Setter
@Entity
@Table(name = "credentials", schema = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CredentialEntity extends AbstractEntitySuperclass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credential_id", unique = true, nullable = false, updatable = false)
    private Integer id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false, length = Integer.MAX_VALUE)
    private String password;

    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column(name = "role")
    private UserRole role;

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

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}