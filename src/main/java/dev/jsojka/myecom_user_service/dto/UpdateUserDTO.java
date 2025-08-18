package dev.jsojka.myecom_user_service.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.UUID;

public record UpdateUserDTO(@NotBlank String firstName,
                            @NotBlank String lastName,
                            @NotBlank String imageUrl,
                            @NotBlank @Email String email,
                            @NotBlank String phone
) {
}
