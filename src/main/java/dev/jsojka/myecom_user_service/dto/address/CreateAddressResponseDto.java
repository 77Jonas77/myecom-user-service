package dev.jsojka.myecom_user_service.dto.address;

import lombok.Builder;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link dev.jsojka.myecom_user_service.model.AddressEntity}
 */
@Builder
public record CreateAddressResponseDto(
        Integer addressId,
        String fullAddress,
        String postalCode,
        String city,
        UUID userId
) implements Serializable {
}