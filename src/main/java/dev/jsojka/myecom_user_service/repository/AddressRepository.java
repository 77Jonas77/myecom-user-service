package dev.jsojka.myecom_user_service.repository;

import dev.jsojka.myecom_user_service.dto.address.AddressDto;
import dev.jsojka.myecom_user_service.dto.address.CreateAddressRequestDto;

import java.util.List;
import java.util.UUID;

public interface AddressRepository {
    AddressDto save(UUID userId, CreateAddressRequestDto requestDTO);

    List<AddressDto> findByUserId(UUID userId);

    void deleteByAddressIdAndUserId(Integer addressId, UUID userId);
}
