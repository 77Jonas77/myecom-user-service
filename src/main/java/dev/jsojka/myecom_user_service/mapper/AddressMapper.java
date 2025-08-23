package dev.jsojka.myecom_user_service.mapper;

import dev.jsojka.myecom_user_service.dto.address.AddressDto;
import dev.jsojka.myecom_user_service.dto.address.CreateAddressRequestDto;
import dev.jsojka.myecom_user_service.model.AddressEntity;
import dev.jsojka.myecom_user_service.model.UserEntity;

import java.util.Optional;

public interface AddressMapper {
    AddressEntity createAddressRequestDtoAndUserToAddressEntity(CreateAddressRequestDto requestDTO, Optional<UserEntity> userEntity);

    AddressDto addressEntityToAddressDTO(AddressEntity address);
}
