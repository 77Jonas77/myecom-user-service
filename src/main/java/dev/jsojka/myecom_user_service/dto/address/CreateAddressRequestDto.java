package dev.jsojka.myecom_user_service.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;
import java.util.UUID;

public record CreateAddressRequestDto(
        @NotBlank String fullAddress,
        // educational use of pattern, could use custom Annotation in more complex problem
        @NotBlank @Pattern(regexp = "\\d{2}-\\d{3}", message = "Postal code must use format XX-XXX") String postalCode,
        @NotBlank String city
) implements Serializable {
}
