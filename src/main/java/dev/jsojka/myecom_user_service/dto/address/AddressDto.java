package dev.jsojka.myecom_user_service.dto.address;

import dev.jsojka.myecom_user_service.model.AddressEntity;
import lombok.Builder;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Builder
/**
 * DTO for {@link AddressEntity}
 */
public record AddressDto(Instant createdAt, Instant updatedAt, Integer addressId, String fullAddress,
                         String postalCode, String city, UUID userId) implements Serializable {
}