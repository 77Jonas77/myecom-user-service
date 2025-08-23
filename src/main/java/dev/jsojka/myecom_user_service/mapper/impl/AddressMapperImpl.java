package dev.jsojka.myecom_user_service.mapper.impl;

import dev.jsojka.myecom_user_service.dto.address.AddressDto;
import dev.jsojka.myecom_user_service.dto.address.CreateAddressRequestDto;
import dev.jsojka.myecom_user_service.mapper.AddressMapper;
import dev.jsojka.myecom_user_service.model.AddressEntity;
import dev.jsojka.myecom_user_service.model.UserEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressEntity createAddressRequestDtoAndUserToAddressEntity(CreateAddressRequestDto requestDTO, Optional<UserEntity> userEntity) {
        return AddressEntity.builder()
                .fullAddress(requestDTO.fullAddress())
                .postalCode(requestDTO.postalCode())
                .city(requestDTO.city())
                .user(userEntity.get())
                .build();
    }

    @Override
    public AddressDto addressEntityToAddressDTO(AddressEntity address) {
        return AddressDto.builder()
                .addressId(address.getAddressId())
                .fullAddress(address.getFullAddress())
                .postalCode(address.getPostalCode())
                .city(address.getCity())
                .userId(address.getUser().getId())
                .createdAt(address.getCreatedAt())
                .updatedAt(address.getUpdatedAt())
                .build();
    }
}
