package dev.jsojka.myecom_user_service.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateUserDto(@NotBlank String firstName,
                            @NotBlank String lastName,
                            @NotBlank String imageUrl,
                            @NotBlank @Email String email,
                            @NotBlank String phone
) {
}
